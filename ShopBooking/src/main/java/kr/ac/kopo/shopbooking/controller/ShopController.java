package kr.ac.kopo.shopbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.shopbooking.model.Shop;
import kr.ac.kopo.shopbooking.service.ShopService;


@Controller
@RequestMapping("/shop")
public class ShopController {
	final String path = "shop/";
	
	@Autowired
	ShopService service;
	
	@GetMapping("/list")
	String list(Model model) {
		List<Shop> list = service.list();
		
		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	@GetMapping("/add")
	String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	String add(Shop item) {
		service.add(item);
		
		return "redirect:list";
	}
	
	@GetMapping("/update/{tableId}")
	String update(@PathVariable Long tableId, Model model) {
		Shop item = service.item(tableId);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	@PostMapping("/update/{tableId}")
	String update(@PathVariable Long tableId, Shop item) {
		item.setTableId(tableId);
		
		service.update(item);
		
		return "redirect:../list";
	}
	
	@GetMapping("/delete/{tableId}")
	String delete(@PathVariable Long tableId) {
		service.delete(tableId);
		
		return "redirect:../list";
	}

}
