package com.kjcspring.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kjcspring.dao.*;
import com.kjcspring.model.*;

public class loginApiController {

	@Autowired
	MemberInfoDAO memberInfoDAO;
	
	@PostMapping("/loginCheck")
	public ResponseEntity<String> loginCheck(HttpServletRequest request,@RequestParam(value="memberEmail") String memberEmail, MemberInfo memberInfo) {
		
		System.out.println("memberInfo : " + memberInfo.toString());
		System.out.println(memberEmail);
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