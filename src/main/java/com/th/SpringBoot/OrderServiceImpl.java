package com.th.SpringBoot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderservice")
public class OrderServiceImpl implements OrdersService{

	
	@Autowired
	private OrderRepository repo;
	@Override
	public void saveOrders(Orders order) {

		 repo.save(order);
	}
	@Override
	public List<Orders> getAllOrders() {
		return repo.findAll();
	}

}
