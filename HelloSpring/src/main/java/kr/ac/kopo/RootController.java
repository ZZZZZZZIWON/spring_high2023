package kr.ac.kopo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RootController {

	@GetMapping("/")
	String index() {
		return "index";
	}
	
	@GetMapping("/calc")
	String calc() {
		return "calc";
	}
	
	@PostMapping("/calc")
	String calc(int left, String op, int right, Model model) {
		int result = 0;
		
		
		if("pls".equals(op)) 
			result = left + right;
		else if("min".equals(op)) 
			result = left - right;		
		else if("mul".equals(op)) 
			result = left * right;
		else if("div".equals(op)) 
			result = left / right;

		model.addAttribute("left", left);
		model.addAttribute("op", op);
		model.addAttribute("right", right);
		model.addAttribute("result", result);
		
		return "result";
	}
}
