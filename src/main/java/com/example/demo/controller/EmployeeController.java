package com.example.demo.controller;

import java.security.Principal;
import java.sql.Date;
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
import com.example.demo.DAO.Food_ItemDAO;
import com.example.demo.DAO.Food_orders_DAO;
import com.example.demo.DAO.Order_itemDAO;
import com.example.demo.DAO.Payment_DAO;
import com.example.demo.DAO.RoomDAO;
import com.example.demo.DAO.Room_ServiceDAO;
import com.example.demo.DAO.Salary_DAO;
import com.example.demo.DAO.UserDAO;
import com.example.demo.models.Bank_Details;
import com.example.demo.models.Employee;
import com.example.demo.models.Employee_email;
import com.example.demo.models.Employee_phone;
import com.example.demo.models.Food_orders;
import com.example.demo.models.Payment;
import com.example.demo.models.Salaries_made;
import com.example.demo.models.User;
import com.example.demo.service.SecurityService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private CustomerDAO customerdao;
	@Autowired
	private EmployeeDAO employeedao;
	@Autowired
	private UserService userservice;
	
	@Autowired
	private SecurityService securityService;
	@Autowired
	private Bankdetail_DAO bankdetaildao;
	@Autowired
	private RoomDAO roomdao;
	@Autowired
	private Coupan_DAO coupondao;
	@Autowired 
	private Payment_DAO paymentdao;
	@Autowired
	private Salary_DAO salarydao;
	@Autowired
	private Food_ItemDAO fooditemdao;
	@Autowired
	private Food_orders_DAO foodorderdao;
	@Autowired
	private Order_itemDAO foodorderitemdao;
	
	@Autowired
	private Bill_DAO billdao;
	@Autowired
	private BookingDAO bookingdao;
	
	@Autowired
	Room_ServiceDAO roomservicedao;
	@Autowired
	UserDAO userdao;
	
	@RequestMapping("/")
	public String dashboard(Model m,HttpSession session,Principal principal) {
		
		User user= userservice.findByUsername(principal.getName());
		m.addAttribute("user",user);
		
		
		return "emp_dashboard";
	}
	
	@RequestMapping(value={"salary/"},method=RequestMethod.GET)
	public String SalaryReciept(ModelMap m,HttpSession session,Principal principal)
	{	String id=principal.getName();
		
		List<Salaries_made> sals=salarydao.getSalaryByEmp_ID(id);
		List<Payment> pays= new ArrayList();
		
		for(int i=0;i<sals.size();i++)
		{
			pays.add(paymentdao.getPaymentByID(sals.get(i).getPayment_ID()));
			pays.get(i).setCustomer_id(sals.get(i).getEmployee_ID());
		}
		
		m.addAttribute("salaries",pays);

		
		return "SalaryPortal";				
		
	}
	

	// foodorders management
	@RequestMapping(value={"/foodorders/"},method=RequestMethod.GET)
	public String foodorders(ModelMap m,HttpSession session,Principal principal)
	{	
		List<Food_orders> orders= foodorderdao.getAllFoodOrderBYDate(new Date(System.currentTimeMillis()));
		
		for(int i=0;i<orders.size();i++)
		{
			orders.get(i).setItems(foodorderitemdao.getAllorderitems(orders.get(i).getOrder_No()));
		}
		System.out.println(orders.size());
		m.addAttribute("orders",orders);

		
		return "Foodorders";				
		
	}
	@RequestMapping(value={"/foodorders/order_no"},method=RequestMethod.POST)
	public String foodordersbyid(@RequestParam("order_no") int id,ModelMap m,HttpSession session,Principal principal)
	{	
		List<Food_orders> orders=new ArrayList<>();
		try{
			Food_orders food= foodorderdao.getFood_OrderByID(id);
			food.setItems(foodorderitemdao.getAllorderitems(food.getOrder_No()));
			
			
			orders.add(food);
		
		}
		catch(Exception e)
		{
			m.addAttribute("message", "no such order");
		}
		
		
		
		m.addAttribute("orders",orders);

		
		return "Foodorders";				
		
	}
	@RequestMapping(value={"/foodorders/bydate"},method=RequestMethod.POST)
	public String foodordersbydate(@RequestParam("date") Date date,ModelMap m,HttpSession session,Principal principal)
	{	
		List<Food_orders> orders= foodorderdao.getAllFoodOrderBYDate(date);
		
		for(int i=0;i<orders.size();i++)
		{
			orders.get(i).setItems(foodorderitemdao.getAllorderitems(orders.get(i).getOrder_No()));
		}
		
		m.addAttribute("orders",orders);

		
		return "Foodorders";				
		
	}
	
	@RequestMapping(value={"/foodorders/{id}"},method=RequestMethod.GET)
	public String foodorders(@PathVariable("id") int id,ModelMap m,HttpSession session,Principal principal)
	{	
	   foodorderdao.setFood_Orderstatus(id, "Completed");
		
		return "redirect:/employee/foodorders/";				
		
	}
	//  ############################### Profilee############################
	@RequestMapping(value={"/profile"},method=RequestMethod.GET)
	public String Profile(ModelMap m,HttpSession session,Principal principal)
	{	String id=principal.getName();
		System.out.println(id);
		Employee emp= employeedao.getEmployeeById(id);
		List<Employee_email> emails= employeedao.getallemails(id);
		List<Employee_phone> nums = employeedao.getallnums(id);
		
		
		m.addAttribute("emails",emails);
		m.addAttribute("nums",nums);
		m.addAttribute("profile",emp);

		
		return "Profile";				
		
	}
	
	@RequestMapping(value={"/profile"},method=RequestMethod.POST)
	public String saveProfile(@ModelAttribute("profile") Employee emp,ModelMap m,HttpSession session,Principal principal)
	{	String id=principal.getName();
		emp.setEmployee_id(id);
		employeedao.update(emp);
		
		m.addAttribute("profile",emp);
		List<Employee_email> emails= employeedao.getallemails(id);
		List<Employee_phone> nums = employeedao.getallnums(id);
		
		String bank_id=emp.getBank_reference_no();
		
		if(bank_id==null)
		{
			Bank_Details bank= new Bank_Details();
			m.addAttribute("bankdetail",bank);
			
			
		}
		else
		{
			Bank_Details bank1=bankdetaildao.getBankByID(bank_id);
			m.addAttribute("bankdetail",bank1);
		}
			
		
		
		m.addAttribute("emails",emails);
		m.addAttribute("nums",nums);

		
		return "Profile";				
		
	}
	@RequestMapping(value={"profile/bankdetail"},method=RequestMethod.POST)
	public String addbank(@ModelAttribute("bankdetail") Bank_Details bank,ModelMap m,HttpSession session,Principal principal)
	{	String id=principal.getName();
	if(bank.getBank_id()==null)
	{
	    
		bank.setBank_id(bank.getBank_Name()+'_'+bank.getAccount_Number());
		try {
		bankdetaildao.save(bank);
		}
		catch(Exception e)
		{
			
		}
		employeedao.updatebank(id, bank.getBank_id());
	}
	else {
		bankdetaildao.update(bank);

	}
	  
		return "redirect:/employee/profile";				
		
	}
	@RequestMapping(value={"/profile/addnum"},method=RequestMethod.POST)
	public String addnumprofile(@RequestParam("number") String num,ModelMap m,HttpSession session,Principal principal)
	{	String id=principal.getName();
		
	employeedao.insertnum(id, num);
	  
		return "redirect:/employee/profile";				
		
	}
	@RequestMapping(value={"/profile/removenum"},method=RequestMethod.POST)
	public String removenumprofile(@RequestParam("number") String num,ModelMap m,HttpSession session,Principal principal)
	{	String id=principal.getName();
	employeedao.removenum(id, num);

		return "redirect:/employee/profile";			
	}
	@RequestMapping(value={"/profile/addemail"},method=RequestMethod.POST)
	public String addemailprofile(@RequestParam("email") String email,ModelMap m,HttpSession session,Principal principal)
	{	String id=principal.getName();
	employeedao.insertemail(id, email);
	   
		return "redirect:/employee/profile";			
		
	}
	@RequestMapping(value={"/profile/removeemail"},method=RequestMethod.POST)
	public String removeemailprofile(@RequestParam("email") String email,ModelMap m,HttpSession session,Principal principal)
	{	String id=principal.getName();
	employeedao.removeemail(id, email);
	

	return "redirect:/employee/profile";			
	}
	



}
