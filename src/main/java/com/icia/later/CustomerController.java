package com.icia.later;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CustomerController {
	
	@GetMapping("cSignIn")
	public String cSignIn() {
		log.info("cSignIn()");
		
		return "cSignIn";
	}
		
		
}
