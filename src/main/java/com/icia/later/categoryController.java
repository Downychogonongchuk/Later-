package com.icia.later;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class categoryController {
	
	// 각 카테고리 클릭시 매핑
	@GetMapping("foodHome")
	public String foodHome() {
		
		return "foodHome";
	}
	
	@GetMapping("dormitoryHome")
	public String dormitoryHome() {
		
		return "dormitoryHome";
	}
	
	@GetMapping("appliancesHome")
	public String appliancesHome() {
		
		return "appliancesHome";
		
	}
	@GetMapping("BeautyHome")
	public String BeautyHome() {
		
		return "BeautyHome";
		
	}
	@GetMapping("etcHome")
	public String etcHome() {
		
		return "etcHome";
	}
	
	
}
