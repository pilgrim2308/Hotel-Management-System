package com.example.demo.DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Order_item;
import com.example.demo.models.Payment;

@Transactional
@Repository

public class Payment_DAO {
	
	  @Autowired
	    JdbcTemplate template;
	  public int save(Payment p)
	   {
		  
		   String sql= "insert into Payment(payment_ID,status,type,Mode_of_payment,amount,Date,Time,bill_no,Booking_ID,Cust_ID) values('"+p.getPayment_id()+"','"
				   +p.getStatus()+"','"+p.getType()+"','"+p.getModeofpayment()+"','"+p.getAmount()+"','"+p.getDate()+"','"+p.getTime()
				   +"','"+p.getBill_no()+"','"+p.getBooking_id()+"','"+p.getCustomer_id()+"');";
		return template.update(sql);
		   
	   }
	  public Payment getPaymentByID(String payment_id){
		    

		    String sql="select * from Payment where payment_ID='"+payment_id+"';";  
		    return getAllpaymentBysql(sql).get(0); 
	    }
	  public Payment getPaymentBybillrNo(int bill_no){
		    

		    String sql="select * from Payment where bill_no="+bill_no;  
		    return getAllpaymentBysql(sql).get(0); 
	    }
	   
	   public List<Payment> getAllpaymentBysql(String query){
	        return template.query(query, new RowMapper<Payment>() {
	            @Override
	            public Payment mapRow(ResultSet rs, int i) throws SQLException {
	            	Payment e=new Payment();
	            	e.setAmount(rs.getInt("amount"));
	            	e.setBill_no(rs.getInt("bill_no"));
	            	e.setBooking_id(rs.getString("Booking_ID"));
	            	e.setDate(rs.getDate("Date"));
	            	e.setTime(rs.getTime("Time"));
	            	e.setModeofpayment(rs.getString("Mode_of_payment"));
	            	e.setCustomer_id(rs.getString("Cust_ID"));
	            	e.setPayment_id(rs.getString("payment_ID"));
	            	e.setStatus(rs.getString("Status"));
	            	e.setType(rs.getString("type"));
	            
	                return e;
	            }
	        });
	    }
	   
	   public List<Payment> getAllpaymentByBooking_id(String booking_id){
		   
		   String sql="select * from Payment where Booking_ID='"+booking_id+"';";
		   return getAllpaymentBysql(sql);
		   
	       
	    }
	  public List<Payment> getAllpaymentByCust_id(String cust_id){
			   
			   String sql="select * from Payment where Cust_ID='"+cust_id+"';";
			   return getAllpaymentBysql(sql);
			   
		       
		    }
	  public List<Payment> getAllpaymentByDate(Date date){
		   
		   String sql="select * from Payment where Date="+date;
		   return getAllpaymentBysql(sql);
		   
	      
	   }
	  public List<Payment> getAllpaymentByStatus(String status){
		   
		   String sql="select * from Payment where status="+status;
		   return getAllpaymentBysql(sql);
		   
	     
	  }
	  public List<Payment> getAllpaymentByModeofPayment(String mop){
		   
		   String sql="select * from Payment where Mode_of_payment="+mop;
		   return getAllpaymentBysql(sql);
		   
	     
	  }
	  

	
	

}
