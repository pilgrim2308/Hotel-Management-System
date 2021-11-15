package com.example.demo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Customer;
import com.example.demo.models.Customer_email;
import com.example.demo.models.Customer_phone;
import com.example.demo.models.Employee;

@Transactional
@Repository
public class CustomerDAO {
	   @Autowired
	    JdbcTemplate template;
	   
	   public int save(Customer p)
	   {
		   String sql= "insert into Customer(Cust_ID,FIrst_Name,Last_Name,street,city,pincode,house_no,DOB,dP_URL) values ('"+p.getCust_ID()+"','"+p.getFirst_name()+"','"+p.getLast_name()
		   +"','"+p.getStreet()+"','"+p.getCity()+"','"+p.getPincode()+"','"+p.getHouse_no()+"','"+p.getDOB()+"','"+p.getDP_URL()+"');";
		return template.update(sql);
		   
	   }
	   public int update(Customer p)
	   {
		   String sql= "update Customer set FIrst_Name='"+p.getFirst_name()+"',Last_Name='"+p.getLast_name()
		   +"',Street='"+p.getStreet()+"',city='"+p.getCity()+"',pincode='"+p.getPincode()+"',house_no='"+p.getHouse_no()+"',DOB='"
				   +p.getDOB()+"',DP_URL='"+p.getDP_URL()+"' where Cust_ID='"+p.getCust_ID()+"';";
		return template.update(sql);
		   
	   }
	   public int updatebank(String cust,String bank)
	   {
		   String sql= "update Customer set Bank_Ref_No='"+bank+"' where Cust_ID='"+cust+"';";
		return template.update(sql);
		   
	   }
	  
	   public Customer getCustomer(String id){
	    

		    String sql="select * from Customer where cust_id='"+id+"';";  
		  List<Customer> custs= getCustbysql(sql);
		  if(custs.size()==0)
			  return null;
		  else return custs.get(0);
	    }
	   public List<Customer> getCustbysql(String sql){
	        
	        return template.query(sql, new RowMapper<Customer>() {
	            @Override
	            public Customer mapRow(ResultSet rs, int i) throws SQLException {
	                Customer e=new Customer();
	                e.setCust_ID(rs.getString("Cust_id"));
	                e.setFirst_name(rs.getString("first_name"));
	                e.setLast_name(rs.getString("last_name"));
	                e.setDOB(rs.getDate("DOB"));
	                e.setHouse_no(rs.getString("House_No"));
	                e.setStreet(rs.getString("street"));
	                e.setCity(rs.getString("city"));
	                e.setPincode(rs.getInt("pincode"));
	                e.setBank_Ref_No(rs.getString("Bank_Ref_No"));
	                return e;
	            }
	        });
	    }
	
	
	   
	   public List<Customer> getAllCustomer(){
	        String query = "select * from Customer";
	        return template.query(query, new RowMapper<Customer>() {
	            @Override
	            public Customer mapRow(ResultSet rs, int i) throws SQLException {
	                Customer e=new Customer();
	                e.setCust_ID(rs.getString("customer_id"));
	                e.setFirst_name(rs.getString("first_name"));
	                e.setLast_name(rs.getString("last_name"));
	                e.setStreet(rs.getString("street"));
	                e.setCity(rs.getString("city"));
	                e.setPincode(rs.getInt("pincode"));
	                return e;
	            }
	        });
	    }
	
	   public List<Customer_email> getallemails(String cust_id)
	   {
		   String query="Select * from Customer_Email where Cust_Id='"+cust_id+"';";
		   
		   return template.query(query, new RowMapper<Customer_email>() {
	            @Override
	            public Customer_email mapRow(ResultSet rs, int i) throws SQLException {
	            	Customer_email e=new Customer_email();
	                e.setCust_ID(rs.getString("Cust_ID"));
	                e.setEmail(rs.getString("Email"));
	               
	                return e;
	            }
	        });
	   }
	   public List<Customer_phone> getallnum(String cust_id)
	   {
		   String query="Select * from Customer_Phone where Cust_Id='"+cust_id+"';";
		   
		   return template.query(query, new RowMapper<Customer_phone>() {
	            @Override
	            public Customer_phone mapRow(ResultSet rs, int i) throws SQLException {
	            	Customer_phone e=new Customer_phone();
	                e.setCust_ID(rs.getString("Cust_ID"));
	                e.setPhone_No(rs.getString("Phone_Number"));
	               
	                return e;
	            }
	        });
	   }
	   public int insertemail(String id,String email)
	   {
		   String sql="insert into Customer_Email(Cust_ID,email) values('"+id+"','"+email+"');";
		   return template.update(sql);
		   
	   }
	   public int insertnum(String id,String number)
	   {
		   String sql="insert into Customer_Phone(Cust_ID,Phone_Number) values('"+id+"','"+number+"');";
		   return template.update(sql);
		   
	   }
	   public int removeemail(String id,String email)
	   {
		   String sql="delete from Customer_Email where Cust_ID='"+id+"' and Email='"+email+"';";
		   return template.update(sql);
		   
	   }public int removenum(String id,String num)
	   {
		   String sql="delete from Customer_Phone where Cust_ID='"+id+"' and Phone_Number='"+num+"';";
		   return template.update(sql);
		   
	   }
	
	
	
	

}
