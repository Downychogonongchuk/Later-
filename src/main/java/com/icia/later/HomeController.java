package com.icia.later;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.icia.later.service.BoardService;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class HomeController {
	@Autowired
	private BoardService bServ;
	
	@GetMapping("/")
	public String home() {

		return "home";
	}
	
	@GetMapping("companyDetail")
	public String detail(Integer boardId, Model model) {
		log.info("companyDetail()");
		boardId = 11;
		bServ.getCompanyDetail(boardId, model);
		System.out.println(model);
//		model.addAttribute(model);
		
		return "companyDetail";
	}
	
	
		
}