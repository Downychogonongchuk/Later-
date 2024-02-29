package com.icia.later;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dto.CustomerDto;
import com.icia.later.dto.MemberDto;
import com.icia.later.service.MemberService;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class HomeController {
	@Autowired
	private MemberService mServ;
			
	//����������
		@GetMapping("/")
		public String home(Model model,HttpSession session) {
			log.info("home()");

			MemberDto logInInfo = (MemberDto) session.getAttribute("mLogin");
			
			if (logInInfo != null && session.getAttribute("mLogin") != null) {
		        // �α����� ȸ�� ������ �𵨿� �߰��Ͽ� JSP�� ����
		        model.addAttribute("mLogInInfo", logInInfo);
		        System.out.println(logInInfo);
			}
			
			CustomerDto logInInfo1 = (CustomerDto) session.getAttribute("cLogin");
			
			
			if (logInInfo1 != null && session.getAttribute("cLogin") != null) {
		        // �α����� ȸ�� ������ �𵨿� �߰��Ͽ� JSP�� ����
		        model.addAttribute("cLogInInfo", logInInfo1);
		        	        	        	        
		}
			return "home";
		}
		
	// ���������� Ȩ �̵�
		@GetMapping("myPage")
		public String myPage(Model model,HttpSession session) {
			log.info("myPage()");
			
			MemberDto logInInfo = (MemberDto) session.getAttribute("mLogin");
			
			if (logInInfo != null && session.getAttribute("mLogin") != null) {
		        // �α����� ȸ�� ������ �𵨿� �߰��Ͽ� JSP�� ����
		        model.addAttribute("mLogInInfo", logInInfo);
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
	
	// �Ϲ�ȸ�� �̸��� �ߺ�üũ
	@PostMapping("mEmailCheck")
	@ResponseBody
	public String mEmailCheck(String memberEmailCheck) {
	log.info("mEmailCheck()" + memberEmailCheck);
	String res = mServ.mEmailCheck(memberEmailCheck); 
	
		return res;
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
	
	//�Ϲ�ȸ�� ���̵�ã��
	@GetMapping("mFindById")
	public String mFindById() {
		log.info("mFindById()");
		
		return "mFindById";
	}
	
	//�Ϲ�ȸ�� ���̵�ã�� ó�� �޼���
	@PostMapping("mFindByIdProc")
	public String mFindByIdProc(MemberDto member,
								Model model,
								RedirectAttributes rttr) {
		log.info("mFindById()");
		String view = mServ.mFindById(member,model,rttr);
		
		return view;
	}
	
	//�Ϲ�ȸ�� ���ã�� ������
		@GetMapping("mFindByPass")
		public String mFindByPass() {
			log.info("mFindByPass()");
			
			return "mFindByPass";
		}
		
		//�Ϲ�ȸ�� ��й�ȣã�� �������� Ȯ�� �޼���
		@PostMapping("mFindByPassProc")
		public String mFindByPassProc(MemberDto member,
										Model model,
										RedirectAttributes rttr) {
			log.info("mFindByPassProc()");
			String view = mServ.mFindByPass(member,model,rttr);
			
			return view;
		}
		
		//��й�ȣ ã�� -> ��й�ȣ ����������
		@PostMapping("mPassUpdate")
		public String mPassUpdate() {
			log.info("mPassUpdate1()");
			
			return "mPassUpdate";
		}
		
		//��й�ȣ ���� ó�� �޼���
		@PostMapping("mUpdatePassProc")
		public String mUpdatePassProc(MemberDto member,
									RedirectAttributes rttr) {
			log.info("mUpdatePassProc1()");
			
			String view = mServ.mUpdatePassProc(member,rttr);
			return view;
		}

	// �α׾ƿ� 
	@GetMapping("logout")
	public String logout(HttpServletRequest request, RedirectAttributes rttr) {
	    log.info("logout()");
	    String msg = null;

	    HttpSession session = request.getSession(false); // false �÷��״� ���ο� ������ �������� �ʵ��� �մϴ�.

	    if (session != null && session.getAttribute("mLogin") != null) {
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
		
		MemberDto logInInfo = (MemberDto) session.getAttribute("mLogin");
		
		if (logInInfo != null && session.getAttribute("mLogin") != null) {
	        // �α����� ȸ�� ������ �𵨿� �߰��Ͽ� JSP�� ����
	        model.addAttribute("mLogInInfo", logInInfo);
	        	        	        	        
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
		if (session != null && session.getAttribute("mLogin") != null) {
	        // Ż�� �� ���ǿ� ����Ǿ��ִ� �� ����
	        session.invalidate();
	    }

		return view;
	}
	
}