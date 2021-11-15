package com.example.demo.models;

public class Room {
	    private String room_no;
		private int No_of_Beds;
		private String Status;
		private String Condition;
		private int Price;
		private int Floor;
		private Boolean Air_Conditioned;
		private int Priviledge_Level;
		private String Photo_link;
		public Room() {
			super();
		
		}
		public Room(String room_no, int no_of_Beds, String status, String condition, int price, int floor,
				Boolean air_Conditioned, int priviledge_Level, String photo_link) {
			super();
			this.room_no = room_no;
			No_of_Beds = no_of_Beds;
			Status = status;
			Condition = condition;
			Price = price;
			Floor = floor;
			Air_Conditioned = air_Conditioned;
			Priviledge_Level = priviledge_Level;
			Photo_link = photo_link;
		}
		public String getRoom_no() {
			return room_no;
		}
		public void setRoom_no(String room_no) {
			this.room_no = room_no;
		}
		public int getNo_of_Beds() {
			return No_of_Beds;
		}
		public void setNo_of_Beds(int no_of_Beds) {
			No_of_Beds = no_of_Beds;
		}
		public String getStatus() {
			return Status;
		}
		public void setStatus(String status) {
			Status = status;
		}
		public String getCondition() {
			return Condition;
		}
		public void setCondition(String condition) {
			Condition = condition;
		}
		public int getPrice() {
			return Price;
		}
		public void setPrice(int price) {
			Price = price;
		}
		public int getFloor() {
			return Floor;
		}
		public void setFloor(int floor) {
			Floor = floor;
		}
		public Boolean getAir_Conditioned() {
			return Air_Conditioned;
		}
		public void setAir_Conditioned(Boolean air_Conditioned) {
			Air_Conditioned = air_Conditioned;
		}
		public int getPriviledge_Level() {
			return Priviledge_Level;
		}
		public void setPriviledge_Level(int priviledge_Level) {
			Priviledge_Level = priviledge_Level;
		}
		public String getPhoto_link() {
			return Photo_link;
		}
		public void setPhoto_link(String photo_link) {
			Photo_link = photo_link;
		}
		
		

	
	

}
