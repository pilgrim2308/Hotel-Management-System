package com.example.demo.models;

public class Employee_phone {
	private String Phone_No;
	private String Employee_ID;
	
	public Employee_phone() {
		super();
		
	}
	public Employee_phone(String phone_No, String employee_ID) {
		super();
		Phone_No = phone_No;
		Employee_ID = employee_ID;
	}
	public String getPhone_No() {
		return Phone_No;
	}
	public void setPhone_No(String phone_No) {
		Phone_No = phone_No;
	}
	public String getEmployee_ID() {
		return Employee_ID;
	}
	public void setEmployee_ID(String employee_ID) {
		Employee_ID = employee_ID;
	}
	
}
