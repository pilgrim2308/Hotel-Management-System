package com.example.demo.controller;

import java.security.Principal;
import java.sql.Date;
import java.sql.Time;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DAO.Bill_DAO;
import com.example.demo.DAO.BookingDAO;
import com.example.demo.DAO.Coupan_DAO;
import com.example.demo.DAO.Invoice_DAO;
import com.example.demo.DAO.Payment_DAO;
import com.example.demo.DAO.RoomDAO;
import com.example.demo.models.Bill;
import com.example.demo.models.Booking;
import com.example.demo.models.Coupon;
import com.example.demo.models.Invoice;
import com.example.demo.models.Payment;
import com.example.demo.models.Room_booking;
import com.example.demo.models.Room_type;



@Controller
@RequestMapping("/customer/booking")
public class BookingController {
	
	@Autowired
	private BookingDAO bookingdao;
	@Autowired
	private RoomDAO roomdao;
	@Autowired
	private Bill_DAO billdao;
	@Autowired
	private Invoice_DAO invoicedao;
	@Autowired
	private Payment_DAO paymentdao;

	@Autowired
	private Coupan_DAO coupondao;
	
	@RequestMapping("/")
	public String getdates(Model m,HttpSession session)
	{
		Booking bd= new Booking();

		m.addAttribute("today",new Date(System.currentTimeMillis()));
		m.addAttribute("bookdetail",bd );
	
		
		return "set_dates";
		
	}

	@RequestMapping(value="/set_dates",method=RequestMethod.POST)
	public String makebooking(@ModelAttribute("bookdetail") Booking bd,Model model,HttpSession session)
	{
		List<Room_type> rooms= bookingdao.RoomAvailByDates(bd.getStart_date(),bd.getEnd_date());
		Room_booking newroom=new Room_booking();
	
		
		
		model.addAttribute("today",new Date(System.currentTimeMillis()));
		model.addAttribute("rooms",rooms);
		model.addAttribute("roombook",new Room_booking());
		model.addAttribute("bookdetail",bd);
		
		session.setAttribute("detail",bd);
		session.setAttribute("room_types",rooms);
		
		
		return "makebooking";
		
	}
	@RequestMapping(value="/addroom",method=RequestMethod.POST)
	public String addroom(@ModelAttribute("roombook") Room_booking room,Model model,Principal principal,HttpSession session)
	{	
	
		 Booking bookdetail=(Booking) session.getAttribute("detail");
		 
		List<Room_type> rooms= bookingdao.RoomAvailByDates(bookdetail.getStart_date(),bookdetail.getEnd_date());
		
		model.addAttribute("rooms",rooms);
		room.setBooking_id(bookdetail.getBooking_id());
		room.setStart_date(bookdetail.getStart_date());
		room.setEnd_date(bookdetail.getEnd_date());
		int i=0;
		for(i=0;i<rooms.size();i++)
		{
			if(rooms.get(i).getTotal_count()<bookdetail.roomcount(room.getPriviledge_level())+room.getCount()&&rooms.get(i).getPriviledge_level()==room.getPriviledge_level())
			{
				model.addAttribute("fullm", "Sorry ! We cannot proceed your request");
				break;
				
			
			}
		}
		if(i==rooms.size())
		
		bookdetail.addRooms(room);
		
		
		
		model.addAttribute("rooms_list",bookdetail.getRooms());
		model.addAttribute("rooms",rooms);
		model.addAttribute("roombook",new Room_booking());
		model.addAttribute("bookdetail",bookdetail);
		
		
		return "makebooking";
		
	}
	@RequestMapping(value="/make",method=RequestMethod.POST)
	public String makepayment(@ModelAttribute("bookdetail") Booking bd,Model model,Principal principal,HttpSession session)
	{
		 Booking bookdetail=(Booking) session.getAttribute("detail");
		
		 
		 
		bookdetail.setPurpose_of_visit(bd.getPurpose_of_visit()); 
		bookdetail.setNo_of_members(bd.getNo_of_members());
		bookdetail.setCustomer_id(principal.getName());
		bookdetail.setBooking_date( new Date(System.currentTimeMillis()));
		bookdetail.setBooking_time(java.sql.Time.valueOf(LocalTime.now()));
		bookdetail.setBooking_id("book_"+bookdetail.getCustomer_id()+UUID.randomUUID());
		bookdetail.setCheckin(null);
		bookdetail.setCheckout(null);
		bookdetail.setPayment_status("processing");
		model.addAttribute("bookdetail",bookdetail);
		
		
		int total_price=0;
		List<Room_booking> rooms=bookdetail.getRooms();
		
		for(int i=0;i<rooms.size();i++)
		{
			total_price+=rooms.get(i).getCount() * roomdao.getpricebyRoomType(rooms.get(i).getPriviledge_level());
		}

		Bill bill=new Bill();
		Payment payment= new Payment();


		List<Coupon> coupons=coupondao.getCouponByCustID(principal.getName());
		coupons.addAll(coupondao.getvalidcoupon(new Date(System.currentTimeMillis())));
		
		
		bill.setPrice(total_price);
	
		payment.setCustomer_id(bookdetail.getCustomer_id());
		payment.setAmount(total_price);
		payment.setBooking_id(bookdetail.getBooking_id());
		payment.setModeofpayment("online");
		payment.setStatus("processing");
		payment.setType("debit");
		
		
		
		
		model.addAttribute("total_price");
		model.addAttribute("payment",payment);
		model.addAttribute("page_type","booking");

		model.addAttribute("coupons",coupons);
		session.setAttribute("coupons",coupons);
		session.setAttribute("payment",payment);
		session.setAttribute("bookdetail",bookdetail);
		session.setAttribute("bill",bill);
		session.setAttribute("total_price",total_price);
		
		return "payment";
		
	}
	@RequestMapping(value="/applycoupon/{id}",method=RequestMethod.GET)
	public String apply_coupon(@PathVariable("id") String id,Model model,Principal principal,HttpSession session)
	{
		 Booking bookdetail=(Booking) session.getAttribute("bookdetail");
		 Bill bill= (Bill) session.getAttribute("bill");
		 Payment payment= (Payment) session.getAttribute("payment");
		 int temp_price=  (int) session.getAttribute("total_price");
		 int total_price=bill.getPrice();
		 

			List<Coupon> coupons=coupondao.getCouponByCustID(principal.getName());
			coupons.addAll(coupondao.getvalidcoupon(new Date(System.currentTimeMillis())));

		
		
		Coupon cp= coupondao.getCouponByID(id);
		
		total_price= Math.max(0,total_price-cp.getDiscount_amount());
		
		bill.setCoupan_ID(id);
	

		
		model.addAttribute("total_price",total_price);
		model.addAttribute("coup_mess","cooupan_applied");
		model.addAttribute("payment",payment);
		model.addAttribute("page_type","booking");

		model.addAttribute("bookdetail",bookdetail);

		model.addAttribute("coupons",coupons);
		session.setAttribute("coupons",coupons);
		session.setAttribute("payment",payment);
		session.setAttribute("bookdetail",bookdetail);
		session.setAttribute("bill",bill);
		session.setAttribute("total_price",total_price);
		
		return "payment";
		
	}
	
