package com.example.demo.models;

public class Order_item {
	
	private int Quantity;
	private int item_ID;
	private int Order_No;
	private String Food_item_id;
	private int price;
	public Order_item() {
		super();
	
	}
	
	
	public Order_item(int quantity, int item_ID, int order_No, String food_item_id) {
		super();
		Quantity = quantity;
		this.item_ID = item_ID;
		Order_No = order_No;
		Food_item_id = food_item_id;
		
	}


	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getItem_ID() {
		return item_ID;
	}
	public void setItem_ID(int item_ID) {
		this.item_ID = item_ID;
	}
	public int getOrder_No() {
		return Order_No;
	}
	public void setOrder_No(int order_No) {
		Order_No = order_No;
	}
	public String getFood_item_id() {
		return Food_item_id;
	}
	public void setFood_item_id(String food_item_id) {
		Food_item_id = food_item_id;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	

}
