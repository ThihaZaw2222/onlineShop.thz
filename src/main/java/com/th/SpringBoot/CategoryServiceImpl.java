package com.th.SpringBoot;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepostory repo;
	@Override
	public List<Category> getAllCategory() {
		return repo.findAll();
	}
	@Override
	public Category getByItemId(String ItemID) {
		return repo.getById(ItemID);
	}
	

}
