package kr.ac.kopo.shopbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role/shop")
public class RoleShopController {
	final String path = "role/shop/";
	
	@GetMapping
	String index() {
		return path + "index";
	}
}
