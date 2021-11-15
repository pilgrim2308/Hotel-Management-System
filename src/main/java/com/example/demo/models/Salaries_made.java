package com.example.demo.models;



public class Salaries_made {

	private String payment_ID;
	private String Employee_ID;
	
	public Salaries_made() {
		super();
	
	}
	
	
	public Salaries_made(String payment_ID, String employee_ID) {
		super();
		this.payment_ID = payment_ID;
		Employee_ID = employee_ID;
	}
	public String getPayment_ID() {
		return payment_ID;
	}
	public void setPayment_ID(String payment_ID) {
		this.payment_ID = payment_ID;
	}
	public String getEmployee_ID() {
		return Employee_ID;
	}
	public void setEmployee_ID(String employee_ID) {
		Employee_ID = employee_ID;
	}
	
	

}
