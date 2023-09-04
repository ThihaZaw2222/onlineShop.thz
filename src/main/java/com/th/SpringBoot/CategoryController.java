package com.th.SpringBoot;

import java.util.ArrayList;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/Category")

public class CategoryController {

	@Autowired
	 private CategoryService service;
	
	@Autowired
	private OrderDetailsService orderdetailsService;
	
	@Autowired
	private OrdersService orderservice;
	
	@GetMapping("/")
	public  String showhomePage() {
		return "homePage";
		
	}
	@GetMapping("/ContactAs")
	public String contactas() {
		return "ContactAs";
		
	}
	@GetMapping("/allCategory")
	public String getAllCategory(Model model) {
		List<Category>  category =service.getAllCategory();
		model.addAttribute("list",category);
		return "allCategory";
		
	}
	
	
	@GetMapping("/getById")
	public String getbyId(Model model, @RequestParam String id){
		
		Category category=service.getByItemId(id);
		model.addAttribute("category", category);
		
		return "shopping";
	}
	@RequestMapping("/addtocart")
	public String addtocart(HttpServletRequest request,HttpSession session,@ModelAttribute Category category) {
		Item item=new Item();
		
		item.setItemId(category.getItemID());
		item.setBrandname(category.getBrandname());
		item.setPrice(category.getPrice());
		item.setQty(Integer.parseInt(request.getParameter("qty")));
		double amount=category.getPrice()*Integer.parseInt(request.getParameter("qty"));
		item.setAmount(amount);
		
		Cart sesscart=(Cart)(session.getAttribute("cart"));
		
		if(sesscart==null) {
		
			Cart cart=new Cart();
			cart.addItem(item);
			session.setAttribute("cart", cart);
			
		}else {
			Cart cart=(Cart)(session.getAttribute("cart"));
			cart.addItem(item);
			session.setAttribute("cart",  cart);
		}
		
		return "redirect:viewcart";
		
		
	}
	@GetMapping("/viewcart")
	public String viewCart(HttpServletRequest request,Model model) {
		HttpSession session=request.getSession();
		Cart sesscart=(Cart)(session.getAttribute("cart"));
		List<Item> list=(List<Item>)sesscart.getAllItem();
		model.addAttribute("list",list);
		return "viewcart";
		
	}
	public List<Item> veiwcartdata(HttpServletRequest request){
	HttpSession session=request.getSession();
	Cart sesscart=(Cart)(session.getAttribute("cart"));
	List<Item> list=(List<Item>)sesscart.getAllItem();
	
	return list;
	}
	@GetMapping("/remove")
	public String removebyid( HttpSession session,@RequestParam String id) {
		Cart sesscart=(Cart)(session.getAttribute("cart"));
		Item item=new Item();
		item=(Item)sesscart.getItemById(id);
		sesscart.removeItem(item);
		return "redirect:viewcart";
		
	}
	@GetMapping("/Checkout")
	public String checkout(HttpSession session, HttpServletRequest request,Model model) {
		Cart sesscart=(Cart)(session.getAttribute("cart"));
		if(sesscart!=null) {
		List<Item> list=veiwcartdata(request);
		model.addAttribute("list",list);
		}
		
				return "checkout";
		
	}
	
	
	@PostMapping("/save")
	public String saveorder(@ModelAttribute Orders orders ,HttpSession session,HttpServletRequest request) {
		Orders order=new Orders();
		order.setContactName(orders.getContactName());
		order.setAddress(orders.getAddress());
		order.setPhone(orders.getPhone());
		order.setEmail(orders.getEmail());
		order.setOrderDate(orders.getOrderDate());
		orderservice.saveOrders(order);
		
		List<Orders> orderList=orderservice.getAllOrders();
		Orders od=orderList.get(orderList.size()-1);
		int id=od.getOrderId();
		
		HttpSession session1=request.getSession();
		Cart sessioncart=(Cart)session1.getAttribute("cart");
		List<Item> list=sessioncart.getAllItem();
		List<OrderDetails> orderdetails=new ArrayList<OrderDetails>();
		for(Item cart:list) {
			orderdetails.add(new OrderDetails(id, cart.getItemId(),cart.getPrice(),cart.getQty(),cart.getAmount()));
		}
		orderdetailsService.SaveOrderDetails(orderdetails);
		
		return "thank";
		
	
	}
	
	@GetMapping("/logout")
	
	public String logout() {
		return "logout";
		
	}
	
}




 
	