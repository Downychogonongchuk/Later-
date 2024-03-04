package com.icia.later;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.icia.later.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CategoryController {
	@Autowired
	private BoardService bServ;

	@GetMapping("/category1")
	public String home(Integer pageNum,
						Model model, 
						HttpSession session) {
		log.info("home()");
		
//		String view = bServ.getCategoryList(pageNum, model, session);
		
		return "category1";
				
	}
}
