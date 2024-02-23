package com.icia.later.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.icia.later.dto.BoardDto;
import com.icia.later.service.BoardService;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class HomeController {
	@Autowired
	private BoardService bServ;
	
	//메인페이지
	@GetMapping("/")
	public String home(Model model) {
		log.info("home()");
		
		List<BoardDto> bList = bServ.getBoardList();
		
		model.addAttribute("bList", bList);
		
		return "home";
	}
}