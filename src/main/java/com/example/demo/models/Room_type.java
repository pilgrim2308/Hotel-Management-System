package com.example.demo.models;

public class Room_type {
	private Integer priviledge_level;
	private Integer Total_count;
	private Integer Price;
	private Boolean ac;
	private String photo_url;
	
	public Room_type() {
		super();
	
	}
	

	public Room_type(Integer priviledge_level, Integer total_count, Integer price, Boolean ac, String photo_url) {
		super();
		this.priviledge_level = priviledge_level;
		Total_count = total_count;
		Price = price;
		this.ac = ac;
		this.photo_url = photo_url;
	}


	public Boolean getAc() {
		return ac;
	}


	public void setAc(Boolean ac) {
		this.ac = ac;
	}


	public String getPhoto_url() {
		return photo_url;
	}


	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}


	public Integer getPriviledge_level() {
		return priviledge_level;
	}
	public void setPriviledge_level(Integer priviledge_level) {
		this.priviledge_level = priviledge_level;
	}
	public Integer getTotal_count() {
		return Total_count;
	}
	public void setTotal_count(Integer total_count) {
		Total_count = total_count;
	}
	public Integer getPrice() {
		return Price;
	}
	public void setPrice(Integer price) {
		Price = price;
	}
	
	

}
