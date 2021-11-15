package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DAO.Products_DAO;
import com.example.demo.DAO.RoomDAO;
import com.example.demo.DAO.Room_ContainsDAO;
import com.example.demo.DAO.Room_ServiceDAO;
import com.example.demo.models.Food_item;
import com.example.demo.models.Food_orders;
import com.example.demo.models.Products;
import com.example.demo.models.Room_Service;
import com.example.demo.models.Room_contains;
import com.example.demo.models.User;
import com.example.demo.service.UserService;


@Controller
@RequestMapping(value={"/employee/room_invent","/admin/room_invent"})
public class Inventory_controller {

	
	@Autowired
	Room_ServiceDAO roomservicedao;
	@Autowired
	private UserService userservice;
	@Autowired
	private RoomDAO roomdao;
	@Autowired
	private Products_DAO productdao;
	@Autowired 
	private Room_ContainsDAO roominventorydao;
	

	
	@RequestMapping(value={"/"})
	public String inventboard(Model m,HttpSession session,Principal principal)
	{
		System.out.println("here");
		
		User user= userservice.findByUsername(principal.getName());
		
		Products prod=new Products();
		List<Products> prod_list= productdao.getall();
	
		
		m.addAttribute("product",prod);
		m.addAttribute("items",prod_list);
		session.setAttribute("items",prod_list);
				
		
		return "Inventoryboard";
		
	}
	
	@RequestMapping(value={"/addproduct"})
	public String inventboard(@ModelAttribute("product") Products p,Model m,HttpSession session,Principal principal)
	{
		System.out.println("here");
//		try{
			p.setProduct_ID(p.getName()+'_'+p.getDescription());
			productdao.save(p);

			roominventorydao.addproducts(p);
			
			
			
//		}
//		catch (Exception e)
//		{
//			m.addAttribute("message","Please try again !!");
//			
//		}
		
		User user= userservice.findByUsername(principal.getName());
		
		Products prod=new Products();
		List<Products> prod_list= productdao.getall();
		
	
		
		m.addAttribute("product",prod);
		m.addAttribute("items",prod_list);
		session.setAttribute("items",prod_list);
				
		
		return "Inventoryboard";
		
	}
	@RequestMapping("/inc/{id}")
	public String add_item(@PathVariable("id") String id,Model m,HttpSession session,Principal principal) {
		
		productdao.addQuantity(id,1);
		

		return "redirect:/employee/room_invent/";
	}

	@RequestMapping("/dec/{id}")
	public String remove_item(@PathVariable("id") String id,Model m,HttpSession session,Principal principal) {
	
		productdao.removeQuantity(id,1);
		return "redirect:/employee/room_invent/";
		
		}
	@RequestMapping("/inc_rmi/{id}")
	public String add_item_room(@PathVariable("id") String id,Model m,HttpSession session,Principal principal) {

		String room_id= (String) session.getAttribute("roomno");
		
		
		
		int val=productdao.removeQuantity(id,1);
		if(val==-1)
		{
			m.addAttribute("message","Not available");
		}
		else 
		
		roominventorydao.addquantity(id, room_id,1);

		List<Room_contains> room_invent=roominventorydao.getbyroom_id(room_id);

		Products prod=new Products();
		List<Products> prod_list= productdao.getall();
		System.out.println("correct place");

		
		m.addAttribute("product",prod);
		m.addAttribute("items",prod_list);
		session.setAttribute("items",prod_list);
		
		m.addAttribute("room_items",room_invent);
		m.addAttribute("roomno",room_id);
		session.setAttribute("roomno", room_id);
		session.setAttribute("room_items",room_invent);	
		
		

		return "redirect:/employee/room_invent/";
		
	}

	@RequestMapping("/dec_rmi/{id}")
	public String remove_item_room(@PathVariable("id") String id,Model m,HttpSession session,Principal principal) {

		String room_id= (String) session.getAttribute("roomno");
		roominventorydao.removequantity(id, room_id,1);


		Products prod=new Products();
		List<Products> prod_list= productdao.getall();

		List<Room_contains> room_invent=roominventorydao.getbyroom_id(room_id);
		
		m.addAttribute("product",prod);
		m.addAttribute("items",prod_list);
		m.addAttribute("room_items",room_invent);
		m.addAttribute("roomno",room_id);
		

		session.setAttribute("items",prod_list);
		
		session.setAttribute("roomno", room_id);
		session.setAttribute("room_items",room_invent);	

		return "redirect:/employee/room_invent/";
		
		}
	
	@RequestMapping(value={"/getbyroom"},method=RequestMethod.POST)
	public String getindentorybyID(@RequestParam("room_id") String room_id,Model m,HttpSession session,Principal principal) {
		
	List<Room_contains> room_invent=roominventorydao.getbyroom_id(room_id);

	Products prod=new Products();
	List<Products> prod_list= productdao.getall();

	
	m.addAttribute("product",prod);
	m.addAttribute("items",prod_list);
	session.setAttribute("items",prod_list);
	
	m.addAttribute("room_items",room_invent);
	m.addAttribute("roomno",room_id);
	session.setAttribute("roomno", room_id);
	session.setAttribute("room_items",room_invent);	

		return "Inventoryboard";
		
		}
	
	
}
