package com.icia.later;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.icia.later.service.BoardService;
import com.icia.later.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	@Autowired
	private MemberService mServ;
	@Autowired
	private BoardService bServ;

	//����������
			@GetMapping("/")
			public String home() {
				log.info("home()");

				return "home";
			}
			
		// ���������� Ȩ �̵�
			@GetMapping("myPage")
			public String myPage(Model model,HttpSession session) {
				log.info("myPage()");
				
				MemberDto logInInfo = (MemberDto) session.getAttribute("login");
				
				if (logInInfo != null && session.getAttribute("login") != null) {
			        // �α����� ȸ�� ������ �𵨿� �߰��Ͽ� JSP�� ����
			        model.addAttribute("logInInfo", logInInfo);
			        System.out.println(logInInfo);
				}
				return "myPage";
			}
		
		
		// ȸ������ ��������������
		@GetMapping("signSelect")
		public String signSelect() {
			log.info("signSelect()");
			
			return "signSelect";
		}
		
		// �Ϲ�ȸ�� ���������� �̵�
		@GetMapping("mSignIn")
		public String mSignIn() {
			log.info("mSignIn()");
			
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
		
		// �α��μ��� ������ �̵�
		@GetMapping("loginSelect")
		public String loginSelect() {
			log.info("login()");

			return "loginSelect";
		}
		
		//�Ϲ� �α��� ������
		@GetMapping("mLogin")
		public String mLogin() {
			log.info("mLogin()");

			return "mLogin";
		}
		
		
		// �Ϲ�ȸ�� �α��� ó�� �޼���
		@PostMapping("mLoginProc")
		public String mLoginProc(MemberDto member,
								HttpSession session,
								RedirectAttributes rttr) {
			log.info("mLoginProc()");
			System.out.println(member);
			
			String view = mServ.mLogin(member, session, rttr);
			return view;
		}
		// �α׾ƿ� 
		@GetMapping("logout")
		public String logout(HttpServletRequest request, RedirectAttributes rttr) {
		    log.info("logout()");
		    String msg = null;

		    HttpSession session = request.getSession(false); // false �÷��״� ���ο� ������ �������� �ʵ��� �մϴ�.

		    if (session != null && session.getAttribute("login") != null) {
		        // ������ ������� ���� �� �α׾ƿ� ó��
		        session.invalidate();
		        System.out.println(session);
		        msg = "�α׾ƿ� �Ǿ����ϴ�. �����մϴ�.";
		        
		    } else {
		        // �̹� �α׾ƿ� �Ǿ��ְų� ������ ���� ���
		    	System.out.println(session);
		    	msg = "�̹� �α׾ƿ� �Ǿ� �ֽ��ϴ�.";
		        
		    }

		    rttr.addFlashAttribute("msg", msg);
		    return "redirect:/";
		}
		
		
		// �Ϲ�ȸ������ ���������� �̵�
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
		
		// �Ϲ�ȸ������ ���� ó��
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