package com.example.demo.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DAO.CustomerDAO;
import com.example.demo.DAO.Feedback_DAO;
import com.example.demo.DAO.UserDAO;
import com.example.demo.models.Customer;
import com.example.demo.models.Feedback;
import com.example.demo.models.User;
import com.example.demo.service.SecurityService;
import com.example.demo.service.UserService;

@Controller

public class HomeController {
	
	@Autowired
	private CustomerDAO customerdao;
	@Autowired
	private UserService userservice;
	
	@Autowired
	private SecurityService securityService;
	@Autowired 
	private Feedback_DAO feedbackdao;
	
	
	@RequestMapping("/")
	public String home(Model m) {

		   List<Feedback> feeds = feedbackdao.getallfeddbacks();

		   m.addAttribute("feedbacks",feeds);
		return "home";
	}
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(Model model,HttpSession session) {
		
		Customer user=new Customer();
		model.addAttribute("User", user);
		model.addAttribute("d","d");
		String s="hello";
		session.setAttribute("d", s);
		
		
		return "register";
	}
	
	
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String postregister(@ModelAttribute("User") Customer cust,
            Model model,HttpSession session) {
		
		System.out.println(session.getAttribute("d"));
		User user = new User();
		System.out.println(cust.getDOB());
		
		try {
		
			
			user.setUsername(cust.getCust_ID());
			user.setRole("customer");
			user.setPassword(cust.getPassword());
			
			
			userservice.save(user);

			
		customerdao.save(cust);

	   
	    
		}
		catch(Exception e) {
			model.addAttribute("message","Username already exists");
			return "register";
			
			
		}
	    securityService.autoLogin(user.getUsername(), user.getPassword());
		 return "redirect:/customer";
		
	}
	 @RequestMapping("/welcome")
	    public String welcome(Principal principal) {
	        User user = userservice.findByUsername(principal.getName());
	        if (user.getRole().equals("admin"))
	            return "redirect:/admin/";
	        else if(user.getRole().equals("employee"))
	            return "redirect:/employee/";
	        else 
	            return "redirect:/customer/";
	    }

}
