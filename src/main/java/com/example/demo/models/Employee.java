package com.example.demo.models;

import java.sql.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;


public class Employee {
	
	@NotEmpty(message="required")
	private String employee_id;
	private String first_name;
	
	private String last_name;
	private String house_no;
	private String street;
	private String city;
	private String gender;

	private Integer Pincode ;
	
	private Date DOB;
	private Date joining_date;
	private String DP_URL;
	private Boolean attendance;
    private Integer priviledge_level;
	private String current_status;
	
	private String Bank_reference_no;
	
	//for form purposes of user info
	private String password;
	private String role;
	
	public Employee() {
		super();
		this.priviledge_level=1;
		
	}

	public Employee(@NotEmpty(message = "required") String employee_id, String first_name, String last_name,
			String house_no, String street, String city, String gender, Integer pincode, Date dOB, Date joining_date,
			String dP_URL, Boolean attendance, Integer priviledge_level, String current_status,
			String bank_reference_no, String password, String role) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.house_no = house_no;
		this.street = street;
		this.city = city;
		this.gender = gender;
		Pincode = pincode;
		DOB = dOB;
		this.joining_date = joining_date;
		DP_URL = dP_URL;
		this.attendance = attendance;
		this.priviledge_level = priviledge_level;
		this.current_status = current_status;
		Bank_reference_no = bank_reference_no;
		this.password = password;
		this.role = role;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getHouse_no() {
		return house_no;
	}

	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getPincode() {
		return Pincode;
	}

	public void setPincode(Integer pincode) {
		Pincode = pincode;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public Date getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(Date joining_date) {
		this.joining_date = joining_date;
	}

	public String getDP_URL() {
		return DP_URL;
	}

	public void setDP_URL(String dP_URL) {
		DP_URL = dP_URL;
	}

	public Boolean getAttendance() {
		return attendance;
	}

	public void setAttendance(Boolean attendance) {
		this.attendance = attendance;
	}

	public Integer getPriviledge_level() {
		return priviledge_level;
	}

	public void setPriviledge_level(Integer priviledge_level) {
		this.priviledge_level = priviledge_level;
	}

	public String getCurrent_status() {
		return current_status;
	}

	public void setCurrent_status(String current_status) {
		this.current_status = current_status;
	}

	public String getBank_reference_no() {
		return Bank_reference_no;
	}

	public void setBank_reference_no(String bank_reference_no) {
		Bank_reference_no = bank_reference_no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



    
	
	
	
	
	

}
