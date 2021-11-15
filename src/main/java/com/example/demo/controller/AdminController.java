package com.example.demo.controller;

import java.security.Principal;
import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
import com.example.demo.DAO.Payment_DAO;
import com.example.demo.DAO.RoomDAO;
import com.example.demo.DAO.Room_ServiceDAO;
import com.example.demo.DAO.Salary_DAO;
import com.example.demo.DAO.UserDAO;
import com.example.demo.models.Bank_Details;
import com.example.demo.models.Bill;
import com.example.demo.models.Booking;
import com.example.demo.models.Coupon;
import com.example.demo.models.Customer;
import com.example.demo.models.Customer_email;
import com.example.demo.models.Customer_phone;
import com.example.demo.models.Employee;
import com.example.demo.models.Employee_email;
import com.example.demo.models.Employee_phone;
import com.example.demo.models.Payment;
import com.example.demo.models.Room;
import com.example.demo.models.Room_Service;
import com.example.demo.models.Room_booking;
import com.example.demo.models.Salaries_made;
import com.example.demo.models.User;
import com.example.demo.service.SecurityService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/admin")

public class AdminController {
	@Autowired
	private CustomerDAO customerdao;
	@Autowired
	private EmployeeDAO employeedao;
	@Autowired
	private UserService userservice;
	@Autowired
	private Bankdetail_DAO bankdetaildao;
	
	@Autowired
	private SecurityService securityService;

	@Autowired
	private RoomDAO roomdao;
	@Autowired
	private Coupan_DAO coupondao;
	@Autowired 
	private Payment_DAO paymentdao;
	@Autowired
	private Salary_DAO salarydao;
	
	@Autowired
	private Bill_DAO billdao;
	@Autowired
	private BookingDAO bookingdao;
	
	@Autowired
	Room_ServiceDAO roomservicedao;
	@Autowired
	UserDAO userdao;
	
	
	@RequestMapping("/")
	public String dashboard(ModelMap ModelMap,HttpSession session,Principal principal) {
		
		User user= userservice.findByUsername(principal.getName());
		Payment payment=new Payment();
		List<Employee> employees=employeedao.getallEmployee();
	
		
		ModelMap.addAttribute("emps",employees);
		
		
		ModelMap.addAttribute("salarypayment",payment);
		ModelMap.addAttribute("user",user);
		return "Admin_dashboard";
	}
	
	//Room Service area----------------------------------------------------------
	
	@RequestMapping(value={"room_s/"},method=RequestMethod.GET)
	public String UnassRoomServices(ModelMap m,HttpSession session)
	{
		
		List<Room_Service> room_s=roomservicedao.getRoom_serviceByStatus("initiated");
		System.out.println(room_s.get(0).getService_ID());
		System.out.println(room_s.size());
		List<Employee> employees=employeedao.getallEmployee();
	
		
		m.addAttribute("emps",employees);
		
		
		session.setAttribute("roomservices", room_s);
		m.addAttribute("roomservices",room_s);
		
		return "AdminRoomService";
		
	}
	@RequestMapping(value={"room_s/assign"},method=RequestMethod.POST)
	public String assignRoomService(@RequestParam("serviceid") String serviceid,@RequestParam("username") String username,ModelMap m,HttpSession session)
	{

		
		
		roomservicedao.assignEmployeeRoomService(serviceid,username);
		
		System.out.println(serviceid);
		List<Room_Service> room_s=roomservicedao.getRoom_serviceByStatus("initiated");
		m.addAttribute("roomservices",room_s);
		session.setAttribute("roomservices", room_s);
		
		return "AdminRoomService";
		
		
	}
	//bookings-------------------------------------------------------------------------------------------------------------
	@RequestMapping(value={"booking/"},method=RequestMethod.GET)
	public String BookingRoom(ModelMap m,HttpSession session)
	{
		List<Booking> bookings= bookingdao.getactiveBookingByDate(new Date(System.currentTimeMillis()));
		m.addAttribute("bookings",bookings);
		List<Room> rooms=roomdao.getRoomByavaiability("booked");
		m.addAttribute("bookedroom", rooms);
		
		return "AdminBookingboard";		
		
	}
	@RequestMapping(value={"booking/{id}"},method=RequestMethod.GET)
	public String Bookingdetails(@PathVariable("id") String id,ModelMap m,HttpSession session)
	{
		Booking bookingdetail= bookingdao.getBookingById(id);
	
		
		List<Room_booking> roomtypes= bookingdao.getBookedRoomtype(id);
		bookingdetail.setRoomslist(roomtypes);
		
		List<Room> rooms=roomdao.getAllRoomsBybookingId(id);
		List<Room> free_rooms=roomdao.getRoomByavaiability("free");
		List<Bill> bills= billdao.getpendingbillbybooking_id(id);
		
		m.addAttribute("bookingdetail",bookingdetail);
		m.addAttribute("roomtypes",roomtypes);
		m.addAttribute("free_rooms",free_rooms);
		m.addAttribute("booked_rooms",rooms);
		m.addAttribute("pendingbills",bills);
		
		session.setAttribute("bookingdetail", bookingdetail);
		
		session.setAttribute("roomtypes",roomtypes);
		
		return "AdminBookingboard";		
	}
	
