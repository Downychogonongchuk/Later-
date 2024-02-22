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
public class MemberController {
	@Autowired
	private MemberService mServ;
	
		//ȸ������ ���� ������ �̵�
		@GetMapping("mUpdate")
		public String mUpdate() {
			log.info("mUpdate");
			
			return("mUpdate");
		}
		
		// ȸ������ ó�� �޼���
		@PostMapping("mSignInProc")
		public String mSignInProc(@RequestPart List<MultipartFile> files, 
				MemberDto member,
				HttpSession session,
				RedirectAttributes rttr) {
			log.info("mSignInProc()");
					
			String view = mServ.insertMember(files, member, session, rttr);
			return view;
			}
		
}
