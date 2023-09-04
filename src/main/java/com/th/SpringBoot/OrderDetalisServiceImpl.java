package com.th.SpringBoot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetalisServiceImpl implements OrderDetailsService{
	@Autowired
	OrderDetailsRepository repo;

	@Override
	public void SaveOrderDetails(List<OrderDetails> orderdetails) {
		repo.saveAll(orderdetails);
		
	}

	
	
	
	

	
	
	
	}
	

