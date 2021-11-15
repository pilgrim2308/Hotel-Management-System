package com.example.demo.models;

public class Customer_email {
	private String Email;

	private String Cust_ID;
	
	public Customer_email() {
		super();
	
	}
	public Customer_email(String email, String cust_ID) {
		super();
		Email = email;
		Cust_ID = cust_ID;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCust_ID() {
		return Cust_ID;
	}
	public void setCust_ID(String cust_ID) {
		Cust_ID = cust_ID;
	}
}
