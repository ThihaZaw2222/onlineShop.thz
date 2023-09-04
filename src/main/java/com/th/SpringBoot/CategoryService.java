package com.th.SpringBoot;

import java.util.List;


import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

	public List<Category>getAllCategory();
	public Category getByItemId(String ItemId);
	
}
