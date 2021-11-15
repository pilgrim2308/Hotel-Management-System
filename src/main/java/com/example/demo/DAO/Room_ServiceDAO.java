package com.example.demo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Booking;
import com.example.demo.models.Room_Service;

@Transactional
@Repository
public class Room_ServiceDAO {
	 @Autowired
	    JdbcTemplate template;
	 @Autowired
	 RoomDAO roomdao;
	 
	   public int save(Room_Service p)
	   {
		   String sql="insert into Room_Service(Service_ID,Status,Demands,Date,Time,ROOM_ID) values ('"
	   +p.getService_ID()+"','"+p.getStatus()+"','"+p.getDemands()+"','"+p.getDate()+"','"+p.getTime()+"','"+p.getROOM_ID()+"');";
		return template.update(sql);
		   
	   }
	   public int assignEmployeeRoomService(String service_id,String employee_id)
	   {
		   String sql="update Room_Service set Employee_ID='"+employee_id+"',status='assigned' where Service_id='"+service_id+"';";
		return template.update(sql);
		   
	   }

	public List<Room_Service> getRoomServicesql(String sql){
	    return template.query(sql, new RowMapper<Room_Service>() {
	        @Override
	        public Room_Service mapRow(ResultSet rs, int i) throws SQLException {
	            
	        	Room_Service e=new Room_Service();
	        	e.setService_ID(rs.getString("Service_ID"));
	            e.setROOM_ID(rs.getString("ROOM_ID"));  
	            e.setStatus(rs.getString("Status"));
	            e.setTime(rs.getTime("Time"));
	  
	            return e;
	        }
	    });
	    		}
	
	public List<Room_Service> getRoom_serviceByStatus(String status){
		String sql="select * from Room_Service where status='"+status+"' order by Time; ";
		return getRoomServicesql(sql);
	}
	public List<Room_Service> getRoom_serviceByEmpID(String Employee_id,String status){
		String sql="select * from Room_Service where Employee_ID='"+Employee_id+"'and status ='"+status+"' order by Time;";
		return getRoomServicesql(sql);
	}
	public List<Room_Service> getRoom_serviceByRoom_ID(String Room_id){
		String sql="select * from Room_Service where Room_id='"+Room_id+"' order by Time Desc;";
		return getRoomServicesql(sql);
	}
	public int setRoom_serviceStatus(String id,String status){
		String sql="update Room_Service set status='"+status+"' where  service_id='"+id+"';";
		return template.update(sql);
	}
	
}