	@RequestMapping(value={"booking/remove/{room_id}"},method=RequestMethod.GET)
	public String addBookingdetail(@PathVariable("room_id") String room_id,ModelMap m,HttpSession session)
	{
		Booking bookingdetail= (Booking) session.getAttribute("bookingdetail");
		
		
		
		bookingdao.freeRoomNoforBooking(room_id);

		List<Room> rooms=roomdao.getAllRoomsBybookingId(bookingdetail.getBooking_id());
		List<Room> free_rooms=roomdao.getRoomByavaiability("free");
		List<Bill> bills= billdao.getpendingbillbybooking_id(bookingdetail.getBooking_id());
		
		m.addAttribute("pendingbills",bills);
		
		m.addAttribute("free_rooms",free_rooms);
		m.addAttribute("booked_rooms",rooms);
	
		m.addAttribute("bookingdetail",bookingdetail);
		m.addAttribute("roomtypes",bookingdetail.getRooms());
		
		
		
		session.setAttribute("bookingdetail", bookingdetail);
		session.setAttribute("roomtypes",bookingdetail.getRooms());
		
		return "AdminBookingboard";		
	}
	@RequestMapping(value={"booking/add/{room_id}"},method=RequestMethod.GET)
	public String allotBookingRoom(@PathVariable("room_id") String room_id,ModelMap m,HttpSession session)
	{

		
		Booking bookingdetail= (Booking) session.getAttribute("bookingdetail");
		
		System.out.println(bookingdetail.getBooking_id());
		
		
		bookingdao.setRoomNoforBooking(bookingdetail.getBooking_id(),room_id,bookingdetail.getCustomer_id());

		List<Room> rooms=roomdao.getAllRoomsBybookingId(bookingdetail.getBooking_id());
		List<Room> free_rooms=roomdao.getRoomByavaiability("free");
		
		if(bookingdetail.getCheckin()==null)
			bookingdao.updateCheckin(bookingdetail.getBooking_id(),java.sql.Time.valueOf(LocalTime.now()));
	List<Bill> bills= billdao.getpendingbillbybooking_id(bookingdetail.getBooking_id());
		
		m.addAttribute("pendingbills",bills);
		

		m.addAttribute("free_rooms",free_rooms);
		m.addAttribute("booked_rooms",rooms);
	
		m.addAttribute("bookingdetail",bookingdetail);
		m.addAttribute("roomtypes",bookingdetail.getRooms());
		
		
		
		session.setAttribute("bookingdetail", bookingdetail);
		session.setAttribute("roomtypes",bookingdetail.getRooms());
		
		return "AdminBookingboard";		
		
		
	}
	

	

	
	@RequestMapping(value={"booking/findbydate"},method=RequestMethod.GET)
	public String BookingRoombydate(@RequestParam("date") Date date,ModelMap m,HttpSession session)
	{
		List<Booking> bookings= bookingdao.getBookingByStartDate(date);
		
		m.addAttribute("bookings",bookings);
		
		return "AdminBookingboard";		
		
	}
	
