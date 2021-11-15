package com.example.demo.controller;

import java.security.Principal;
import java.sql.Date;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

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

import com.example.demo.DAO.Bill_DAO;
import com.example.demo.DAO.BookingDAO;
import com.example.demo.DAO.Coupan_DAO;
import com.example.demo.DAO.Food_ItemDAO;
import com.example.demo.DAO.Food_orders_DAO;
import com.example.demo.DAO.Invoice_DAO;
import com.example.demo.DAO.Payment_DAO;
import com.example.demo.DAO.RoomDAO;
import com.example.demo.models.Allotment_list;
import com.example.demo.models.Bill;
import com.example.demo.models.Booking;
import com.example.demo.models.Coupon;
import com.example.demo.models.Food_item;
import com.example.demo.models.Food_orders;
import com.example.demo.models.Invoice;
import com.example.demo.models.Payment;
import com.example.demo.models.Room_booking;
import com.example.demo.models.User;
import com.example.demo.service.UserService;

@Controller
public class Food_OrderController {
	@Autowired
	private UserService userservice;
	@Autowired
	private Food_ItemDAO fooditemdao;
	@Autowired
	private Food_orders_DAO foodorderdao;
	@Autowired
	private Bill_DAO billdao;
	@Autowired
	private Invoice_DAO invoicedao;
	@Autowired
	private Payment_DAO paymentdao;
	@Autowired
	private RoomDAO roomdao;
	@Autowired
	private BookingDAO bookingdao;
	@Autowired
	private Coupan_DAO coupondao;
	
	
	
	@RequestMapping("customer/foodorder/")
	public String dashboard(Model m,HttpSession session,Principal principal) {
		
		
		Food_orders foodorder=new Food_orders();
		List<Food_item> items= fooditemdao.getallFood_item();
		List <Allotment_list> roominfo= roomdao.getroomsbycust_id(principal.getName()); 
		

		m.addAttribute("roominfo",roominfo);
		m.addAttribute("products",items);
		session.setAttribute("Order",foodorder);
		
		return "CustFoodorder";
	}
	@RequestMapping("customer/foodorder/add/{id}&{price}")
	public String add_item(@PathVariable("id") String id,@PathVariable("price") int price,Model m,HttpSession session,Principal principal) {
		
		Food_orders foodorder=(Food_orders) session.getAttribute("Order");
		
		foodorder.addItem(id,price);
		
		List<Food_item> items= fooditemdao.getallFood_item();
	List <Allotment_list> roominfo= roomdao.getroomsbycust_id(principal.getName()); 
		

		m.addAttribute("roominfo",roominfo);
		
		m.addAttribute("products",items);
		
		m.addAttribute("food_order_list",foodorder.getItems());
		session.setAttribute("Order",foodorder);
		
		return "CustFoodorder";
	}

