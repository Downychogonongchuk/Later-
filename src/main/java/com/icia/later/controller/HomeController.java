package com.icia.later.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class HomeController {
	
	
	//����������
	@GetMapping("/")
	public String home() {
		log.info("home()");
		return "home";
	}
}