	@RequestMapping(value={"booking/findbyRoomNo"},method=RequestMethod.GET)
	public String BookingRoombyroom(@RequestParam("room_id") String room_id,ModelMap m,HttpSession session)
	{
		List<Booking> bookings=new ArrayList<Booking>();
		bookings.add(bookingdao.getBookingById(bookingdao.getbookingIDbyroom_id(room_id)));
		
		m.addAttribute("bookings",bookings);
		
		return "AdminBookingboard";		
		
	}
	@RequestMapping(value={"booking/findbyID"},method=RequestMethod.GET)
	public String BookingRoombyid(@RequestParam("booking_id") String booking_id,ModelMap m,HttpSession session)
	{
		List<Booking> bookings=new ArrayList<Booking>();
 	    bookings.add(bookingdao.getBookingById(booking_id));
	
		
		
		m.addAttribute("bookings",bookings);
		
		return "AdminBookingboard";		
		
	}
	@RequestMapping(value={"booking/findbycust"},method=RequestMethod.GET)
	public String BookingRoombycust(@RequestParam("cust_id") String cust_id,ModelMap m,HttpSession session)
	{
		List<Booking> bookings=new ArrayList<Booking>();
 	    bookings=(bookingdao.getBookingByCustomer(cust_id));
	
		
		
		m.addAttribute("bookings",bookings);
		
		return "AdminBookingboard";		
		
	}
	@RequestMapping(value={"booking/checkout/{id}"},method=RequestMethod.GET)
	public String checkoutBooking(@PathVariable("id") String booking_id,ModelMap m,HttpSession session)
	{
		Booking bookings= bookingdao.getBookingById(booking_id);
		
		bookingdao.updateCheckout(booking_id,java.sql.Time.valueOf(LocalTime.now()) );
		bookingdao.freeallroomsforBooking(booking_id);
		
		
		m.addAttribute("bookings",bookings);
		
		return "redirect:/admin/booking/";		
		
	}
	@RequestMapping(value={"booking/cleardues/{id}"},method=RequestMethod.GET)
	public String clearduesBooking(@PathVariable("id") String booking_id,ModelMap m)
	{
		int amount =billdao.clearDues(booking_id,"debit");
	
		
		return "redirect:/admin/";		
		
	}
	@RequestMapping(value={"booking/invoice/{id}"},method=RequestMethod.GET)
	public String invoicesbooking(@PathVariable("id") String booking_id,ModelMap m)
	{
		List<Payment> paym=paymentdao.getAllpaymentByBooking_id(booking_id);
		m.addAttribute("payments",paym);
		return "Invoice";	
		
	}

	
	//employees------------------------------------------------------------

