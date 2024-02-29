package com.icia.later;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.icia.later.dto.CustomerDto;
import com.icia.later.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CustomerController {
		@Autowired CustomerService cServ;
	
		
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
	
	@PostMapping("cEmailCheck")
	@ResponseBody
	public String cEmailCheck(String customerEmailCheck) {
	log.info("cEmailCheck()" + customerEmailCheck);
	String res = cServ.cEmailCheck(customerEmailCheck); 
	
		return res;
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
		
		//�����ȸ�� ���̵�ã��
				@GetMapping("cFindById")
				public String cFindById() {
					log.info("cFindById()");
					
					return "cFindById";
				}
				
				//����� ���̵�ã�� ó��
				@PostMapping("cFindByIdProc")
				public String cFindByIdProc(CustomerDto customer, Model model, RedirectAttributes rttr) {
					log.info("cFindById()");
					String view = cServ.cFindById(customer, model, rttr);

					return view;
				}
		
				//�����ȸ�� ���ã��
				@GetMapping("cFindByPass")
				public String cFindByPass() {
					log.info("cFindByPass()");
					
					return "cFindByPass";
				}
				
				//�����ȸ�� ��й�ȣã�� �������� Ȯ�� �޼���
				@PostMapping("cFindByPassProc")
				public String cFindByPassProc(CustomerDto customer,
												Model model,
												RedirectAttributes rttr) {
					log.info("cFindByPassProc()");
					String view = cServ.cFindByPass(customer,model,rttr);
					
					return view;
				}
				
				//��й�ȣ ã�� -> ��й�ȣ ����������
				@PostMapping("cPassUpdate")
				public String cPassUpdate() {
					log.info("cPassUpdate()");
					
					return "cPassUpdate";
				}
				
				//��й�ȣ ���� ó�� �޼���
				@PostMapping("cUpdatePassProc")
				public String cUpdatePassProc(CustomerDto customer,
											RedirectAttributes rttr) {
					log.info("cUpdatePassProc()");
					
					String view = cServ.cUpdatePassProc(customer,rttr);
					return view;
				}
		
	// ����� ȸ������ ���������� �̵�
		@GetMapping("cUpdate")
		public String cUpdate(Model model,HttpSession session) {
			log.info("cUpdate()");
			
			CustomerDto logInInfo = (CustomerDto) session.getAttribute("cLogin");
			
			
			if (logInInfo != null && session.getAttribute("cLogin") != null) {
		        // �α����� ȸ�� ������ �𵨿� �߰��Ͽ� JSP�� ����
		        model.addAttribute("cLogInInfo", logInInfo);
		        	        	        	        
		}
			return "cUpdate";
	}
		
	// ����� ȸ������ ���� ó��
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
		
	// ����� ȸ�� ���� Ż��
		// �Ϲ�ȸ�� Ż��
		@GetMapping("cDelete")
		public String cDelete(Integer customerId,HttpSession session,RedirectAttributes rttr) {
			log.info("cDelete()");
			
			
			String view = cServ.cDelete(customerId,session,rttr);
			if (session != null && session.getAttribute("cLogin") != null) {
		        // Ż�� �� ���ǿ� ����Ǿ��ִ� �� ����
		        session.invalidate();
		    }

			return view;
		}
		
		
}