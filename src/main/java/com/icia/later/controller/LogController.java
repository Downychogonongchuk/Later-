package com.icia.later.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LogController {
	
	@GetMapping("loginSelect")
	public String loginSelect() {
		log.info("loginSelect()");
		
		return "loginSelect";
	}
		
		// 일반회원 로그아웃 (2024-02-26) 
		@GetMapping("mLogout")
		public String mLogout(HttpServletRequest request, RedirectAttributes rttr) {
		    log.info("mLogout()");
		    String msg = null;

		    HttpSession session = request.getSession(false); // false 플래그는 새로운 세션이 생성되지 않도록 합니다.

		    if (session != null && session.getAttribute("mLogin") != null) {
		        // 세션이 비어있지 않을 때 로그아웃 처리
		        session.invalidate();
		        System.out.println(session);
		        msg = "로그아웃 되었습니다. 감사합니다.";
		        
		    } else {
		        // 이미 로그아웃 되어있거나 세션이 없는 경우
		    	System.out.println(session);
		    	msg = "이미 로그아웃 되어 있습니다.";
		        
		    }

		    rttr.addFlashAttribute("msg", msg);
		    return "redirect:/";
		}
		
		// 사업자 로그아웃 (2024-02-26) 
				@GetMapping("cLogout")
				public String cLogout(HttpServletRequest request, RedirectAttributes rttr) {
				    log.info("cLogout()");
				    String msg = null;

				    HttpSession session = request.getSession(false); // false 플래그는 새로운 세션이 생성되지 않도록 합니다.

				    if (session != null && session.getAttribute("cLogin") != null) {
				        // 세션이 비어있지 않을 때 로그아웃 처리
				        session.invalidate();
				        System.out.println(session);
				        msg = "로그아웃 되었습니다. 감사합니다.";
				        
				    } else {
				        // 이미 로그아웃 되어있거나 세션이 없는 경우
				    	System.out.println(session);
				    	msg = "이미 로그아웃 되어 있습니다.";
				        
				    }

				    rttr.addFlashAttribute("msg", msg);
				    return "redirect:/";
				}
}