	@RequestMapping(value={"/employee_info"},method=RequestMethod.GET)
	public String getallemployee_info(ModelMap m)
	{
		
		List<User> employees=userdao.getEmployees();
	
		
		m.addAttribute("employees",employees);
		
		return "employeeinfo";
		
	}
	@RequestMapping(value={"/registeremployee"},method=RequestMethod.GET)
	public String registeremployee(ModelMap m)
	{
		
		Employee employee=new Employee();
		
		m.addAttribute("employeedetail",employee);
		
		return "Employee_register";
		
	}
	@RequestMapping(value={"/registeremployee"},method=RequestMethod.POST)
	public String addregisteremployee(@ModelAttribute("employeedetail") Employee employee,ModelMap m)
	{	
		
		
		
		User user = new User();
		System.out.println(employee.getRole());
		
		try {
		
			
			user.setUsername(employee.getEmployee_id());
			user.setRole(employee.getRole());
			user.setPassword(employee.getPassword());
			
			
			userservice.save(user);

			employee.setJoining_date(new Date(System.currentTimeMillis()));
			employee.setCurrent_status("free");
		
			employeedao.save(employee);

	   
	    
		}
	catch(Exception e) {
			m.addAttribute("message","Username already exists");
			
			
			
		}
	
		
		m.addAttribute("employeedetail",new Employee());
		
		return "Employee_register";
		
	}

// coupon

@RequestMapping(value={"coupon/"},method=RequestMethod.GET)
public String coupon(ModelMap m,HttpSession session)
{
	List<Coupon> coupons=coupondao.getvalidcoupon(new Date(System.currentTimeMillis()));
	
	Coupon coupon =new Coupon();
	
	m.addAttribute("coupons",coupons);
	m.addAttribute("coupon",coupon);
	
	return "coupon_board";		
	
}

@RequestMapping(value={"coupon/add"},method=RequestMethod.POST)
public String addcoupon(@ModelAttribute("coupon") Coupon coup,ModelMap m,HttpSession session)
{	
	coup.setCoupan_ID(coup.getName()+"_"+coup.getExpire_Date());
	
	coupondao.save(coup);
	if(coup.getCust_ID().equals(null))
	{
		coupondao.update_cust(coup.getCust_ID(),coup.getCoupan_ID());
	}
	
	return "redirect:/admin/coupon/";				
	
}

@RequestMapping(value={"coupon/remove/{id}"},method=RequestMethod.GET)
public String remove_coupon(@PathVariable("id") String id,ModelMap m,HttpSession session)
{
	coupondao.remove(id);
	m.clear();

	return "redirect:/admin/coupon/";			
	
}
//#####################Salary ####################################################

@RequestMapping(value={"salary/"},method=RequestMethod.POST)
public String Salaryboard(@ModelAttribute("salarypayment") Payment Salaryp,ModelMap m,HttpSession session)
{	

	Salaryp.setDate(new Date(System.currentTimeMillis()));
	Salaryp.setTime(java.sql.Time.valueOf(LocalTime.now()));
	Salaryp.setPayment_id(Salaryp.getCustomer_id()+"_"+Salaryp.getTime());
	Salaryp.setModeofpayment("Offline");
	Salaryp.setStatus("Confirmed");
	Salaryp.setType("Credit");
	salarydao.saveSalarypayment(Salaryp);
	Salaries_made sal= new Salaries_made();
	sal.setEmployee_ID(Salaryp.getCustomer_id());
	sal.setPayment_ID(Salaryp.getPayment_id());
	salarydao.save(sal);
	
	

	
	return "redirect:/admin/";				
	
}
@RequestMapping(value={"salary/{id}"},method=RequestMethod.GET)
public String SalaryReciept(@PathVariable("id") String id,ModelMap m,HttpSession session)
{	
	
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
// ########################### Profile #############################################################
//############################### Profilee############################
@RequestMapping(value={"/profile"},method=RequestMethod.GET)
public String Profile(ModelMap m,HttpSession session,Principal principal)
{	String id=principal.getName();

	Employee emp= employeedao.getEmployeeById(id);
	List<Employee_email> emails= employeedao.getallemails(id);
	List<Employee_phone> nums = employeedao.getallnums(id);
	String bank_id=emp.getBank_reference_no();
	
	if(bank_id==(null))
	{	System.out.println(id);
		Bank_Details bank= new Bank_Details();
		bank.setBank_id(null);
		m.addAttribute("bankdetail",bank);
		
		
	}
	else
	{
		Bank_Details bank1=bankdetaildao.getBankByID(bank_id);
		m.addAttribute("bankdetail",bank1);
	}
		
	
	
	m.addAttribute("emails",emails);
	m.addAttribute("nums",nums);
	m.addAttribute("profile",emp);

	
	return "Profile";				
	
}
@RequestMapping(value={"/custprofile"},method=RequestMethod.GET)
public String custProfile(@RequestParam("cust") String cust1,ModelMap m,HttpSession session,Principal principal)
{	String id=cust1;
Customer cust= customerdao.getCustomer(id);
if(cust==null)
{
    m.addAttribute("message","no such customer");
			return "redirect:/admin/";	
}
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

	m.addAttribute("foreign","true");
	
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
	    } catch(Exception e)
	    {
	    	
	    }
	    System.out.println("bye"+id);
	   employeedao.updatebank(id, bank.getBank_id());
	}
	else {System.out.println("hello"+id);
		bankdetaildao.update(bank);
	
	} 
 
	  
	return "redirect:/admin/profile";				
	
}
@RequestMapping(value={"/profile"},method=RequestMethod.POST)
public String saveProfile(@ModelAttribute("profile") Employee emp,ModelMap m,HttpSession session,Principal principal)
{	String id=principal.getName();
	emp.setEmployee_id(id);
	employeedao.update(emp);
	
	m.addAttribute("profile",emp);
	List<Employee_email> emails= employeedao.getallemails(id);
	List<Employee_phone> nums = employeedao.getallnums(id);
	
	
	m.addAttribute("emails",emails);
	m.addAttribute("nums",nums);

	
	return "Profile";				
	
}
@RequestMapping(value={"/profile/addnum"},method=RequestMethod.POST)
public String addnumprofile(@RequestParam("number") String num,ModelMap m,HttpSession session,Principal principal)
{	String id=principal.getName();
	
employeedao.insertnum(id, num);
  
	return "redirect:/admin/profile";				
	
}
@RequestMapping(value={"/profile/removenum"},method=RequestMethod.POST)
public String removenumprofile(@RequestParam("number") String num,ModelMap m,HttpSession session,Principal principal)
{	String id=principal.getName();
employeedao.removenum(id, num);

	return "redirect:/admin/profile";			
}
@RequestMapping(value={"/profile/addemail"},method=RequestMethod.POST)
public String addemailprofile(@RequestParam("email") String email,ModelMap m,HttpSession session,Principal principal)
{	String id=principal.getName();
employeedao.insertemail(id, email);
   
	return "redirect:/admin/profile";			
	
}
@RequestMapping(value={"/profile/removeemail"},method=RequestMethod.POST)
public String removeemailprofile(@RequestParam("email") String email,ModelMap m,HttpSession session,Principal principal)
{	String id=principal.getName();
employeedao.removeemail(id, email);


return "redirect:/admin/profile";			
}



}
