package com.example.demo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.sql.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Booking;
import com.example.demo.models.Room;
import com.example.demo.models.Room_booking;
import com.example.demo.models.Room_type;


@Transactional
@Repository
public class BookingDAO {
	 @Autowired
	 JdbcTemplate template;
	
	 @Autowired
	 RoomDAO roomdao;
	   
	   public void save(Booking p)
	   {
		   String sql="insert into Booking(booking_id,no_of_members,booking_date, booking_time,start_date,end_date,purpose_of_visit,payment_status,cust_id) values ('"+
	        p.getBooking_id()+"','"+p.getNo_of_members()+"','"+p.getBooking_date()+"','"+p.getBooking_time()+"','"+p.getStart_date()
	        +"','"+p.getEnd_date()+"','"+p.getPurpose_of_visit()+"','"+p.getPayment_status()+"','"+p.getCustomer_id()+"');";
		   
		template.update(sql);
		
		for(Room_booking G:p.getRooms())
		{
		sql="insert into Room_booking(booking_ID,count,priviledge_level,start_date,end_date) values ('"
		+p.getBooking_id()+"','"+G.getCount()+"','"+G.getPriviledge_level()+"','"+p.getStart_date()+"','"+p.getEnd_date()+"');";
		template.update(sql);
		}
		
		
	   }

	   public List<Booking> getbooksql(String sql)
	   {
	        return template.query(sql, new RowMapper<Booking>() {
	            @Override
	            public Booking mapRow(ResultSet rs, int i) throws SQLException {
	                Booking e=new Booking();
	                e.setBooking_id(rs.getString("Booking_ID"));
	                e.setCustomer_id(rs.getString("Cust_ID"));
	                e.setBooking_date(rs.getDate("Booking_Date"));
	                e.setStart_date(rs.getDate("Start_Date"));
	                e.setEnd_date(rs.getDate("End_Date"));
	                e.setCheckin(rs.getTime("Checkin"));
	                e.setCheckout(rs.getTime("Checkout"));
	                e.setNo_of_members(rs.getInt("No_of_members"));
	                e.setPayment_status(rs.getString("payment_status"));
	                e.setPurpose_of_visit(rs.getString("Purpose_of_visit"));
	      
	                return e;
	            }
	        });
	   
	   }
	   
	   public List<Room_booking> getRoom_booksql(String sql){
	        return template.query(sql, new RowMapper<Room_booking>() {
	            @Override
	            public Room_booking mapRow(ResultSet rs, int i) throws SQLException {
	            	Room_booking e=new Room_booking();
	                e.setBooking_id(rs.getString("Booking_ID"));
	                e.setCount(rs.getInt("count"));
	                e.setPriviledge_level(rs.getInt("priviledge_level"));
	                e.setStart_date(rs.getDate("start_date"));
	                e.setEnd_date(rs.getDate("end_date"));
	                return e;
	            }
	        });
	        		}
	   
	   
	   
	   public int updateCheckin(String id,Time ci){
	        String sql="update Booking set Checkin='"+ci+"' where Booking_Id='"+id+"';";
	        return template.update(sql);
	    }
	   public int updateCheckout(String id,Time co){
	        String sql="update Booking set Checkout='"+co+"' where Booking_Id='"+id+"';";
	        return template.update(sql);
	    }
	   public List<Room_type> RoomAvailByDates(Date startdate,Date enddate){
	       System.out.println(startdate+" "+enddate);
	       
		   String sql1="select * from Room_booking where end_date <= '"+enddate+"' and end_date >= '" +startdate+"' and start_date <='"+startdate+"';";
		   String sql3="select * from Room_booking where start_date <= '"+enddate+"' and start_date >= '"+startdate +"' and end_date > '"+enddate+"';";
		   String sql2="select * from Room_booking where start_date >= '"+startdate+"' and end_date <= '"+enddate +"';";
		   String sql4="select * from Room_booking where start_date <= '"+startdate+"' and end_date >= '"+enddate +"';";
		   System.out.println(sql2);
//		   sql1=sql1 + sql2;
		   List <Room_type> ans= roomdao.getallroomtypes();
		   System.out.println("got rooms :"+ ans.size());
		   
		   List<Room_booking> book= getRoom_booksql(sql1);
		   
		   book.addAll(getRoom_booksql(sql2));
		   book.addAll(getRoom_booksql(sql3));
		   book.addAll(getRoom_booksql(sql4));
		   HashSet <Room_booking> hbook = new HashSet <Room_booking>(book) ;

			System.out.println(book.size());
			System.out.println(hbook.size());
		   book.clear();
		   book.addAll(hbook);
		  
		   
		   LocalDate sd = startdate.toLocalDate();
		   LocalDate ed = enddate.toLocalDate();
		   System.out.println(sd +" "+ sd.plusDays(1));
		   
		
		   for(int j=0;j<ans.size();j++)
			{ int val=1000;
			  
			   for(LocalDate j1=sd;j1.compareTo(ed)<=0;j1=j1.plusDays(1))
			   {int temp=0;
				System.out.println("Date: "+ j1);
				  
				   	for(int i=0;i<book.size();i++)
			   		{
				   		
				   LocalDate s= book.get(i).getStart_date().toLocalDate();
				   LocalDate e= book.get(i).getEnd_date().toLocalDate();
				   if(j1.compareTo(s)>=0&&j1.compareTo(e)<=0)
				   {
					   if(book.get(i).getPriviledge_level()==j+1)
						   temp += book.get(i).getCount();
						   
						   
					   
				   }		   
			   		}
				   	val=Math.min(val,ans.get(j).getTotal_count()-temp);
				   }
			   ans.get(j).setTotal_count(val);
			 }
		   return ans;
		  
	       
	    }
	    
	   
	   
