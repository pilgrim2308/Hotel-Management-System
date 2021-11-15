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

@Transactional
@Repository
public class Products_DAO {
	  @Autowired
	    JdbcTemplate template;
	  public int save(Products p)
	   {
		  
		   String sql= "insert into Products(Product_ID,Name,Description,Price,Quantity,current_incharge) values ('"+p.getProduct_ID()+"','"+p.getName()
		   +"','"+p.getDescription()+"','"+p.getPrice()+"','"+p.getQuantity()+"','"+p.getCurrent_incharge()+"');";
		   
		   
		   
		   return template.update(sql);
		   
	   }
	  public Products getProductsByID(String product_id){
		    

		    String sql="select * from Products where product_ID='"+product_id+"';";  
		    return template.queryForObject(sql,new BeanPropertyRowMapper<Products>(Products.class));  
	    }
	  public Products getProductsByIncharge(String current_incharge){
		    

		    String sql="select * from Products where current_incharge='"+current_incharge+"';";  
		    return template.queryForObject(sql,new BeanPropertyRowMapper<Products>(Products.class));  
	    }
	   
	   public List<Products> getAllProductsBysql(String query){
	        return template.query(query, new RowMapper<Products>() {
	            @Override
	            public Products mapRow(ResultSet rs, int i) throws SQLException {
	            	Products e=new Products();
	            	e.setCurrent_incharge(rs.getString("current_incharge"));
	            	e.setName(rs.getString("Name"));
	            	e.setDescription(rs.getString("Description"));
	            	e.setQuantity(rs.getInt("Quantity"));
	            	e.setPrice(rs.getInt("Price"));
	            	e.setProduct_ID(rs.getString("Product_ID"));
	            	
	            	
	            
	                return e;
	            }
	        });
	        
	    }
	   public int countproduct(String id)
	   {
		   String sql="select quantity from Products where product_id='"+id+"';";

		    return template.queryForObject(sql,int.class); 
		   
	   }
	   public int setincharge(String product_id,String incharge)
	   {
		   String sql="update Products set current_incharge='"+incharge+"' where product_id='"+product_id+"';";
		   return template.update(sql);
	   }
	   public int addQuantity(String product_id,int Quantity)
	   {
		   String sql="update Products set quantity= quantity +"+Quantity+" where product_id='"+product_id+"';";
		   return template.update(sql);
	   }
	   public int removeQuantity(String product_id,int Quantity)
	   {
		   if(countproduct(product_id)<Quantity)
		   {
			   return -1;
		   }
		   
		   
		   String sql="update Products set quantity= quantity - "+Quantity+" where product_id='"+product_id+"';";
		   return template.update(sql);
	   }
	   public List<Products> getall()
	   {
		   String sql="Select * from Products";
		   return getAllProductsBysql(sql);
	   }
  
	   

}
