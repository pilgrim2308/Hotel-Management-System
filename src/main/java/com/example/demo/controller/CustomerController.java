package com.example.demo.controller;

import java.security.Principal;
import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DAO.Bankdetail_DAO;
import com.example.demo.DAO.Bill_DAO;
import com.example.demo.DAO.BookingDAO;
import com.example.demo.DAO.Coupan_DAO;
import com.example.demo.DAO.CustomerDAO;
import com.example.demo.DAO.EmployeeDAO;
import com.example.demo.DAO.Feedback_DAO;
import com.example.demo.DAO.Food_ItemDAO;
import com.example.demo.DAO.Food_orders_DAO;
import com.example.demo.DAO.Invoice_DAO;
import com.example.demo.DAO.Order_itemDAO;
import com.example.demo.DAO.Payment_DAO;
import com.example.demo.DAO.RoomDAO;
import com.example.demo.DAO.Room_ServiceDAO;
import com.example.demo.DAO.Salary_DAO;
import com.example.demo.DAO.UserDAO;
import com.example.demo.models.Bank_Details;
import com.example.demo.models.Booking;
import com.example.demo.models.Customer;
import com.example.demo.models.Customer_email;
import com.example.demo.models.Customer_phone;
import com.example.demo.models.Employee_email;
import com.example.demo.models.Employee_phone;
import com.example.demo.models.Feedback;
import com.example.demo.models.Food_orders;
import com.example.demo.models.Payment;
import com.example.demo.models.User;
import com.example.demo.service.SecurityService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerdao;
	@Autowired
	private UserService userservice;
	
	@Autowired
	private SecurityService securityService;
	@Autowired
	private BookingDAO bookingdao;
	@Autowired
	private RoomDAO roomdao;
	@Autowired
	private Bankdetail_DAO bankdetaildao;
	@Autowired
	private Bill_DAO billdao;
	@Autowired
	private Invoice_DAO invoicedao;
	@Autowired
	private Payment_DAO paymentdao;

	@Autowired
	private Coupan_DAO coupondao;
	
	@Autowired 
	private Feedback_DAO feedbackdao;
	
	@Autowired
	private EmployeeDAO employeedao;


	@Autowired
	private Salary_DAO salarydao;
	@Autowired
	private Food_ItemDAO fooditemdao;
	@Autowired
	private Food_orders_DAO foodorderdao;
	@Autowired
	private Order_itemDAO foodorderitemdao;
	

	@Autowired
	Room_ServiceDAO roomservicedao;
	@Autowired
	UserDAO userdao;
	
	
	@RequestMapping("/")
	public String dashboard(Model m, Principal principal) {
		
		   User user = userservice.findByUsername(principal.getName());
		   
		   List<Feedback> feeds = feedbackdao.getallfeddbacks();
		   Feedback feedback= new Feedback();
		   
		   
		   
		   m.addAttribute("feedback_detail",feedback);
		   m.addAttribute("user",user);
		   m.addAttribute("feedbacks",feeds);
		
		return "cust_dashboard";
	}
	@RequestMapping(value={"/add_feedback"},method=RequestMethod.POST)
	public String addfeedback(@ModelAttribute("feedback_detail") Feedback feedb,Model m, Principal principal) {
		
		   User user = userservice.findByUsername(principal.getName());
		   
		   feedb.setCust_ID(principal.getName());
		   feedb.setDate(new Date(System.currentTimeMillis()));
		   feedb.setTime(java.sql.Time.valueOf(LocalTime.now()));

		   feedb.setFeedback_ID(feedb.getCust_ID()+feedb.getTime());
		   List<Feedback> feeds = feedbackdao.getallfeddbacks();
		   
		   
			 
		   m.addAttribute("user",user);
		   m.addAttribute("feedbacks",feeds);
		   
		   try {
		   feedbackdao.save(feedb);
		   }
		   catch (Exception e)
		   {
			   
			   m.addAttribute("message","Please enter the correct Booking ID");
				
				return "cust_dashboard";
		   }
		
		
		return "redirect:/customer/";
	}
	//######################################## profile management###############################
	@RequestMapping(value={"/profile"},method=RequestMethod.GET)
	public String Profile(Model m, Principal principal) {
		
		 Customer cust= customerdao.getCustomer(principal.getName());
		 System.out.println(principal.getName());
		 List<Customer_email> emails= customerdao.getallemails(cust.getCust_ID());
			List<Customer_phone> nums = customerdao.getallnum(cust.getCust_ID());
			
			String bank_id=cust.getBank_Ref_No();
			
			if(bank_id==(null))
			{
				Bank_Details bank= new Bank_Details();
				m.addAttribute("bankdetail",bank);
				
				
			}
			else
			{
				Bank_Details bank1=bankdetaildao.getBankByID(bank_id);
				System.out.println(bank1.getAccount_Number());
				m.addAttribute("bankdetail",bank1);
			}
				
			
			
			m.addAttribute("emails",emails);
			m.addAttribute("nums",nums);
		 
		 m.addAttribute("profile",cust);
		
		return "Profile";
	}
	@RequestMapping(value={"profile/bankdetail"},method=RequestMethod.POST)
	public String addbank(@ModelAttribute("bankdetail") Bank_Details bank,ModelMap m,HttpSession session,Principal principal)
	{	String id=principal.getName();
	if(bank.getBank_id()==null)
	{
		System.out.println("new");
		bank.setBank_id(bank.getBank_Name()+'_'+bank.getAccount_Number());
		bankdetaildao.save(bank);
     	customerdao.updatebank(id, bank.getBank_id());
	}
	else {
		bankdetaildao.update(bank);

	}
		return "redirect:/customer/profile";				
		
	}
	
	@RequestMapping(value={"profile/addnum"},method=RequestMethod.POST)
	public String addnumprofile(@RequestParam("number") String num,ModelMap m,HttpSession session,Principal principal)
	{	String id=principal.getName();
		
	customerdao.insertnum(id, num);
	  
		return "redirect:/customer/profile";				
		
	}
	
	@RequestMapping(value={"profile/removenum"},method=RequestMethod.POST)
	public String removenumprofile(@RequestParam("number") String num,ModelMap m,HttpSession session,Principal principal)
	{	String id=principal.getName();
	   customerdao.removenum(id, num);

		return "redirect:/customer/profile";			
	}
	@RequestMapping(value={"profile/addemail"},method=RequestMethod.POST)
	public String addemailprofile(@RequestParam("email") String email,ModelMap m,HttpSession session,Principal principal)
	{	String id=principal.getName();
	customerdao.insertemail(id, email);
	   
		return "redirect:/customer/profile";			
		
	}
	@RequestMapping(value={"profile/removeemail"},method=RequestMethod.POST)
	public String removeemailprofile(@RequestParam("email") String email,ModelMap m,HttpSession session,Principal principal)
	{	String id=principal.getName();
	customerdao.removeemail(id, email);
	

	return "redirect:/customer/profile";			
	}
	@RequestMapping(value={"/profile"},method=RequestMethod.POST)
	public String saveProfile(@ModelAttribute("profile") Customer cust,ModelMap m,HttpSession session,Principal principal)
	{	String id=principal.getName();
	    cust.setCust_ID(id);
	    List<Customer_email> emails= customerdao.getallemails(id);
		List<Customer_phone> nums = customerdao.getallnum(id);
		
		
		m.addAttribute("emails",emails);
		m.addAttribute("nums",nums);
	    
	    customerdao.update(cust);
		return "Profile";				
		
	}
	// Food Orders #############################################################################
	@RequestMapping(value="/invoice/{id}",method=RequestMethod.GET)
	public String BookinghistroryInvoices(@PathVariable("id") String booking_id,Model model,Principal principal)
	{
		List<Payment> paym=paymentdao.getAllpaymentByBooking_id(booking_id);
		model.addAttribute("payments",paym);
		return "Invoice";
		
	}
	//food Order 
	@RequestMapping(value={"/foodorder/{order_id}"},method=RequestMethod.POST)
	public String foodordersbyid(@PathVariable("order_id") int id,ModelMap m,HttpSession session,Principal principal)
	{	
		Food_orders order= foodorderdao.getFood_OrderByID(id);
		
	    order.setItems(foodorderitemdao.getAllorderitems(order.getOrder_No()));
		
		List<Food_orders> orders= new ArrayList<>();
		orders.add(order);
		m.addAttribute("orders",orders);

		
		return "Foodorders";				
		
	}
	@RequestMapping(value="/bookinghistory",method=RequestMethod.GET)
	public String Bookinghistrory(Model model,Principal principal)
	{
		List<Booking> books=bookingdao.getBookingByCustomer(principal.getName());
		model.addAttribute("bookings",books);
		return "bookinghistory";
		
	}


}
