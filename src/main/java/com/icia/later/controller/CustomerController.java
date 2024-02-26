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

import com.icia.later.dto.CustomerDto;
import com.icia.later.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CustomerController {
	@Autowired 
	private CustomerService cServ;
	
	
	@GetMapping("cSignIn")
	public String cSignIn() {
		log.info("cSignIn()");
		
		return "cSignIn";
	}
	
	@PostMapping("cSignInProc")
	public String cSignInProc(@RequestPart List<MultipartFile> files, 
			CustomerDto customer,
			HttpSession session,
			RedirectAttributes rttr) {
		log.info("cSignInProc()");
				
		String view = cServ.insertCustomer(files, customer, session, rttr);
		
		return view;
	}
	
	//����� �α��� ������
		@GetMapping("cLogin")
		public String cLogin() {
			log.info("cLogin()");

			return "cLogin";
		}
	
	// �α��� ó�� �޼���
		@PostMapping("cLoginProc")
		public String cLoginProc(CustomerDto customer,
								HttpSession session,
								RedirectAttributes rttr) {
			log.info("cLoginProc()");
			System.out.println(customer);
			
			String view = cServ.cLogin(customer, session, rttr);
			return view;
		}
		
	// ����� ȸ������ ���������� �̵�
		@GetMapping("cUpdate")
		public String cUpdate(Model model,HttpSession session) {
			log.info("cUpdate()");
			
			CustomerDto logInInfo = (CustomerDto) session.getAttribute("login");
			
			if (logInInfo != null && session.getAttribute("login") != null) {
		        // �α����� ȸ�� ������ �𵨿� �߰��Ͽ� JSP�� ����
		        model.addAttribute("logInInfo", logInInfo);
		        	        	        	        
		}
			return "cUpdate";
	}
		
	// �Ϲ�ȸ������ ���� ó��
		@PostMapping("cUpdateProc")
		public String cUpdateProc(@RequestPart List<MultipartFile> files, 
				CustomerDto customer,
				HttpSession session,
				RedirectAttributes rttr) {
			log.info("cUpdateProc()");
			System.out.println("cUpdate���� �Ѿ�� dto"+customer);
			String view = cServ.customerUpdate(files, customer, session, rttr);
			
			return view;
		}
	
}