	    public int updatePaymentStatus(String id,String status){
	        String sql="update Booking set Payment_Status="+status+" where Booking_Id="+id;
	        return template.update(sql);
	    }
	    
	   
	   
	   public Booking getBookingById(String id){
	        String sql="select * from Booking where Booking_ID='"+id+"';";
	        List<Booking> books=getbooksql(sql);
	        if(books.size()!=0)
	        return books.get(0);
	        else return null;
	    }
	   
	   
	 
	   public List<Booking> getBookingByCustomer(String id){
	        String sql="select * from Booking where Cust_ID='"+id+"' order by start_date desc";
	        return getbooksql(sql);
	    }

	   public List<Booking> getBookingByStartDate(Date Start_Date){
	        String sql="select * from Booking where Start_Date="+Start_Date;
	        return getbooksql(sql);
	    }
	   public List<Booking> getactiveBookingByDate(Date Date){
	        String sql="select * from Booking where Start_Date <= '"+Date +"' and end_date >='"+Date+"';";
	        return getbooksql(sql);
	    }
	   public List<Booking> getallBookings(){
	        String sql="select * from Booking";
	        return getbooksql(sql);
	        }
	   
	   public List<Room_booking> getBookedRoomtype(String booking_id){
	        String sql="select * from Room_booking where Booking_id='"+booking_id+"';";
	        
	        return getRoom_booksql(sql);
	        }

	   
	   
	   
		public String getbookingIDbyroom_id(String room_id)
		{
			String sql = "select booking_id from books where room_ID='"+room_id+"';";
			

	        return template.queryForObject(sql,String.class);
		}
		
		public String getcustomerIDbybooking_id(String booking_id)
		{
			String sql = "select cust_id from Booking where booking_id='"+booking_id+"';";
			

	        return template.queryForObject(sql,String.class);
		}
		
		public int setRoomNoforBooking(String Booking_id,String Room_no,String cust_id)
		{
			String  sql="insert into books values ('"+Booking_id+"','"+Room_no+"');";
			String sql1="insert into Allotted_to values('"+cust_id+"','"+Room_no+"');";
			String sql2="update Room set status='booked' where room_no='"+Room_no+"';";
		   
		
			template.update(sql);
			template.update(sql1);
			return template.update(sql2);
			
		}
		public int freeRoomNoforBooking(String Room_no)
		{
			String  sql="delete from books where room_id='"+Room_no+"';";

			String  sql1="delete from Allotted_to where room_id='"+Room_no+"';";


			String sql2="update Room set status='free' where room_no='"+Room_no+"';";
			template.update(sql1);
		    template.update(sql);
			return template.update(sql2);
			
		}
		public int freeallroomsforBooking(String booking_id)
		{
			String  sql="delete from books where booking_id='"+booking_id+"';";
			List<Room> rooms= roomdao.getAllRoomsBybookingId(booking_id);
			
			for(int i=0;i<rooms.size();i++)
			{
				freeRoomNoforBooking(rooms.get(i).getRoom_no());
				
				
			}

			return template.update(sql);
			
		}
	 
	 
	 
	   
	

}
