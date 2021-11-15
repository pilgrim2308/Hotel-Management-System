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

import com.example.demo.models.Order_item;

@Transactional
@Repository
public class Order_itemDAO {
	  @Autowired
	    JdbcTemplate template;
	  public int save(Order_item p)
	   {
		   String sql= "insert into Order_item(Quantity,Order_No,Food_item_id) values('"+p.getQuantity()+"','"+p.getOrder_No()+"','"+p.getFood_item_id()+"');";
		return template.update(sql);
		   
	   }
	  public Order_item getOrderByID(int orderno,int itemid){
		    

		    String sql="select * from Order_item where Order_no="+orderno+" item_ID="+itemid;  
		    return template.queryForObject(sql,new BeanPropertyRowMapper<Order_item>(Order_item.class));  
	    }
	   
	   public List<Order_item> getAllorderitems(int order_no){
	        String query = "select * from Order_item where Order_no="+order_no;
	        return template.query(query, new RowMapper<Order_item>() {
	            @Override
	            public Order_item mapRow(ResultSet rs, int i) throws SQLException {
	            	Order_item e=new Order_item();
	            	e.setFood_item_id(rs.getString("Food_item_id"));
	            	e.setItem_ID(rs.getInt("item_ID"));
	            	e.setOrder_No(rs.getInt("Order_No"));
	            	e.setQuantity(rs.getInt("Quantity"));
	            
	                return e;
	            }
	        });
	    }
	
}
