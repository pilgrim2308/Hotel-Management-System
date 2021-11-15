package com.example.demo.models;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;


public class Booking {
	private String booking_id;
	private Integer no_of_members;
	
	private Date booking_date;
	private Time booking_time;
	
	private Date start_date;
	
	private Date end_date;
	
	private String purpose_of_visit;
	
	
	private Time checkin;
	
	private Time checkout;
	
	private String payment_status;
	private Boolean coupon_special;
	
	private String customer_id;
	private List<Room_booking> rooms;
	public Booking() {
		super();
		this.rooms=new ArrayList<Room_booking>();
	}

	public Booking(String booking_id, Integer no_of_members, Date booking_date, Time booking_time, Date start_date,
			Date end_date, String purpose_of_visit, Time checkin, Time checkout, String payment_status,
			Boolean coupon_special, String customer_id) {
		super();
		this.booking_id = booking_id;
		this.no_of_members = no_of_members;
		this.booking_date = booking_date;
		this.booking_time = booking_time;
		this.start_date = start_date;
		this.end_date = end_date;
		this.purpose_of_visit = purpose_of_visit;
		this.checkin = checkin;
		this.checkout = checkout;
		this.payment_status = payment_status;
		this.coupon_special = coupon_special;
		this.customer_id = customer_id;
	}
	
	public List<Room_booking> getRooms() {
		return rooms;
	}
	public void setRoomslist(List<Room_booking> room) {
		
	this.rooms=room;
		
	}
	public int roomcount(int id)
	{
		for(int i=0;i<rooms.size();i++)
		{
			if(rooms.get(i).getPriviledge_level()==id)
			{
				return rooms.get(i).getCount();
				
							
			}
		}
		return 0;
	
		
	}
	public void addRooms(Room_booking room) {
	
		for(int i=0;i<rooms.size();i++)
		{
			if(rooms.get(i).getPriviledge_level()==room.getPriviledge_level())
			{
				rooms.get(i).setCount(rooms.get(i).getCount()+room.getCount());
				return;
							
			}
		}
		rooms.add(room);
		
	}
	public void removeRooms(int priv_lvl) {
		
		for(int i=0;i<rooms.size();i++)
		{
			if(rooms.get(i).getPriviledge_level()==priv_lvl)
			{
				rooms.get(i).setCount(0);
							
			}
		}
	}

	public String getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}

	public Integer getNo_of_members() {
		return no_of_members;
	}

	public void setNo_of_members(Integer no_of_members) {
		this.no_of_members = no_of_members;
	}

	public Date getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}

	public Time getBooking_time() {
		return booking_time;
	}

	public void setBooking_time(Time booking_time) {
		this.booking_time = booking_time;
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

	public String getPurpose_of_visit() {
		return purpose_of_visit;
	}

	public void setPurpose_of_visit(String purpose_of_visit) {
		this.purpose_of_visit = purpose_of_visit;
	}

	public Time getCheckin() {
		return checkin;
	}

	public void setCheckin(Time checkin) {
		this.checkin = checkin;
	}

	public Time getCheckout() {
		return checkout;
	}

	public void setCheckout(Time checkout) {
		this.checkout = checkout;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public Boolean getCoupon_special() {
		return coupon_special;
	}

	public void setCoupon_special(Boolean coupon_special) {
		this.coupon_special = coupon_special;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	
	
	
	

}
