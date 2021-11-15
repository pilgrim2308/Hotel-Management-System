package com.example.demo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Payment;
import com.example.demo.models.Products;
import com.example.demo.models.Room;
import com.example.demo.models.Room_contains;

@Transactional
@Repository
public class Room_ContainsDAO {
	  @Autowired
	    JdbcTemplate template;
	  @Autowired 
	    RoomDAO roomsdao;
	  
	  public int addproducts(Products p)
	  {
		  List<Room> rooms= roomsdao.getAllRooms();
		  
		  for(int i=0;i<rooms.size();i++)
		  {
			  Room_contains rm= new Room_contains();
			  rm.setProduct_ID(p.getProduct_ID());
			  rm.setQuantity(0);
			  rm.setROOM_ID(rooms.get(i).getRoom_no());
			  save(rm);
		  }
		  
		 return 1;
	  }
	  public int save(Room_contains p)
	   {
		  
		   String sql= "insert into Room_contains(product_id,room_id,quantity) values('"+p.getProduct_ID()+"','"+p.getROOM_ID()+"','"+p.getQuantity()+"');";
		return template.update(sql);
		   
	   }
	  public int remove(Room_contains p)
	   {
		  
		   String sql= "delete from Room_contains where room_id='"+p.getROOM_ID()+"' and product_id='"+p.getProduct_ID()+"';";
		return template.update(sql);
		   
	   }
	  public int addquantity(String product_id,String room_id,int quantity){
		    

		    String sql="update Room_contains set quantity = quantity +" + quantity +" where product_ID ='"+product_id+"' and ROOM_ID = '"+room_id+"';";  
		    return template.update(sql);  
	    }
	   public int countproduct(String id,String room)
	   {
		   String sql="select quantity from Room_contains where product_id='"+id+"' and Room_ID='"+room+"';";

		    return template.queryForObject(sql,int.class); 
		   
	   }
	  public int removequantity(String product_id,String room_id,int quantity){
		    
		  if(countproduct(product_id,room_id)<quantity)
			  return -1;
		  String sql="update Room_contains set quantity = quantity -" + quantity +" where product_ID ='"+product_id+"' and ROOM_ID = '"+room_id+"';";  
		    return template.update(sql);  
	    }
	   
	   public List<Room_contains> getAllRoomInventoryBysql(String query){
	        return template.query(query, new RowMapper<>() {
	            @Override
	            public Room_contains mapRow(ResultSet rs, int i) throws SQLException {
	            	Room_contains e=new Room_contains();
	            	
	            	e.setProduct_ID(rs.getString("Product_ID"));
	            	e.setQuantity(rs.getInt("Quantity"));
	            	e.setROOM_ID(rs.getString("ROOM_ID"));
	        
	            
	                return e;
	            }
	        });
	    }
	   public List<Room_contains> getbyroom_id(String room_id)
	   {
		   String sql="Select * from Room_contains where ROOM_ID='"+room_id+"';";
		   return getAllRoomInventoryBysql(sql);
	   }
	   

}
