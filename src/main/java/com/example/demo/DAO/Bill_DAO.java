package com.example.demo.DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Bill;
import com.example.demo.models.Booking;
import com.example.demo.models.Invoice;
import com.example.demo.models.Order_item;
import com.example.demo.models.Payment;

@Transactional
@Repository

public class Bill_DAO {
	
	  @Autowired
	    JdbcTemplate template;
	  @Autowired
	  private Coupan_DAO coupondao;
	  @Autowired
	  private BookingDAO bookingdao;
		@Autowired
		private Invoice_DAO invoicedao;
		@Autowired
		private Payment_DAO paymentdao;
	  
	  
	  public int save(Bill p)
	   {
		   String sql= "insert into Bill(Bill_no,price,Booking_ID,Order_no) values('"+p.getBill_No()+"','"+p.getPrice()+"','"
	   +p.getBooking_ID()+"','"+p.getOrder_No()+"');";
		return template.update(sql);
		   
	   }
	  
	  public Bill getBillByID(int bill_no){
		  
		  String sql="select * from Bill where Bill_no="+bill_no;  
		   
		  return template.queryForObject(sql,new BeanPropertyRowMapper<Bill>(Bill.class));  
	    }

	   
	   public List<Bill> getAllBillBysql(String query){
	    
	        return template.query(query, new RowMapper<Bill>() {
	            @Override
	            public Bill mapRow(ResultSet rs, int i) throws SQLException {
	            	Bill e=new Bill();
	            	e.setBill_No(rs.getInt("Bill_No"));
	            	e.setBooking_ID(rs.getString("Booking_ID"));
	            	e.setCoupan_ID(rs.getString("coupan_ID"));
	            	e.setPrice(rs.getInt("price"));
	            	e.setOrder_No(rs.getInt("Order_No"));
	            	
	            
	                return e;
	            }
	        });
	    }
	   
	   public List<Bill> getbillbybooking_id(String booking_id)
	   {
		   String sql="select * from Bill where booking_id='"+booking_id+"';";
		   return getAllBillBysql(sql);
	   }
	   public List<Bill> getpendingbillbybooking_id(String Booking_id)
	   {
		   String sql= "select * from Bill where Booking_ID='"+Booking_id+"' and Bill_no Not in (select bill_no from Payment where Booking_id='"+Booking_id+"')";
			   return getAllBillBysql(sql);
	   }
	   public int applycoupan(int bill_no,String coupan,int new_price)
	   { String sql="update Bill set coupan_id='"+coupan+"' , price="+new_price+"where Bill_No="+bill_no;
		   return template.update(sql);
	   }
	   public int gettotalcount()
	   {
		   String sql= "select count(*) from Bill";
		   

		    return template.queryForObject(sql,(int.class));  
	   }
	   public int clearDues(String Booking_id,String mode)
	   {
		   String sql= "select * from Bill where Booking_ID='"+Booking_id+"' and Bill_no Not in (select bill_no from Payment where Booking_id='"+Booking_id+"')";
		   int total=0;
		   List<Bill> bills=getAllBillBysql(sql);
		   
		   for(int i=0;i<bills.size();i++)
		   {
			   Payment payment=new Payment();
			   Invoice invoice=new Invoice();
			   Booking booking=bookingdao.getBookingById(bills.get(i).getBooking_ID());
			   System.out.println(booking.getCustomer_id());
			   
			   	payment.setCustomer_id(booking.getCustomer_id());
			   	payment.setModeofpayment(mode);
			   	payment.setType("debit");
				payment.setBooking_id(bills.get(i).getBooking_ID());
				payment.setAmount(bills.get(i).getPrice());
				payment.setBill_no(bills.get(i).getBill_No());
				payment.setDate(new Date(System.currentTimeMillis()));
				payment.setTime(java.sql.Time.valueOf(LocalTime.now()));
				payment.setPayment_id(payment.getCustomer_id()+"_"+payment.getTime());
				
				
				paymentdao.save(payment);
				
				invoice.setAmount(payment.getAmount());
				invoice.setCustomer_id(payment.getCustomer_id());
				invoice.setDate(payment.getDate());
				invoice.setPayment_id(payment.getPayment_id());
				invoice.setTax(10);
				invoice.setTime(payment.getTime());
				invoice.setInvoice_id(payment.getPayment_id());
				
				invoicedao.save(invoice);
				total=total+ payment.getAmount();
			   
			   
			   
		   }
		   
		    return total;  
	   }
	   
	   
	   
	

}
