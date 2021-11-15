package com.example.demo.models;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


public class Food_orders {
	private int Order_No;
	private String Status;
	private int Total_Price;
	private java.sql.Date Date;
	private String ROOM_ID;
	private Time Time;
	private List<Order_item> items;
	
	public Food_orders() {
		super();
		setItems(new ArrayList<Order_item>());
	
	}
	
	public Food_orders(int order_No, String status, int total_Price, java.sql.Date date, String rOOM_ID,Time time) {
		super();
		Order_No = order_No;
		Status = status;
		Total_Price = total_Price;
		Date = date;
		ROOM_ID = rOOM_ID;
		Time=time;
	}
	public int getOrder_No() {
		return Order_No;
	}
	public void setOrder_No(int order_No) {
		Order_No = order_No;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getTotal_Price() {
		return Total_Price;
	}
	public void setTotal_Price(int total_Price) {
		Total_Price = total_Price;
	}
	public java.sql.Date getDate() {
		return Date;
	}
	public void setDate(java.sql.Date date) {
		Date = date;
	}
	public String getROOM_ID() {
		return ROOM_ID;
	}
	public void setROOM_ID(String rOOM_ID) {
		ROOM_ID = rOOM_ID;
	}

	public Time getTime() {
		return Time;
	}

	public void setTime(Time time) {
		Time = time;
	}

	public List<Order_item> getItems() {
		return items;
	}

	public void setItems(List<Order_item> items) {
		this.items = items;
	}
	public void addItem(String id,int price) {
		System.out.println(id);
		for(int i=0;i<items.size();i++)
		{
			
			
			if(items.get(i).getFood_item_id().equals(id))
			{
				items.get(i).setQuantity(items.get(i).getQuantity()+1);
				items.get(i).setPrice(items.get(i).getQuantity()*price);
				System.out.println("yes found");
				return;
			}
			
			
		}
		Order_item item= new Order_item();
		item.setQuantity(1);
		item.setFood_item_id(id);
		item.setPrice(item.getQuantity()*price);
		items.add(item);
		
	}
	public void removeItem(String id) {
		for(int i=0;i<items.size();i++)
		{
			if(items.get(i).getFood_item_id().equals(id))
			{
				items.remove(i);
				return;
			}
			
			
		}
	
	}

}
