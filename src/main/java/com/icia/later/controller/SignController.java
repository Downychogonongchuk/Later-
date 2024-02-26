package com.icia.later.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class SignController {
	@Autowired
	private MemberService mServ;
	

	// 회원가입 유형선택페이지
		@GetMapping("signSelect")
		public String signSelect() {
			log.info("signSelect()");
			
			return "signSelect";
		}
	
		
		// 회원정보 수정 처리
		@PostMapping("mUpdateProc")
		public String mUpdateProc(@RequestPart List<MultipartFile> files, 
				MemberDto member,
				HttpSession session,
				RedirectAttributes rttr) {
			log.info("updateProc()");
			System.out.println("mUpdate에서 넘어온 dto"+member);
			String view = mServ.memberUpdate(files, member, session, rttr);
			
			return view;
		}
		@GetMapping("mDelete")
		public String mDelete(Integer memberId,HttpSession session,RedirectAttributes rttr) {
			log.info("mDelete()");
			
			
			String view = mServ.mDelete(memberId,session,rttr);
			if (session != null && session.getAttribute("login") != null) {
		        // 탈퇴 후 세션에 저장되어있는 값 삭제
		        session.invalidate();
		    }

			return view;
		}
		
}
