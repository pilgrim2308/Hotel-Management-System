package com.example.demo.models;

import java.sql.Time;
import java.util.Date;

public class Invoice {
	

	private String invoice_id;


	private Date date;
	private Time time;
	private Integer amount;
	private String customer_id;
	private String payment_id;
	private Integer tax;
	
	public Invoice() {
		super();
		
	}
	public Invoice(String invoice_id, Date date, Time time, Integer amount, String customer_id, String payment_id,
			Integer tax) {
		super();
		this.invoice_id = invoice_id;
		this.date = date;
		this.time = time;
		this.amount = amount;
		this.customer_id = customer_id;
		this.payment_id = payment_id;
		this.tax = tax;
	}
	public String getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(String invoice_id) {
		this.invoice_id = invoice_id;
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
	public String getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}
	public Integer getTax() {
		return tax;
	}
	public void setTax(Integer tax) {
		this.tax = tax;
	}

}
