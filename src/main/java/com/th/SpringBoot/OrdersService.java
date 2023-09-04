package com.th.SpringBoot;


import java.util.List;

import org.springframework.stereotype.Service;

@Service("orderservice")
public interface OrdersService {
	
	

	public void saveOrders(Orders order);
	public List<Orders> getAllOrders();
}
