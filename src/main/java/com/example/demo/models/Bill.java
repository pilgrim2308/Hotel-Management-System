package com.example.demo.models;

public class Bill {
	private int Bill_No;

	private int Price;
	private String Booking_ID;
	private int Order_No;
	private String Coupan_ID;
	public Bill() {
		super();
		this.Order_No=0;
		
	}
	
	public Bill(int bill_No, int price, String booking_ID, int order_No, String coupan_ID) {
		super();
		Bill_No = bill_No;
		Price = price;
		Booking_ID = booking_ID;
		Order_No = order_No;
		Coupan_ID = coupan_ID;
	}
	public int getBill_No() {
		return Bill_No;
	}
	public void setBill_No(int bill_No) {
		Bill_No = bill_No;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getBooking_ID() {
		return Booking_ID;
	}
	public void setBooking_ID(String booking_ID) {
		Booking_ID = booking_ID;
	}
	public int getOrder_No() {
		return Order_No;
	}
	public void setOrder_No(int order_No) {
		Order_No = order_No;
	}
	public String getCoupan_ID() {
		return Coupan_ID;
	}
	public void setCoupan_ID(String coupan_ID) {
		Coupan_ID = coupan_ID;
	}


}
