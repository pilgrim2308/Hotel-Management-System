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

import com.example.demo.models.Bank_Details;
import com.example.demo.models.Bill;

@Transactional
@Repository

public class Bankdetail_DAO {

	  @Autowired
	    JdbcTemplate template;
	  @Autowired
	  private CustomerDAO custdao;
	  @Autowired 
	  private EmployeeDAO empdao;
	  
	  
	  
	  
	  public int saveCustbank(Bank_Details p,String cust_id)
	   {
		   save(p);
		   return custdao.updatebank(cust_id, p.getBank_id());
		   
		   
	   }
	  public int saveempbank(Bank_Details p,String emp_id)
	   {
		   
		save(p);
		return empdao.updatebank(emp_id, p.getBank_id());
		   
	   }
	  public int save(Bank_Details p)
	   {
		   String sql= "insert into Bank_Detail(Bank_ID,Bank_Name,Account_Number,IFSC_Code) values('"+p.getBank_id()
		   +"','"+p.getBank_Name()+"','"+p.getAccount_Number()+"','"+p.getIFSC_Code()+"');";
		return template.update(sql);
		   
	   }
	  public int update(Bank_Details p)
	   {
		   String sql= "update Bank_Detail set Bank_Name='"+p.getBank_Name()+"',Account_Number='"+p.getAccount_Number()+"',IFSC_Code='"+p.getIFSC_Code()
		   +"' where Bank_ID='"+p.getBank_id()+"';";
		return template.update(sql);
		   
	   }
	  
	  public Bank_Details getBankByID(String id){
		  
		  String sql="select * from Bank_Detail where Bank_ID='"+id+"';";  
		   
		  List<Bank_Details> bd = getAllBankBysql(sql);
		  if(bd.size()==0)
			  return null;
		  else return bd.get(0);
	    }

	   
	   public List<Bank_Details> getAllBankBysql(String query){
	    
	        return template.query(query, new RowMapper<Bank_Details>() {
	            @Override
	            public Bank_Details mapRow(ResultSet rs, int i) throws SQLException {
	            	Bank_Details e=new Bank_Details();
	            	e.setAccount_Number(rs.getString("Account_Number"));
	            	e.setBank_id(rs.getString("Bank_ID"));
	            	e.setBank_Name(rs.getString("Bank_Name"));
	            	e.setIFSC_Code(rs.getString("IFSC_Code"));
	       
	           
	            	
	            
	                return e;
	            }
	        });
	    }

	   

}
