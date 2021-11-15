package com.example.demo.models;

import java.sql.Date;

public class Coupon {
	private String Name;

	private java.sql.Date Expire_Date;
	private String Coupan_ID;
	private String Description;
	private String Cust_ID;
	private int Discount_amount;
	
	public Coupon() {
		super();

	}

	public Coupon(String name, Date expire_Date, String coupan_ID, String description, String cust_ID,
			int discount_amount) {
		super();
		Name = name;
		Expire_Date = expire_Date;
		Coupan_ID = coupan_ID;
		Description = description;
		Cust_ID = cust_ID;
		Discount_amount = discount_amount;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public java.sql.Date getExpire_Date() {
		return Expire_Date;
	}

	public void setExpire_Date(java.sql.Date expire_Date) {
		Expire_Date = expire_Date;
	}

	public String getCoupan_ID() {
		return Coupan_ID;
	}

	public void setCoupan_ID(String coupan_ID) {
		Coupan_ID = coupan_ID;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getCust_ID() {
		return Cust_ID;
	}

	public void setCust_ID(String cust_ID) {
		Cust_ID = cust_ID;
	}

	public int getDiscount_amount() {
		return Discount_amount;
	}

	public void setDiscount_amount(int discount_amount) {
		Discount_amount = discount_amount;
	}
	



}
