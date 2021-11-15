package com.example.demo.models;

public class Allotment_list {
	private String Cust_ID;
	private String ROOM_ID;
	
	public Allotment_list() {
		super();
	
	}
	public Allotment_list(String cust_ID, String rOOM_ID) {
		super();
		Cust_ID = cust_ID;
		ROOM_ID = rOOM_ID;
	}
	public String getCust_ID() {
		return Cust_ID;
	}
	public void setCust_ID(String cust_ID) {
		Cust_ID = cust_ID;
	}
	public String getROOM_ID() {
		return ROOM_ID;
	}
	public void setROOM_ID(String rOOM_ID) {
		ROOM_ID = rOOM_ID;
	}


}
