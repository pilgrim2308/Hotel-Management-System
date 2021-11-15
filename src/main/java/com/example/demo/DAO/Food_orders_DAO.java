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

import com.example.demo.models.Customer;
import com.example.demo.models.Food_orders;
import com.example.demo.models.Order_item;

@Transactional
@Repository

public class Food_orders_DAO {
	
	@Autowired
    JdbcTemplate template;
   
   public int save(Food_orders p)
   {
	   String sql= "insert into Food_Orders(Order_No,Status,total_price,date,time,Room_ID) values ('"+p.getOrder_No()+"','"+p.getStatus()+"','"+p.getTotal_Price()
	   +"','"+p.getDate()+"','"+p.getTime()+"','"+p.getROOM_ID()+"');";
	   
	   template.update(sql);
	   List<Order_item> items=p.getItems();
	   for(int i=0;i<p.getItems().size();i++)
	   {
		   
		   
	   String sql1= "insert into Order_item(Quantity,item_ID,Order_No,Food_item_id) values ('"+items.get(i).getQuantity()+"','"+items.get(i).getItem_ID()
			   +"','"+p.getOrder_No()+"','"+items.get(i).getFood_item_id()+"');";
	   template.update(sql1);
	   }
	   return 1;
	   
	   
	   
   }
   public Food_orders getFood_OrderByID(int id){
    

	    String sql="select * from Food_Orders where Order_No="+id;  
	    
	    List<Food_orders> foods=getAllFood_OrderBysql(sql);
	    if(foods.size()==0)
	    	return null;
	    else return foods.get(0);
    }
   
   public List<Food_orders> getAllFood_OrderBysql(String sql){
      
       return template.query(sql, new RowMapper<Food_orders>() {
           @Override
           public Food_orders mapRow(ResultSet rs, int i) throws SQLException {
           	Food_orders e=new Food_orders();
           	e.setDate(rs.getDate("Date"));
           	e.setOrder_No(rs.getInt("Order_No"));
           	e.setROOM_ID(rs.getString("ROOM_ID"));
           	e.setTime(rs.getTime("Time"));
           	e.setStatus(rs.getString("Status"));
           	e.setTotal_Price(rs.getInt("Total_Price"));
               
               return e;
           }
       });
   }
   public List<Food_orders> getFood_OrderByROOM_ID(String id){
	    

	    String sql="select * from Food_Orders where Order_No='"+id+"';";  
	    return getAllFood_OrderBysql(sql);
   }

   
   public List<Food_orders> getAllFoodOrderBYDate(Date date){
        String sql = "select * from Food_Orders where Date='"+date+"'";
        return getAllFood_OrderBysql(sql);
    }
   public int getFood_OrderBystatus(String status){
	    

	    String sql="select * from Food_Orders where status='"+status+"';";  
	    return template.update(sql);
  }
   public int setFood_Orderstatus(int id,String status)
   {
	   String sql= "update Food_Orders set status='"+status+"' where Order_No='"+id+"';";
	   
	   return template.update(sql);
   }
   public int gettotalcount()
   {
	   String sql= "select count(*) from Food_Orders";
	   

	    return template.queryForObject(sql,(int.class));  
   }
   


}
