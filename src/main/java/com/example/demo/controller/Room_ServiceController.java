package com.example.demo.controller;

import java.security.Principal;
import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DAO.Food_ItemDAO;
import com.example.demo.DAO.Food_orders_DAO;
import com.example.demo.DAO.Payment_DAO;
import com.example.demo.DAO.RoomDAO;
import com.example.demo.DAO.Room_ServiceDAO;
import com.example.demo.models.Allotment_list;
import com.example.demo.models.Booking;
import com.example.demo.models.Room_Service;
import com.example.demo.models.User;
import com.example.demo.service.UserService;

@Controller
public class Room_ServiceController {
	@Autowired
	Room_ServiceDAO roomservicedao;
	@Autowired
	private UserService userservice;

	@Autowired
	private Food_ItemDAO fooditemdao;
	@Autowired
	private Food_orders_DAO foodorderdao;
	
	@Autowired
	private Payment_DAO paymentdao;
	@Autowired
	private RoomDAO roomdao;
	
	
	@RequestMapping(value={"/customer/room_s/create/","/admin/room_s/create/"},method=RequestMethod.GET)
	public String custroomservice(Model m,HttpSession session,Principal principal)
	{
		System.out.println("here");
		
		User user= userservice.findByUsername(principal.getName());
		List <Allotment_list> roominfo= roomdao.getroomsbycust_id(principal.getName()); 
		
		Room_Service rs= new Room_Service();
		m.addAttribute("roomservicedetail",rs );
		m.addAttribute("requesterrole",user.getRole());
		m.addAttribute("roominfo",roominfo);
	
		
		return "createRoomService";
		
	}
	@RequestMapping(value={"/customer/room_s/create/","/admin/room_s/create/"},method=RequestMethod.POST)
	public String createcustroomservice(@ModelAttribute("roomservicedetail") Room_Service rs,Model m,HttpSession session,Principal principal)
	{
		
		rs.setDate(new Date(System.currentTimeMillis()));
		rs.setStatus("initiated");
		rs.setTime(java.sql.Time.valueOf(LocalTime.now()));
		rs.setService_ID(rs.getROOM_ID()+rs.getTime());
		
		roomservicedao.save(rs);
		
		m.addAttribute("roomservicedetail",new Room_Service() );
		m.addAttribute("response","Your Request will be Completed soon !!");
		return "createRoomService";
		
	}


	@RequestMapping("/customer/room_s/byroomid")
	public String getcustroomserviceByRoomID(@RequestParam("roomid") String roomid, Model m,HttpSession session)
	{
		Booking bd= new Booking();
		m.addAttribute("bookdetail",bd );
	
		
		return "set_dates";
		
	}
	@RequestMapping("/customer/room_s/byserviceid")
	public String getcustroomserviceByServiceID(@RequestParam("serviceid") String serviceid,Model m,HttpSession session)
	{
		Booking bd= new Booking();
		m.addAttribute("bookdetail",bd );
	
		
		return "set_dates";
		
	}
	
	
	
	
	@RequestMapping(value={"/employee/room_s/duties"},method=RequestMethod.GET)
	public String assignedRoomService(Model m,HttpSession session,Principal principal)
	{
		List <Room_Service> room_s=roomservicedao.getRoom_serviceByEmpID(principal.getName(),"assigned");
	
		m.addAttribute("roomservices",room_s);
		return "EmployeeRoomService";
		
	}
	@RequestMapping(value={"/employee/room_s/done/{id}"},method=RequestMethod.GET)
	public String completedRoomServices(@PathVariable("id") String id,Model m,HttpSession session,Principal principal)
	{

		System.out.println(id);
		roomservicedao.setRoom_serviceStatus(id,"completed");
	
		

		return "redirect:/employee/room_s/duties";
		
	}
	
	
	



}
