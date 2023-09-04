package com.th.SpringBoot;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface OrderDetailsService {



	public void SaveOrderDetails(List<OrderDetails> orderdetails);
	
}
