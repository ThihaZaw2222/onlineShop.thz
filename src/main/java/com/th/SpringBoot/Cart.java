package com.th.SpringBoot;

import java.util.ArrayList;

  

import java.util.List;

public class Cart {

	private List<Item> list=new ArrayList<Item>();
	
	public Cart() {
	
	}
	public void addItem(Item item) {
		list.add(item);
	}
	public void removeItem(Item item) {
		list.remove(item);
	}
	public Item getItemById(String id){
		Item item=null;
		for(Item ite:list) {
			if(ite.getItemId().equals(id))
			item=ite;
		}
		return item;
		
	}
	public List<Item>getAllItem(){
		return list;
		
	}
}