	@RequestMapping("customer/foodorder/remove/{id}")
	public String remove_item(@PathVariable("id") String id,Model m,HttpSession session,Principal principal) {
		Food_orders foodorder=(Food_orders) session.getAttribute("Order");
		
		foodorder.removeItem(id);
		List<Food_item> items= fooditemdao.getallFood_item();
	List <Allotment_list> roominfo= roomdao.getroomsbycust_id(principal.getName()); 
		

		m.addAttribute("roominfo",roominfo);
		
		m.addAttribute("products",items);
		
		m.addAttribute("food_order_list",foodorder.getItems());
		session.setAttribute("Order",foodorder);
		
		return "CustFoodorder";
		
		}
	
	
	@RequestMapping(value={"customer/foodorder/createorder","customer/foodorder/remove/createorder","customer/foodorder/add/createorder"},method=RequestMethod.POST)
	public String create_Order(@RequestParam("pay") String payopt,@RequestParam("room_id") String room_id,@RequestParam("total") int total,Model m,HttpSession session,Principal principal) {
		
		
		
		
		int count=foodorderdao.gettotalcount();
		Food_orders foodorder=(Food_orders) session.getAttribute("Order");
		foodorder.setOrder_No(count+1);
		foodorder.setDate(new Date(System.currentTimeMillis()));
		foodorder.setTime(java.sql.Time.valueOf(LocalTime.now()));
		foodorder.setROOM_ID(room_id);
		foodorder.setTotal_Price(total);
		foodorder.setStatus("placed");
		
		System.out.println("kadak hai");
		String booking_id="";
		try {
		
		 booking_id = bookingdao.getbookingIDbyroom_id(room_id);
		
		}
		catch(Exception e){
			
			m.addAttribute("message","This rooms does not belong to u!!");
			List<Food_item> items= fooditemdao.getallFood_item();
			
			m.addAttribute("products",items);
			
			m.addAttribute("food_order_list",foodorder.getItems());
			session.setAttribute("Order",foodorder);
			return "CustFoodorder";
			
		}
		Bill bill= new Bill();
		int bill_no= billdao.gettotalcount()+1;
		
		
		bill.setBooking_ID(booking_id);
		bill.setOrder_No(foodorder.getOrder_No());
		bill.setPrice(foodorder.getTotal_Price());
		bill.setBill_No(bill_no);
	List <Allotment_list> roominfo= roomdao.getroomsbycust_id(principal.getName()); 
		

		m.addAttribute("roominfo",roominfo);
		
		
		
		if(payopt.equals("pay_now"))
		{
			Payment payment= new Payment();
			
			String customer_id= bookingdao.getcustomerIDbybooking_id(booking_id);

			List<Coupon> coupons=coupondao.getCouponByCustID(customer_id);
			coupons.addAll(coupondao.getvalidcoupon(new Date(System.currentTimeMillis())));
			
			payment.setCustomer_id(customer_id);
			payment.setAmount(bill.getPrice());
			payment.setBooking_id(booking_id);
			payment.setModeofpayment("online");
			payment.setStatus("processing");
			payment.setType("debit");
			

			m.addAttribute("total_price",bill.getPrice());
			m.addAttribute("payment",payment);
			m.addAttribute("coupons",coupons);
			session.setAttribute("coupons",coupons);
			session.setAttribute("payment",payment);
			session.setAttribute("foodorder",foodorder);
			session.setAttribute("bill",bill);
			session.setAttribute("total_price",bill.getPrice());
			
			m.addAttribute("page_type","foodorder");
			
			return "payment";
		}
		
		else 
		{
			foodorderdao.save(foodorder);
			
			billdao.save(bill);
		return "redirect:/customer/";
		}
	}
	@RequestMapping(value="customer/foodorder/applycoupon/{id}",method=RequestMethod.GET)
	public String apply_coupon(@PathVariable("id") String id,Model model,Principal principal,HttpSession session)
	{
		Food_orders foodorder=(Food_orders) session.getAttribute("foodorder");
		
		 Bill bill= (Bill) session.getAttribute("bill");
		 Payment payment= (Payment) session.getAttribute("payment");
		 int temp_price=  (int) session.getAttribute("total_price");
		 int total_price=bill.getPrice();
			List <Allotment_list> roominfo= roomdao.getroomsbycust_id(principal.getName()); 
			

			model.addAttribute("roominfo",roominfo);

		
		
		Coupon cp= coupondao.getCouponByID(id);
		
		total_price= Math.max(0,total_price-cp.getDiscount_amount());
		
		bill.setCoupan_ID(id);
	

		List<Coupon> coupons=coupondao.getCouponByCustID(principal.getName());
		coupons.addAll(coupondao.getvalidcoupon(new Date(System.currentTimeMillis())));
		
		
		model.addAttribute("total_price");
		model.addAttribute("payment",payment);
		model.addAttribute("page_type","booking");

		model.addAttribute("coupons",coupons);
		session.setAttribute("coupons",coupons);
		
		session.setAttribute("payment",payment);
		session.setAttribute("bill",bill);

		session.setAttribute("foodorder",foodorder);
		session.setAttribute("total_price",total_price);
		
		return "payment";
		
	}

	@RequestMapping(value={"customer/foodorder/generate_invoice","customer/foodorder/remove/generate_invoice","customer/foodorder/add/generate_invoice","customer/foodorder/applycoupon/generate_invoice"},method=RequestMethod.POST)
	public String generateInvoice(Model model,Principal principal,HttpSession session)
	{
			Food_orders foodorder= (Food_orders) session.getAttribute("foodorder");
			Bill bill=(Bill) session.getAttribute("bill");
			Payment payment= (Payment) session.getAttribute("payment");
			int total_price=(int) session.getAttribute("total_price");
		


		foodorderdao.save(foodorder);
		
		bill.setPrice(total_price);
	
		payment.setAmount(total_price);
		payment.setBill_no(bill.getBill_No());
		payment.setDate(new Date(System.currentTimeMillis()));
		payment.setTime(java.sql.Time.valueOf(LocalTime.now()));
		payment.setPayment_id(payment.getCustomer_id()+"_"+payment.getTime()+"_"+payment.getBooking_id());
		
		billdao.save(bill);
		
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
