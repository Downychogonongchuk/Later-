package com.icia.later.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SignController {
	

	// ȸ������ ��������������
		@GetMapping("signSelect")
		public String signSelect() {
			log.info("signSelect()");
			
			return "signSelect";
		}
	
	
		
}
