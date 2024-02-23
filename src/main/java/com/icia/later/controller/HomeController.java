package com.icia.later.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.icia.later.dto.BoardDto;
import com.icia.later.dto.MemberDto;
import com.icia.later.service.BoardService;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class HomeController {
	@Autowired
	private BoardService bServ;
	
	//메인페이지
	@GetMapping("/")
	public String home(Model model, Model model1, HttpSession session) {
		log.info("home()");
		
		List<BoardDto> bList = bServ.getBoardList();
		
		MemberDto logInInfo = (MemberDto) session.getAttribute("login");
		
		// CustomerDto logInInfo1 = (CustomerDto) session.getAttribute("login");
	        // 로그인한 회원 정보를 모델에 추가하여 JSP로 전달
	    model.addAttribute("logInInfo", logInInfo);
		
	    model1.addAttribute("bList", bList);
		return "home";
	}
}