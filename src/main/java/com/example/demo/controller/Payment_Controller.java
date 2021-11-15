package com.example.demo.controller;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DAO.Food_ItemDAO;
import com.example.demo.DAO.Food_orders_DAO;
import com.example.demo.models.Food_item;
import com.example.demo.models.Food_orders;
import com.example.demo.service.UserService;

@Controller
public class Payment_Controller {
	@Autowired
	private UserService userservice;
	@Autowired
	private Food_ItemDAO fooditemdao;
	@Autowired
	private Food_orders_DAO foodorderdao;
	@RequestMapping("customer/payment/")
	public String dashboard(Model m,HttpSession session,Principal principal) {
		
		
		Food_orders foodorder=new Food_orders();
		List<Food_item> items= fooditemdao.getallFood_item();
		
		m.addAttribute("products",items);
		session.setAttribute("Order",foodorder);
		
		return "CustFoodorder";
	}

}
