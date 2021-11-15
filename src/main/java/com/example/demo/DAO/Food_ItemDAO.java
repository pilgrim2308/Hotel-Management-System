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

import com.example.demo.models.Customer;
import com.example.demo.models.Food_item;



@Transactional
@Repository
public class Food_ItemDAO {
	   @Autowired
	    JdbcTemplate template;
	   
	   public int save(Food_item p)
	   {
		   String sql= "insert into Food_Item(Food_item_id,name,description,price) values ('"+p.getFood_item_id()+"','"+p.getName()
		   +"','"+p.getDescription()+"','"+p.getPrice()+"';";
		return template.update(sql);
		   
	   }
	   public Food_item getFood_itemByID(String id){
	    

		    String sql="select * from Food_Item where Food_item_id=?";  
		    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Food_item>(Food_item.class));  
	    }
	   
	   public List<Food_item> getFood_itemBysql(String query){
	     
	        return template.query(query, new RowMapper<Food_item>() {
	            @Override
	            public Food_item mapRow(ResultSet rs, int i) throws SQLException {
	            	Food_item e=new Food_item();
	            	e.setFood_item_id(rs.getString("Food_item_id"));
	            	e.setDescription(rs.getString("Description"));
	            	e.setName(rs.getString("name"));
	            	e.setPrice(rs.getInt("price"));
	                return e;
	            }
	        });
	    }
	   public List<Food_item> getallFood_item(){
		   String sql="Select * from Food_Item";
		   return getFood_itemBysql(sql);
		     
	       
	    }
	

}
