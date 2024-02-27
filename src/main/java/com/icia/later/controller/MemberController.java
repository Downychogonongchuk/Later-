package com.icia.later.controller;

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
public class MemberController {
	@Autowired
	private MemberService mServ;
	
	// �α��������� �̵�
			@GetMapping("mLogin")
			public String mLogin() {
				log.info("mLogin()");
				
				return "mLogin";
			}
			
			// �α��� ó�� �޼���
			@PostMapping("loginCheck")
			public String loginCheck(MemberDto member,
									HttpSession session,
									RedirectAttributes rttr) {
				log.info("loginCheck()");
				System.out.println(member);
				
				String view = mServ.login(member, session, rttr);
				return view;
			}
	
	// ȸ������ ���������� �̵�
			@GetMapping("mUpdate")
			public String mUpdate(Model model,HttpSession session) {
				log.info("mUpdate()");
				
				MemberDto logInInfo = (MemberDto) session.getAttribute("login");
				
				if (logInInfo != null && session.getAttribute("login") != null) {
			        // �α����� ȸ�� ������ �𵨿� �߰��Ͽ� JSP�� ����
			        model.addAttribute("logInInfo", logInInfo);
			        	        	        	        
			}
				return "mUpdate";
		}
			
			// ȸ������ ���� ó��
			@PostMapping("mUpdateProc")
			public String mUpdateProc(@RequestPart List<MultipartFile> files, 
					MemberDto member,
					HttpSession session,
					RedirectAttributes rttr) {
				log.info("updateProc()");
				System.out.println("mUpdate���� �Ѿ�� dto"+member);
				String view = mServ.memberUpdate(files, member, session, rttr);
				
				return view;
			}
		
			// ȸ������������ �̵�
			@GetMapping("mSignIn")
			public String mSigIn() {
				log.info("mSigIn()");
				
				return "mSignIn";
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
		
		// �Ϲ�ȸ�� Ż��
		@GetMapping("mDelete")
		public String mDelete(Integer memberId,HttpSession session,RedirectAttributes rttr) {
			log.info("mDelete()");
			
			
			String view = mServ.mDelete(memberId,session,rttr);
			if (session != null && session.getAttribute("login") != null) {
		        // Ż�� �� ���ǿ� ����Ǿ��ִ� �� ����
		        session.invalidate();
		    }

			return view;
		}
		
}
