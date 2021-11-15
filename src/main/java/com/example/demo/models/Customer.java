package com.example.demo.models;

import java.sql.Date;


public class Customer {
	
	private String Cust_ID;
	private String first_name;
	private String last_name;

	private String house_no;
	private String Street;
	private String city;
	private int Pincode;
	private String DP_URL;
	private int Age;
	private String Bank_Ref_No;
	
	
	private Date DOB;
	
	private String password;
	
	
	public Customer(String cust_ID, String first_name, String last_Name, String house_No, String street, String city,
			int pincode, String dP_URL, int age, String bank_Ref_No, Date dOB, String password) {
		super();
		Cust_ID = cust_ID;
		this.first_name = first_name;
		this.last_name = last_Name;
		house_no = house_No;
		Street = street;
		this.city = city;
		Pincode = pincode;
		DP_URL = dP_URL;
		Age = age;
		Bank_Ref_No = bank_Ref_No;
		DOB = dOB;
		this.password = password;
	}

	public Customer() {
		
	}

	public String getCust_ID() {
		return Cust_ID;
	}

	public void setCust_ID(String cust_ID) {
		Cust_ID = cust_ID;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_Name) {
		this.last_name = last_Name;
	}

	public String getHouse_no() {
		return house_no;
	}

	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return Pincode;
	}

	public void setPincode(int pincode) {
		Pincode = pincode;
	}

	public String getDP_URL() {
		return DP_URL;
	}

	public void setDP_URL(String dP_URL) {
		DP_URL = dP_URL;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getBank_Ref_No() {
		return Bank_Ref_No;
	}

	public void setBank_Ref_No(String bank_Ref_No) {
		Bank_Ref_No = bank_Ref_No;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	


}
