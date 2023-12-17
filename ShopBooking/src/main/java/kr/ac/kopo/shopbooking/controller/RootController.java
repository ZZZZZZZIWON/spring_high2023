package kr.ac.kopo.shopbooking.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ac.kopo.shopbooking.model.Member;
import kr.ac.kopo.shopbooking.service.MemberService;

@Controller
public class RootController {
	private static Logger logger = LoggerFactory.getLogger(RootController.class);
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/")
	String index() {
		logger.debug("Shop Booking");
		
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	String login() {
		return "login";
	}
	
	@PostMapping("/login")
	String login(Member item, HttpSession session) {
		if(memberService.login(item)) {
			session.setAttribute("member", item);
			
			if(item.getRole() == Member.ADMIN)
				return "redirect:/role/admin";
			else if(item.getRole() == Member.USER)
				return "redirect:/role/user";
			else if(item.getRole() == Member.SHOP)
				return "redirect:/role/shop";
		}
		
		return "redirect:/login";
	}
	
	@GetMapping("/logout")
	String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}

}
