package com.example.demo.models;

public class Employee_email {
	private String Email;
	private String Employee_ID;
	public Employee_email() {
		super();
		
	}
	public Employee_email(String email, String employee_ID) {
		super();
		Email = email;
		Employee_ID = employee_ID;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getEmployee_ID() {
		return Employee_ID;
	}
	public void setEmployee_ID(String employee_ID) {
		Employee_ID = employee_ID;
	}
	
}
