package com.example.demo.models;

import java.sql.Time;
public class Feedback {
	private String Feedback_ID;
	
	private int Service_Rating;
	private int Hotel_Rating;
	private String Comments;
	private java.sql.Date Date;
	private Time Time;
	private String Booking_ID;
	private String Cust_ID;
	
	
	public Feedback() {
	
	}
	
	
	
	
	public Feedback(String feedback_ID, int service_Rating, int hotel_Rating, String comments, java.sql.Date date,
			Time time, String booking_ID, String cust_ID) {
		super();
		Feedback_ID = feedback_ID;
		Service_Rating = service_Rating;
		Hotel_Rating = hotel_Rating;
		Comments = comments;
		Date = date;
		Time = time;
		Booking_ID = booking_ID;
		Cust_ID = cust_ID;
	}
	public String getFeedback_ID() {
		return Feedback_ID;
	}
	public void setFeedback_ID(String feedback_ID) {
		Feedback_ID = feedback_ID;
	}
	public int getService_Rating() {
		return Service_Rating;
	}
	public void setService_Rating(int service_Rating) {
		Service_Rating = service_Rating;
	}
	public int getHotel_Rating() {
		return Hotel_Rating;
	}
	public void setHotel_Rating(int hotel_Rating) {
		Hotel_Rating = hotel_Rating;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	public java.sql.Date getDate() {
		return Date;
	}
	public void setDate(java.sql.Date date) {
		Date = date;
	}
	public Time getTime() {
		return Time;
	}
	public void setTime(Time time) {
		Time = time;
	}
	public String getBooking_ID() {
		return Booking_ID;
	}
	public void setBooking_ID(String booking_ID) {
		Booking_ID = booking_ID;
	}
	public String getCust_ID() {
		return Cust_ID;
	}
	public void setCust_ID(String cust_ID) {
		Cust_ID = cust_ID;
	}


}
