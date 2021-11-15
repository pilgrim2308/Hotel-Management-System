package com.example.demo.models;

public class Inventory {
	private int Quantity;

	private int Inventory_ID;
	private String Current_Incharge;

	public Inventory() {
		super();
	}
	
	public Inventory(int quantity, int inventory_ID, String current_Incharge) {
		super();
		Quantity = quantity;
		Inventory_ID = inventory_ID;
		Current_Incharge = current_Incharge;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getInventory_ID() {
		return Inventory_ID;
	}
	public void setInventory_ID(int inventory_ID) {
		Inventory_ID = inventory_ID;
	}
	public String getCurrent_Incharge() {
		return Current_Incharge;
	}
	public void setCurrent_Incharge(String current_Incharge) {
		Current_Incharge = current_Incharge;
	}

}
