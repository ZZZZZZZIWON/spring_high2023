package kr.ac.kopo.shopbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.shopbooking.model.TimeTable;
import kr.ac.kopo.shopbooking.service.TimeTableService;

@Controller
@RequestMapping("/time_table")
public class TimeTableController {
	final String path = "time_table/";
	
	@Autowired
	TimeTableService service;
	
	@GetMapping("/list")
	String list(Model model) {
		List<TimeTable> list = service.list();
		
		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	@GetMapping("/add")
	String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	String add(TimeTable item) {
		service.add(item);
		
		return "redirect:list";
	}
	
	@GetMapping("/update/{timeId}")
	String update(@PathVariable Long timeId, Model model) {
		TimeTable item = service.item(timeId);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	@PostMapping("/update/{timeId}")
	String update(@PathVariable Long timeId, TimeTable item) {
		item.setTimeId(timeId);
		
		service.update(item);
		
		return "redirect:../list";
	}
	
	@GetMapping("/delete/{timeId}")
	String delete(@PathVariable Long timeId) {
		service.delete(timeId);
		
		return "redirect:../list";
	}

}
