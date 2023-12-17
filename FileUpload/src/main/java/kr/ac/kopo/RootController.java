package kr.ac.kopo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class RootController {
	
	final String uploadPath = "d:/upload/";

	List<Image> list = new ArrayList<Image>();
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("list", list);
		return "index";
	}
	
	@PostMapping("/upload")
	String upload(Image image) {
		MultipartFile file = image.getUploadFile(); 

		if(file !=null && !file.isEmpty()) {
			String filename = file.getOriginalFilename();
			try {
				file.transferTo(new File(uploadPath + filename));
				
				image.setFilename(filename);
				
				list.add(image);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:."; // 이전 페이지로 redirect
	}
	
	@PostMapping("/upload/ajax")
	@ResponseBody
	String upload_ajax(Image image) {
		upload(image);
		
		return "OK";
	}
}
