package kr.co.twocamp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.twocamp.admin.AdminBean;
import kr.co.twocamp.admin.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	// 화원가입화면
	@RequestMapping(value = "adminSign", method = RequestMethod.GET)
	public String Singup() {
		return "adminSign";
	}

	// 회원가입실행
	@RequestMapping(value = "adminSign", method = RequestMethod.POST)
	public String Singup(AdminBean adminBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		adminService.signup(adminBean);

		return "home";
	}

	// 로그인화면
	@RequestMapping(value = "adminLogin", method = RequestMethod.GET)
	public String Login() {
		return "aLoginForm";
	}

	// 로그인실행
	@RequestMapping(value = "adminLogin", method = RequestMethod.POST)
	public String Login(@RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws Exception {
		request.setCharacterEncoding("utf-8");
		logger.info("==============login Controller ==============");
		Map id = adminService.login(map);
		if (id == null) { // 관리자가 아닙니다
			logger.info("로그인안됨");
			return "redirect:adminForm";
		} else {
			session.setAttribute("id", id);
			System.out.println("로그인됨");
			
			return "redirect:/"; // 첫 페이지로 이동하세요
		}
	}
	
	@GetMapping("/adminLogout")
	public String adminLogout(HttpSession session) {
		session.invalidate();
		
		System.out.println("로그아웃됨");
		return "redirect:/";
	}
	
	//카카오로그인화면 
	@GetMapping("/kakaoLoginForm")
    public String kakaoLoginForm() {  
        return "kakaoLogin";
    }
	
	//카카오로그인
	@RequestMapping(value="/kakaoLogin")
    public String kakaoLogin(@RequestParam("code") String code, HttpSession session) {
		//System.out.println("code : " + code);
		String access_Token = adminService.getAccessToken(code);
        System.out.println("controller access_token : " + access_Token);

		
		HashMap<String, Object> userInfo = adminService.getUserInfo(access_Token);
	    System.out.println("login Controller : " + userInfo);
	    
	    System.out.println(userInfo.get("email"));
	    //    클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
	    if (userInfo.get("email") != null) {
	    	session.setAttribute("userId", userInfo); //email = >userinfo
	    	session.setAttribute("access_Token", access_Token);
	    }
        
        return "home";
    }
	
	@RequestMapping(value="/adminLogout")
	public String logout(HttpSession session) {
		adminService.kakaoLogout((String)session.getAttribute("access_Token"));
	    session.removeAttribute("access_Token");
	    session.removeAttribute("userId");
	    return "home";
	}
	
	@GetMapping(value="admin/home")
	public String adminHome() {
		return "admin/home";
	}
	
	
	@GetMapping(value="admin/memberTable")
	public String memberTable() {
		System.out.println("testesttest11");
		return "admin/memberTable";
	}

}









