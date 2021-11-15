package com.example.demo.models;

public class Products {
	private String Product_ID;

	private String Name;
	private String Description;
	private int Price;
	private int Inventory_ID;
	private int quantity;
	private String current_incharge;
	
	
	public Products() {
		super();
		
	}

	
	public Products(String product_ID, String name, String description, int price, int inventory_ID, int quantity,
			String current_incharge) {
		super();
		Product_ID = product_ID;
		Name = name;
		Description = description;
		Price = price;
		Inventory_ID = inventory_ID;
		this.quantity = quantity;
		this.current_incharge = current_incharge;
	}


	public String getProduct_ID() {
		return Product_ID;
	}

	public void setProduct_ID(String product_ID) {
		Product_ID = product_ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public int getInventory_ID() {
		return Inventory_ID;
	}

	public void setInventory_ID(int inventory_ID) {
		Inventory_ID = inventory_ID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCurrent_incharge() {
		return current_incharge;
	}

	public void setCurrent_incharge(String current_incharge) {
		this.current_incharge = current_incharge;
	}

	
	
}
