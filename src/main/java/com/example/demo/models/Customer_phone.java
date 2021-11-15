package com.example.demo.models;

public class Customer_phone {
	private String Phone_No;
	private String Cust_ID;
	
	
	
	public Customer_phone() {
		super();
	
	}
	
	
	
	
	
	public Customer_phone(String phone_No, String cust_ID) {
		super();
		Phone_No = phone_No;
		Cust_ID = cust_ID;
	}





	public String getPhone_No() {
		return Phone_No;
	}
	public void setPhone_No(String phone_No) {
		Phone_No = phone_No;
	}
	public String getCust_ID() {
		return Cust_ID;
	}
	public void setCust_ID(String cust_ID) {
		Cust_ID = cust_ID;
	}
	

	

}
