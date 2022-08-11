package com.kjcspring.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kjcspring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.kjcspring.model.*;

@Controller
public class loginApiController {

	@Autowired
	private MemberInfoService memberInfoService;
	
//	private static final Logger logger = LoggerFactory.getLogger(homeController.class);

	/**
	 * @param request
	 * @param memberInfo
	 * 회원 여부 체크
	 * @return member
	 */
	@PostMapping("/loginCheck")
	public ResponseEntity<String> loginCheck(HttpServletRequest request, MemberInfo memberInfo) {
		
		HttpSession session = request.getSession();
		MemberInfo member = memberInfoService.selectMemberInfo(memberInfo);

		if(member!=null) {
			String resultString = member.getMemberName();  
			session.setAttribute("member", member);
			
			return new ResponseEntity<>(resultString, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
}
