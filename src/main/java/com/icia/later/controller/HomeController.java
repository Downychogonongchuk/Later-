package com.icia.later.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.icia.later.dto.BoardDto;
import com.icia.later.dto.CustomerDto;
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
	public String home(Model model, HttpSession session) {
		log.info("home()");
		
		List<BoardDto> bList = bServ.getBoardList();
		// 로그인한 일반 회원 정보(2024-02-26)
		MemberDto mLogInInfo = (MemberDto) session.getAttribute("mLogin");
		// 로그인한 사업자 회원 정보(2024-02-26)
		CustomerDto cLogInInfo = (CustomerDto) session.getAttribute("cLogin");
	    // 로그인한 회원 정보를 모델에 추가하여 JSP로 전달
	    model.addAttribute("mLogInInfo", mLogInInfo);
	    // 로그인한 사업자 정보를 모델에 추가하여 JSP로 전달
	    model.addAttribute("cLogInInfo", cLogInInfo);
	    
	    model.addAttribute("bList", bList);
		return "home";
	}
	
	//마이페이지 이동
	@GetMapping("myPage")
	public String myPage(Model model, HttpSession session) {
		log.info("myPage()");
		
		// 로그인한 일반 회원 정보(2024-02-26)
		MemberDto mLogInInfo = (MemberDto) session.getAttribute("mLogin");
		// 로그인한 사업자 회원 정보(2024-02-26)
		CustomerDto cLogInInfo = (CustomerDto) session.getAttribute("cLogin");
		// 로그인한 회원 정보를 모델에 추가하여 JSP로 전달
		model.addAttribute("mLogInInfo", mLogInInfo);
		// 로그인한 사업자 정보를 모델에 추가하여 JSP로 전달
		model.addAttribute("cLogInInfo", cLogInInfo);
			    
	    return "myPage";
	}
}