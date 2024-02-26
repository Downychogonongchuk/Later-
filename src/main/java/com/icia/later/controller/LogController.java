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
		
		// �Ϲ�ȸ�� �α׾ƿ� (2024-02-26) 
		@GetMapping("mLogout")
		public String mLogout(HttpServletRequest request, RedirectAttributes rttr) {
		    log.info("mLogout()");
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
		
		// ����� �α׾ƿ� (2024-02-26) 
				@GetMapping("cLogout")
				public String cLogout(HttpServletRequest request, RedirectAttributes rttr) {
				    log.info("cLogout()");
				    String msg = null;

				    HttpSession session = request.getSession(false); // false �÷��״� ���ο� ������ �������� �ʵ��� �մϴ�.

				    if (session != null && session.getAttribute("cLogin") != null) {
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
}
