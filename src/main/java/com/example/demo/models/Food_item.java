package com.example.demo.models;

public class Food_item {
	private String Name;
	private String Food_item_id;
	private String Description;
	private int Price;
	
	public Food_item() {
		super();
	
	}
	public Food_item(String name, String food_item_id, String description, int price) {
		super();
		Name = name;
		Food_item_id = food_item_id;
		Description = description;
		Price = price;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getFood_item_id() {
		return Food_item_id;
	}
	public void setFood_item_id(String food_item_id) {
		Food_item_id = food_item_id;
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

}
