package com.example.demo.models;

import java.sql.Time;

import java.sql.Date;

public class Payment {
	
	
	private String payment_id;
	private String modeofpayment;
	private String status;
	private String type;
	private Date date;
	private Time time;
	private Integer amount;
	private String customer_id;
	private String booking_id;
	private Integer Bill_no;
    
	
	
	public Payment() {
		this.type="credit";
		this.status="initiated";
		this.Bill_no= null;
	
	}
	
	
	public Payment(String payment_id, String modeofpayment, String status, String type, Date date, Time time,
			Integer amount, String customer_id, String booking_id, Integer bill_no) {
		super();
		this.payment_id = payment_id;
		this.modeofpayment = modeofpayment;
		this.status = status;
		this.type = type;
		this.date = date;
		this.time = time;
		this.amount = amount;
		this.customer_id = customer_id;
		this.booking_id = booking_id;
		Bill_no = bill_no;
	}
	public String getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}
	public String getModeofpayment() {
		return modeofpayment;
	}
	public void setModeofpayment(String modeofpayment) {
		this.modeofpayment = modeofpayment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}
	public Integer getBill_no() {
		return Bill_no;
	}
	public void setBill_no(Integer bill_no) {
		Bill_no = bill_no;
	}
	
	
	

}
