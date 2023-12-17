package kr.ac.kopo.shopbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.shopbooking.model.Booking;
import kr.ac.kopo.shopbooking.pager.Pager;
import kr.ac.kopo.shopbooking.service.BookingService;

@Controller
@RequestMapping("/booking")
public class BookingController {
	final String path = "booking/";
	
	@Autowired
	BookingService service;
	
	@GetMapping("/list")
	String list(Pager pager, Model model) {
		List<Booking> list = service.list(pager);
		
		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	//예약
	@GetMapping("/update/{bookingId}")
	String update(@PathVariable Long bookingId, Model model) {
		Booking item = service.item(bookingId);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	//예약취소
	@GetMapping("/delete/{bookingId}")
	String delete(@PathVariable Long bookingId) {
		service.delete(bookingId);
		
		return "redirect:../list";
	}

}
