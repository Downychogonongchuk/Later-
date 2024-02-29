package com.icia.later.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SignController {
	

	// 회원가입 유형선택페이지
		@GetMapping("signSelect")
		public String signSelect() {
			log.info("signSelect()");
			
			return "signSelect";
		}
	
	
		
}
