package com.icia.later.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dto.MemberDto;
import com.icia.later.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LogController {
	@Autowired
	private MemberService mServ;
	
	// 로그인페이지 이동
		@GetMapping("loginPage")
		public String loginPage() {
			log.info("loginPage()");
			
			return "loginPage";
		}
		
		// 로그인 처리 메서드
		@PostMapping("loginCheck")
		public String loginCheck(MemberDto member,
								HttpSession session,
								RedirectAttributes rttr) {
			log.info("loginCheck()");
			System.out.println(member);
			
			String view = mServ.login(member, session, rttr);
			return view;
		}
		
		// 로그아웃 
		@GetMapping("logout")
		public String logout(HttpServletRequest request, RedirectAttributes rttr) {
		    log.info("logout()");
		    String msg = null;

		    HttpSession session = request.getSession(false); // false 플래그는 새로운 세션이 생성되지 않도록 합니다.

		    if (session != null && session.getAttribute("login") != null) {
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
