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

import com.example.demo.models.Feedback;
import com.example.demo.models.Food_item;

@Transactional
@Repository
public class Feedback_DAO {
	  @Autowired
	    JdbcTemplate template;
	   
	   public int save(Feedback p)
	   {
		   String sql= "insert into Feedback(Feedback_ID,Service_Rating,Hotel_Rating,Comments,Date,Time,Booking_ID,Cust_ID) values('"+p.getFeedback_ID()
		   +"','"+p.getService_Rating()+"','"+p.getHotel_Rating()+"','"+p.getComments()+"','"+p.getDate()
		   +"','"+p.getTime()+"','"+p.getBooking_ID()+"','"+p.getCust_ID()+"');";
		return template.update(sql);
		  
		
	   }
	    public int delete(String id)
	   {
		   String sql= "delete from Feedback where Feedback_ID='"+id+"';";
		return template.update(sql);
		   
	   }
	   public Feedback getFeedbackByID(String id){
	    

		    String sql="select * from Feedback where Feedback_ID=?";  
		    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Feedback>(Feedback.class));  
	    }
	
	   
	   
	   public List<Feedback> getFeedbackBysql(String query){
	     
	        return template.query(query, new RowMapper<Feedback>() {
	            @Override
	            public Feedback mapRow(ResultSet rs, int i) throws SQLException {
	            	Feedback e=new Feedback();
	            	e.setBooking_ID(rs.getString("Booking_ID"));
	            	e.setComments(rs.getString("Comments"));
	            	e.setCust_ID(rs.getString("Cust_ID"));
	            	e.setDate(rs.getDate("Date"));
	            	e.setTime(rs.getTime("Time"));
	            	e.setFeedback_ID(rs.getString("feedback_ID"));
	            	e.setService_Rating(rs.getInt("Service_Rating"));
	            	e.setHotel_Rating(rs.getInt("Hotel_Rating"));
	            
	                return e;
	            }
	        });
	    }
	   public List<Feedback> getFeedbackByCustID(String id){
		    

		    String sql="select * from Feedback where Cust_ID='"+id+"';";  
		    return getFeedbackBysql(sql); 
	    }
	   public List<Feedback> getFeedbackByBookingID(String id){
		    

		    String sql="select * from Feedback where Booking_ID='"+id+"';";  
		    return getFeedbackBysql(sql); 
	    }
	   public List<Feedback> getallfeddbacks()
	   {
		   String sql="Select * from Feedback";
		   return getFeedbackBysql(sql);
	   }
}
