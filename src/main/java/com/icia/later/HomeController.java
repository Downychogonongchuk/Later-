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
public class HomeController {
	@Autowired
	private BoardService bServ;

	@GetMapping("/")
	public String home(Integer pageNum,
						Model model, 
						HttpSession session) {
		log.info("home()");
		
		String view = bServ.getBoardListBycustomerId(pageNum, model, session);
		
		return view;
				
	}

	@GetMapping("/detail1")
	public String detail1(Integer pageNum, Model model) { 	
		log.info("detail1()");
		bServ.getCategory();	
		return "detail1";	// jsp파일명
	}

	@GetMapping("/detail2")
	public String detail2(Integer pageNum, Model model) {
		log.info("detail2()");
		bServ.getCategory();	
		return "detail2";
	}

	@GetMapping("/detail3")
	public String detail3(Integer pageNum, Model model) { 	
		log.info("detail3()");
		bServ.getCategory();	
		return "detail3";
	}

	@GetMapping("/detail4")
	public String detail4(Integer pageNum, Model model) { 
		log.info("detail4()");
		bServ.getCategory();	
		return "detail4";
	}

	@GetMapping("/detail5")
	public String detail5(Integer pageNum, Model model) { 	
		log.info("detail5()");
		bServ.getCategory();	
		return "detail5";
	}

	@GetMapping("/detail6")
	public String detail6(Integer pageNum, Model model) { 
		log.info("detail6()");
		bServ.getCategory();	
		return "detail6";
	}

}