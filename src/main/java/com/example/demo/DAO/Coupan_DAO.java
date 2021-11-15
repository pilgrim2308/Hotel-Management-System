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

import com.example.demo.models.Coupon;
import com.example.demo.models.Food_item;

@Transactional
@Repository
public class Coupan_DAO {
	
	  @Autowired
	    JdbcTemplate template;
	   
	   public int save(Coupon p)
	   {
		   String sql= "insert into Coupon(Name,Expire_Date,Discount_Amount,Coupan_ID,Description) values ('"+p.getName()
		   +"','"+p.getExpire_Date()+"','"+p.getDiscount_amount()+"','"+p.getCoupan_ID()+"','"+p.getDescription()+"');";
		return template.update(sql);
		   
	   }
	   public int update_cust(String id,String coupon_id)
	   {
		   String sql= "update Coupon set Cust_ID='"+id+"' where coupon_ID='"+coupon_id+"';";
		return template.update(sql);
		   
	   }
	   public Coupon getCouponByID(String id){
	    

		    String sql="select * from Coupon where Coupan_ID=?";  
		    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Coupon>(Coupon.class));  
	    }
	   public List<Coupon> getCouponByCustID(String id){
		    

		    String sql="select * from Coupon where Cust_ID='"+id+"'";  
		    return getCouponBysql(sql);
	    }
	   public int remove(String id)
	   {
		   String sql= "delete from Coupon where Coupan_ID='"+id+"';";
		return template.update(sql);
	   }
	   
	   public List<Coupon> getCouponBysql(String query){
	     
	        return template.query(query, new RowMapper<Coupon>() {
	            @Override
	            public Coupon mapRow(ResultSet rs, int i) throws SQLException {
	            	Coupon e=new Coupon();
	            	e.setCoupan_ID(rs.getString("Coupan_ID"));
	            	e.setCust_ID(rs.getString("Cust_ID"));
	            	e.setDescription(rs.getString("Description"));
	            	e.setName(rs.getString("Name"));
	            	e.setDiscount_amount(rs.getInt("Discount_Amount"));
	            	e.setExpire_Date(rs.getDate("Expire_Date"));
	            	
	            	
	                return e;
	            }
	        });
	    }
	   public List<Coupon> getall()
	   {
		   String sql="select * from Coupon";
		   return getCouponBysql(sql);
		   
	   }
	   public List<Coupon> getvalidcoupon(Date date)
	   {

		   String sql="select * from Coupon where Expire_Date>="+date+" and Cust_ID is NULL;";
		   return getCouponBysql(sql);
		   
	   }
	   
}
