package com.th.SpringBoot;



public class Item {

	private String ItemId;
	private String brandname;
	private Integer Qty;
	private double price;
	private double amount;
	public String getItemId() {
		return ItemId;
	}
	public void setItemId(String ItemId) {
		this.ItemId = ItemId;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public Integer getQty() {
		return Qty;
	}
	public void setQty(Integer Qty) {
		this.Qty = Qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}

