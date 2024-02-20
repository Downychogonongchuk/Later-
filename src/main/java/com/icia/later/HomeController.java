package com.icia.later;

import java.io.Console;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dto.MemberDto;
import com.icia.later.service.MemberService;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class HomeController {
	@Autowired
	private MemberService mServ;
			
	
	@GetMapping("/")
	public String home() {

		return "home";
	}
	
	//모집등록페이지 전환
	@GetMapping("writeFrm")
	public String writeFrm() {
		log.info("writeFrm()");
			
		return "writeFrm";
	}
		
	// 회원가입페이지 이동
	@GetMapping("mSignIn")
	public String mSignIn() {
		log.info("mSignIn()");
		
		return "mSignIn";
	}
	// 회원가입 처리 메서드
	@PostMapping("mSignInProc")
	public String mSignInProc(@RequestPart List<MultipartFile> files, 
			MemberDto member,
			HttpSession session,
			RedirectAttributes rttr) {
		log.info("mSignInProc()");
				
		String view = mServ.insertMember(files, member, session, rttr);
		System.out.println(member);
		return view;
		}
	
	// 로그인페이지 이동
	@GetMapping("login")
	public String login() {
		log.info("login()");

		return "login";
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
	public String logout(HttpSession session, RedirectAttributes rttr) {
	    log.info("logout()");
	    String msg = "로그아웃 되었습니다 감사합니다.";
	    // 세션에서 "login" 속성만을 제거
	    session.removeAttribute("login");
	    
	    rttr.addFlashAttribute("msg",msg);
	    return "redirect:/";
	}
	
	
	// 회원정보 수정페이지 이동
	@GetMapping("mUpdate")
	public String mUpdate(Model model,HttpSession session) {
		log.info("mUpdate()");
		
		MemberDto logInInfo = (MemberDto) session.getAttribute("login");
		
		if (logInInfo != null) {
	        // 로그인한 회원 정보를 모델에 추가하여 JSP로 전달
	        model.addAttribute("logInInfo", logInInfo);
	        System.out.println(model);
	        	        
	}
		return "mUpdate";
}
	@PostMapping("mUpdateProc")
	public String mUpdateProc() {
		log.info("mUpdateProc()");
		
		
		
		return "view";
	}
	
	
	}
