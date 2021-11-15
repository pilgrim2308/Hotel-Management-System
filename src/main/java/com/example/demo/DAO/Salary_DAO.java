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
import com.example.demo.models.Salaries_made;

@Transactional
@Repository
public class Salary_DAO {
	 @Autowired
	    JdbcTemplate template;
	 
	   
	   public int save(Salaries_made p)
	   {
		   String sql="insert into _Salaries_made(payment_ID,Employee_ID) values('"+p.getPayment_ID()+"','"+p.getEmployee_ID()+"');";
		return template.update(sql);
		   
	   }
	   public int saveSalarypayment(Payment p)
	   {
		  
		   String sql= "insert into Payment(payment_ID,status,type,Mode_of_payment,amount,Date,Time) values('"+p.getPayment_id()+"','"
				   +p.getStatus()+"','"+p.getType()+"','"+p.getModeofpayment()+"','"+p.getAmount()+"','"+p.getDate()+"','"+p.getTime()
				   +"');";
		return template.update(sql);
		   
	   }
	   
	   
	   public Salaries_made getSalaryByyId(String id,String payment){
	        String sql="select * from _Salaries_made where Employee_ID='"+id+"' and payment_id=?";
	        return template.queryForObject(sql, new Object[]{payment},new BeanPropertyRowMapper<Salaries_made>(Salaries_made.class));
	    }
	
	   public List<Salaries_made> getSalaryBysql(String sql){
	       
	        return template.query(sql, new RowMapper<Salaries_made>() {
	            @Override
	            public Salaries_made mapRow(ResultSet rs, int i) throws SQLException {
	            	Salaries_made e=new Salaries_made();
	            	e.setEmployee_ID(rs.getString("Employee_ID"));
	            	e.setPayment_ID(rs.getString("payment_ID"));
	            	      
	                return e;
	            }
	        });
	        		}
	   public List<Salaries_made> getall(){
		   String sql="select * from _Salaries_made";
		   return getSalaryBysql(sql);
	   }
	   
	   
	   public List<Salaries_made> getSalaryByEmp_ID(String emp){
		   String sql="select * from _Salaries_made where employee_ID='"+emp+"';";
		   return getSalaryBysql(sql);
	   }
	   
	   
	   

}
