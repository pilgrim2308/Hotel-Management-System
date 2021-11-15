package com.example.demo.models;

import java.sql.Date;

public class Room_booking {
	private Integer priviledge_level;
	private String booking_id;
	private Integer count;
	private Date start_date;
	private Date end_date;
	private Boolean Confirmed;
	
	public Room_booking() {
		super();
		this.Confirmed=false;
	
	
	}
	

	public Room_booking(Integer priviledge_level, String booking_id, Integer count, Date start_date, Date end_date) {
		super();
		this.priviledge_level = priviledge_level;
		this.booking_id = booking_id;
		this.count = count;
		this.start_date = start_date;
		this.end_date = end_date;
		this.Confirmed=false;
	}


	public Integer getPriviledge_level() {
		return priviledge_level;
	}

	public void setPriviledge_level(Integer priviledge_level) {
		this.priviledge_level = priviledge_level;
	}

	public String getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}


	public Boolean getConfirmed() {
		return Confirmed;
	}


	public void setConfirmed(Boolean confirmed) {
		Confirmed = confirmed;
	}



	
}
