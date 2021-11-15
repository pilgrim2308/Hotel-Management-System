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

import com.example.demo.models.Invoice;
import com.example.demo.models.Order_item;

@Transactional
@Repository

public class Invoice_DAO {
	  @Autowired
	    JdbcTemplate template;
	  public int save(Invoice p)
	   {
		   String sql= "insert into Invoice(Invoice_ID,Date,Time,Amount,Tax_Applied,Cust_ID,payment_ID) values ('"+p.getInvoice_id()+"','"+p.getDate()
		   +"','"+p.getTime()+"','"+p.getAmount()+"','"+p.getTax()+"','"+p.getCustomer_id()+"','"+p.getPayment_id()+"');";
		return template.update(sql);
		   
	   }
	  public Invoice getInvoiceByID(int Invoice_id){
		    

		    String sql="select * from Invoice where Invoice_ID="+Invoice_id;
		    return template.queryForObject(sql,new BeanPropertyRowMapper<Invoice>(Invoice.class));  
	    }
	  public Invoice getInvoiceBypaymentID(int payment_id){
		    

		   String sql="select * from Invoice where payment_ID='"+payment_id+"';";
		    return template.queryForObject(sql,new BeanPropertyRowMapper<Invoice>(Invoice.class));  
	    }
	   
	   public List<Invoice> getInvoicebysql(String query){
	        return template.query(query, new RowMapper<Invoice>() {
	            @Override
	            public Invoice mapRow(ResultSet rs, int i) throws SQLException {
	            	Invoice e=new Invoice();
	            	e.setAmount(rs.getInt(""));
	            
	                return e;
	            }
	        });
	    }
	   public List<Invoice> getInvoicebyCustomer(String Customer_ID)
	   {
		   String sql="select * from Invoice where Cust_ID='"+Customer_ID+"';";
		   return getInvoicebysql(sql);
		   
	   }

	   public List<Invoice> getInvoicebyDate(Date date)
	   {
		   String sql="select * from Invoice where Date='"+date+"';";
		   return getInvoicebysql(sql);
		   
	   }
	
}
