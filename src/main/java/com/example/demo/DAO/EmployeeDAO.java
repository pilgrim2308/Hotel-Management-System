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
import com.example.demo.models.Employee;
import com.example.demo.models.Employee_email;
import com.example.demo.models.Employee_phone;




@Transactional
@Repository
public class EmployeeDAO {
	 @Autowired
	    JdbcTemplate template;
	 
	  public int save(Employee p)
	   {
		   String sql= "insert into Employee(employee_id,first_name,last_name,gender,house_no,street,city,pincode, dOB,joining_date,dP_URL,attendance,priviledge_level, current_status) values ('"+p.getEmployee_id()
		   +"','"+p.getFirst_name()+"','"+p.getLast_name()+"','"+p.getGender()+"','"+p.getHouse_no()+"','"+p.getStreet()+"','"+p.getCity()
		   +"','"+p.getPincode()+"','"+p.getDOB()+"','"+p.getJoining_date()+"','"+p.getDP_URL()+"','"+p.getAttendance()+"','"+p.getPriviledge_level()+"','"+p.getCurrent_status()+"')";
		return template.update(sql);
		   
	   }
	   public int update(Employee p)
	   {
		   String sql= "update Employee set First_Name='"+p.getFirst_name()+"',Last_Name='"+p.getLast_name()
		   +"',Street='"+p.getStreet()+"',city='"+p.getCity()+"',pincode='"+p.getPincode()+"',house_no='"+p.getHouse_no()+"',DOB='"
				   +p.getDOB()+"',DP_URL='"+p.getDP_URL()+"' where Employee_ID='"+p.getEmployee_id()+"';";
		return template.update(sql);
		   
	   }
	   public int updatebank(String cust,String bank)
	   {
		   String sql= "update Employee set Bank_Ref_No = '"+bank+"' where Employee_ID='"+cust+"';";
		return template.update(sql);
		   
	   }
	  public int delete(int id){  
		    String sql="delete from Employee where employee_Id ="+id+"";  
		    return template.update(sql);  
		}  
	  
	  
	  public Employee getEmployeeById(String id){  
		    String sql="select * from Employee where employee_id='"+id+"';";  
		    List <Employee> emps= getEmpbySQL(sql);
		    if(emps.size()!=0)
		    return getEmpbySQL(sql).get(0);
		    else return null;
		}  
	  
	  public List<Employee> getEmpbySQL(String sql){  
		    return template.query(sql,new RowMapper<Employee>(){  
		        public Employee mapRow(ResultSet rs, int row) throws SQLException {  
		        	Employee e=new Employee();  
		        	 e.setEmployee_id(rs.getString("employee_id"));
		                e.setFirst_name(rs.getString("first_name"));
		                e.setLast_name(rs.getString("last_name"));
		                e.setHouse_no(rs.getString("House_No"));
		                e.setDOB(rs.getDate("DOB"));
		                e.setBank_reference_no(rs.getString("Bank_Ref_No"));
		               
		                e.setStreet(rs.getString("street"));
		                e.setCity(rs.getString("city"));
		                e.setPincode(rs.getInt("pincode"));
		            return e;  
		        }  
		    });  
		}  
	  
	  
	  public List<Employee> getallEmployee(){  
		    return getEmpbySQL("Select * from Employee;");
		}  

	   public List<Employee_email> getallemails(String Employee_ID)
	   {
		   String query="Select * from Employee_Email where Employee_ID='"+Employee_ID+"';";
		   
		   return template.query(query, new RowMapper<Employee_email>() {
	            @Override
	            public Employee_email mapRow(ResultSet rs, int i) throws SQLException {
	            	Employee_email e=new Employee_email();
	                e.setEmployee_ID(rs.getString("Employee_ID"));
	                e.setEmail(rs.getString("Email"));
	               
	                return e;
	            }
	        });
	   }
	   public List<Employee_phone> getallnums(String Employee_ID)
	   {
		   String query="Select * from Employee_Phone where Employee_ID='"+Employee_ID+"';";
		   
		   return template.query(query, new RowMapper<Employee_phone>() {
	            @Override
	            public Employee_phone mapRow(ResultSet rs, int i) throws SQLException {
	            	Employee_phone e=new Employee_phone();
	                e.setEmployee_ID(rs.getString("Employee_ID"));
	                e.setPhone_No(rs.getString("Phone_No"));
	               
	                return e;
	            }
	        });
	   }
	   public int insertemail(String id,String email)
	   {
		   String sql="insert into Employee_Email(Employee_ID,email) values('"+id+"','"+email+"');";
		   return template.update(sql);
		   
	   }
	   public int insertnum(String id,String number)
	   {
		   String sql="insert into Employee_Phone(Employee_ID,Phone_No) values('"+id+"','"+number+"');";
		   return template.update(sql);
		   
	   }
	   public int removeemail(String id,String email)
	   {
		   String sql="delete from Employee_Email where Employee_ID='"+id+"' and Email='"+email+"';";
		   return template.update(sql);
		   
	   }public int removenum(String id,String num)
	   {
		   String sql="delete from Employee_Phone where Employee_ID='"+id+"' and Phone_no='"+num+"';";
		   return template.update(sql);
		   
	   }
	   

}
