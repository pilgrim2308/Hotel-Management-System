package com.example.demo.models;

public class Books_room {
	private String Booking_ID;
	private String ROOM_ID;
	
	public Books_room() {
		super();
	
	}
	public Books_room(String booking_ID, String rOOM_ID) {
		super();
		Booking_ID = booking_ID;
		ROOM_ID = rOOM_ID;
	}
	public String getBooking_ID() {
		return Booking_ID;
	}
	public void setBooking_ID(String booking_ID) {
		Booking_ID = booking_ID;
	}
	public String getROOM_ID() {
		return ROOM_ID;
	}
	public void setROOM_ID(String rOOM_ID) {
		ROOM_ID = rOOM_ID;
	}
	

}
