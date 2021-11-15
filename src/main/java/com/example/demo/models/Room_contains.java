package com.example.demo.models;

public class Room_contains {

	private int Quantity;
	private String ROOM_ID;
	private String Product_ID;
	
	public Room_contains() {
		super();
	}
	public Room_contains(int quantity, String rOOM_ID, String product_ID) {
		super();
		Quantity = quantity;
		ROOM_ID = rOOM_ID;
		Product_ID = product_ID;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getROOM_ID() {
		return ROOM_ID;
	}
	public void setROOM_ID(String rOOM_ID) {
		ROOM_ID = rOOM_ID;
	}
	public String getProduct_ID() {
		return Product_ID;
	}
	public void setProduct_ID(String string) {
		Product_ID = string;
	}

}
