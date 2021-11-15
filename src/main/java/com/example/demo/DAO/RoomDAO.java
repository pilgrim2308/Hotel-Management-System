package com.example.demo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Allotment_list;
import com.example.demo.models.Room;
import com.example.demo.models.Room_type;
@Transactional
@Repository
public class RoomDAO {
	 @Autowired
	    JdbcTemplate template;
	   
	   public int save(Room p)
	   {
		   String sql="insert into Room(room_no, no_of_Beds,status, condition,price, floor,air_Conditioned,priviledge_Level,photo_link) values ('"+p.getRoom_no()
		   +"','"+p.getNo_of_Beds()+"','"+p.getStatus()+"','"+p.getCondition()+"','"+p.getPrice()+"','"+p.getFloor()+"','"+p.getAir_Conditioned()
		   +"','"+p.getPriviledge_Level()+"','"+p.getPhoto_link()+"');";
		return template.update(sql);
		   
	   }
	   
	   
	   public Room getRoomById(String id){
	        String sql="select * from Room where room_no=?";
	        return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Room>(Room.class));
	    }
	
	   public List<Room> getRoomBysql(String sql){
	       
	        return template.query(sql, new RowMapper<Room>() {
	            @Override
	            public Room mapRow(ResultSet rs, int i) throws SQLException {
	                Room e=new Room();
	                e.setRoom_no(rs.getString("Room_No"));
	                e.setNo_of_Beds(rs.getInt("No_Of_Beds"));
	                e.setAir_Conditioned(rs.getBoolean("Air_Conditioned"));
	                e.setStatus(rs.getString("Status"));
	                e.setPrice(rs.getInt("Price"));
	                e.setPhoto_link(rs.getString("Photo_link"));
	           
	                e.setPriviledge_Level(rs.getInt("Priviledge_Level"));
	                e.setFloor(rs.getInt("Floor_No"));
	      
	                return e;
	            }
	        });
	        		}
	   
	   
	   public List<Room> getRoomByavaiability(String status){
	        String sql="select * from Room where Status='"+status+"';";
	        return getRoomBysql(sql);
	        		}
	  
	   public List<Room> getRoomByprivlevel(int level){
	        String sql="select * from Room where priviledge_level="+level;
	        return getRoomBysql(sql);
	    }
	   public List<Room> getAllRoomsBybookingId(String booking_id){
	        String sql = "select * from Room where Room_No IN ("
	        		+ "select Room_ID from books where Booking_ID='"+booking_id+"');";
	        
	        
	        return getRoomBysql(sql);
	    }

	   
	   public List<Room> getAllRooms(){
	        String sql = "select * from Room";
	        return getRoomBysql(sql);
	    }


	public List<Room_type> getallroomtypes() {
		String sql = "select * from Room_type";
        
		return template.query(sql, new RowMapper<Room_type>() {
            @Override
            public Room_type mapRow(ResultSet rs, int i) throws SQLException {
                Room_type e=new Room_type();
                e.setPriviledge_level(rs.getInt("priviledge_level"));
                e.setPrice(rs.getInt("price"));
                e.setTotal_count(rs.getInt("Total_count"));
                e.setPhoto_url(rs.getString("photo_url"));
                e.setAc(rs.getBoolean("ac"));
               
                return e;
            }
        });
		
	}
	public List<Allotment_list> getallroomlistbysql(String sql) {
	
        
		return template.query(sql, new RowMapper<Allotment_list>() {
            @Override
            public Allotment_list mapRow(ResultSet rs, int i) throws SQLException {
            	Allotment_list e=new Allotment_list();
            	e.setCust_ID(rs.getString("Cust_ID"));
            	e.setROOM_ID(rs.getString("ROOM_ID"));
            
               
                return e;
            }
        });
		
	}
	public Integer getpricebyRoomType(int priv_lvl)
	{
		String sql = "select price from Room_type where priviledge_level="+priv_lvl;
		

        return template.queryForObject(sql,int.class);
	}
	public List<Allotment_list> getroomsbycust_id(String id)
	{
		String sql="select * from Allotted_to where cust_id='"+id+"';";
		return getallroomlistbysql(sql);
		
		
		
	}


}
