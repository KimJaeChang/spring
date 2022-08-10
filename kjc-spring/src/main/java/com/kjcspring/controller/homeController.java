package com.kjcspring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kjcspring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {
	
	@Autowired
	private KjcService kjcService;

//	private static final Logger logger = LoggerFactory.getLogger(homeController.class);
	
	@GetMapping("/")
	public String login() {
		
		return "login";
	}
	
	@GetMapping("/home")
	public String home(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		if(session!=null) {
			
			return "home";
		}
		
		return "login";
	}
	
	@GetMapping("/bookList")
	public String bookList() {
		
		return "bookList";
	}
	
}
