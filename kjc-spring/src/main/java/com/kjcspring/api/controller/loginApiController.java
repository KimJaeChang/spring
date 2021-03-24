package com.kjcspring.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kjcspring.controller.homeController;
import com.kjcspring.dao.*;
import com.kjcspring.model.*;

@Controller
public class loginApiController {

	@Autowired
	MemberInfoDAO memberInfoDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(homeController.class);
	
	@PostMapping("/loginCheck")
	public ResponseEntity<String> loginCheck(HttpServletRequest request, MemberInfo memberInfo) {
		
		HttpSession session = request.getSession();
		MemberInfo member = memberInfoDAO.selectMemberInfo(memberInfo);
		
		if(member!=null) {
			String resultString = member.getMemberName();  
			session.setAttribute("member", member);
			
			return new ResponseEntity<>(resultString, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
}
