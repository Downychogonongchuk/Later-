package com.icia.later;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("loginPage")
	public String loginPage() {
		log.info("loginPage()");
		return "loginPage";
	}
	
	@GetMapping("registerPage")
	public String registerPage() {
		log.info("registerPage()");
		return "registerPage";
	}
}
