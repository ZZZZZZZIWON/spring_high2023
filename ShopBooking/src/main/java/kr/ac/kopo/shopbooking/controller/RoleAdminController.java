package kr.ac.kopo.shopbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role/admin")
public class RoleAdminController {
	final String path = "role/admin/";
	
	@GetMapping
	String index() {
		return path + "index";
	}
}
