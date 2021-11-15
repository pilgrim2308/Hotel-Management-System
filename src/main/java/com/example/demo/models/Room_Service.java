package com.example.demo.models;

import java.sql.Time;
public class Room_Service {
	private String Service_ID;

	private String Status;
	private String Demands;
	private java.sql.Date Date;
	private Time Time;
	private String Employee_ID;
	private String ROOM_ID;
	public Room_Service() {
		super();
	
	}
	public Room_Service(String service_ID, String status, String demands, java.sql.Date date, Time time,
			String employee_ID, String rOOM_ID) {
		super();
		Service_ID = service_ID;
		Status = status;
		Demands = demands;
		Date = date;
		Time = time;
		Employee_ID = employee_ID;
		ROOM_ID = rOOM_ID;
	}
	public String getService_ID() {
		return Service_ID;
	}
	public void setService_ID(String service_ID) {
		Service_ID = service_ID;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getDemands() {
		return Demands;
	}
	public void setDemands(String demands) {
		Demands = demands;
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
	public void setTime(java.sql.Time time2) {
		Time = time2;
	}
	public String getEmployee_ID() {
		return Employee_ID;
	}
	public void setEmployee_ID(String employee_ID) {
		Employee_ID = employee_ID;
	}
	public String getROOM_ID() {
		return ROOM_ID;
	}
	public void setROOM_ID(String rOOM_ID) {
		ROOM_ID = rOOM_ID;
	}

	
	

}
