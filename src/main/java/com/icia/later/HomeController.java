package com.icia.later;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {
	@Autowired

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/detail1")
	public String detail1() {
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