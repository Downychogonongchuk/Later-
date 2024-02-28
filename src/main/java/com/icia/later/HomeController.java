package com.icia.later;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@GetMapping("/detail1")
	public String detail1() { 	// 수정해야 함
		bServ.getCategory();	// 수정해야 함
		return "detail1";
	}

	@GetMapping("/detail2")
	public String detail2() {
		return "detail2";
	}

	@GetMapping("/detail3")
	public String detail3() {
		return "detail3";
	}

	@GetMapping("/detail4")
	public String detail4() {
		return "detail4";
	}

	@GetMapping("/detail5")
	public String detail5() {
		return "detail5";
	}

	@GetMapping("/detail6")
	public String detail6() {
		return "detail6";
	}

}