	@RequestMapping(value={"/generate_invoice","/applycoupon/generate_invoice"},method=RequestMethod.POST)
	public String generateInvoice(Model model,Principal principal,HttpSession session)
	{
		 Booking bookdetail=(Booking) session.getAttribute("detail");
			Bill bill=(Bill) session.getAttribute("bill");
			Payment payment= (Payment) session.getAttribute("payment");
			
			
			int total_price=(int) session.getAttribute("total_price");
		

		bookdetail.setPayment_status("confirmed");

			
		bookingdao.save(bookdetail);
		
		int bill_no= billdao.gettotalcount()+1;
		
		
		bill.setPrice(total_price);
		bill.setBooking_ID(bookdetail.getBooking_id());
		bill.setBill_No(bill_no);
	
	
		
		billdao.save(bill);
		payment.setStatus("completed");
		payment.setAmount(total_price);
		payment.setBill_no(bill_no);
		payment.setDate(new Date(System.currentTimeMillis()));
		payment.setTime(java.sql.Time.valueOf(LocalTime.now()));
		payment.setPayment_id(payment.getCustomer_id()+"_"+payment.getTime());
		
		
		paymentdao.save(payment);
		
		Invoice invoice= new Invoice();
		
		invoice.setAmount(payment.getAmount());
		invoice.setCustomer_id(payment.getCustomer_id());
		invoice.setDate(payment.getDate());
		invoice.setPayment_id(payment.getPayment_id());
		invoice.setTax(10);
		invoice.setTime(payment.getTime());
		invoice.setInvoice_id(payment.getPayment_id());
		
		invoicedao.save(invoice);
		
		model.addAttribute("invoice",invoice);				
		model.addAttribute("total_price");
	
		
		return "CustInvoice";
		
	}
	
	


}
