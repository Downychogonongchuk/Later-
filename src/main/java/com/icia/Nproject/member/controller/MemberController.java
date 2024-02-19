package com.icia.Nproject.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	@RequestMapping("/")
	public String loginPage() {
		return "login/loginPage";
	}

//	@RequestMapping("member/loginPage")
//	public String loginPage() {
//		return "member/loginPage";
//	}

	@RequestMapping("registerPage")
	public String registerPage() {
		return "login/registerPage";
	}
}
