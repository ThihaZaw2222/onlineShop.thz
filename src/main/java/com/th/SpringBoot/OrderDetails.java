package com.th.SpringBoot;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderDetails {
	
	@Id
	private Integer OrderID;
	private String ItemID;
	private double Price;
	private Integer Quantity;
	private double amount;
	
	public OrderDetails() {
		
	}
	
	public OrderDetails(int OrderID, String itemId, double price, Integer qty, double amount) {
	this.ItemID=itemId;
	this.Price=price;
	this.Quantity=qty;
	this.OrderID=OrderID;
	this.setAmount(amount);
	
	
	
	}
	public Integer getOrderID() {
		return OrderID;
	}
	public void setOrderID(Integer orderID) {
		OrderID = orderID;
	}
	public String getItemID() {
		return ItemID;
	}
	public void setItemID(String itemID) {
		ItemID = itemID;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public Integer getQuantity() {
		return Quantity;
	}
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
