package com.icia.later.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dao.CustomerDao;
import com.icia.later.dto.CustomerDto;
import com.icia.later.dto.MemberDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {
	@Autowired CustomerDao cDao;
	
	public String cEmailCheck(String customerEmailCheck) {
		log.info("customerEmailCheck()");
		int cnt = cDao.checkDuplicateId(customerEmailCheck);

		String res = null;
		if (cnt > 0) {
			// ���̵� ����
			res = "fail";
		} else {
			// ���̵� ����
			res = "ok";
		}

		return res;
	}

	public String insertCustomer(List<MultipartFile> files,
									CustomerDto customer, 
									HttpSession session,
									RedirectAttributes rttr) {
		log.info("insertCustomer()");
		String msg = null; // DB�� ���� ����/���� ���� �޼��� ����
		String view = null;// ��� ������ ���� ����
		String upFile = files.get(0).getOriginalFilename();
		// ���ε��ϴ� ������ �̸��� ����.

		try {
			if (!upFile.equals("")) {
				FileUpload(files, session, customer);
			}
			cDao.insertCustomer(customer);
			view = "redirect:/";
			msg = "���� ����";
		} catch (Exception e) {// ���� ������ ���
			e.printStackTrace();
			view = "redirect:/";
			msg = "���� ����";
		}
		rttr.addFlashAttribute("msg", msg);

		return view;
	}
	
	private void FileUpload(List<MultipartFile> files, HttpSession session, CustomerDto customer) throws Exception {
		log.info("cServ�� fileUpload()");

		String sysname = null;// �����ϴ� ���ϸ�
		String oriname = null;// ���� ���ϸ�

		String realPath = session.getServletContext().getRealPath("/");
		log.info(realPath);
		realPath += "resources/upload/";
		File folder = new File(realPath);
//isDirectory() : �ش� �̸��� ������ �ƴϰų� �������������� false
		if (folder.isDirectory() == false) {
			folder.mkdir();// �������� �޼ҵ�
		}

		MultipartFile mf = files.get(0);
		oriname = mf.getOriginalFilename();

		sysname = System.currentTimeMillis() + oriname.substring(oriname.lastIndexOf("."));

		File file = new File(realPath + sysname);

		mf.transferTo(file); // �ϵ��ũ(��λ��� ����)�� ����
		customer.setCustomerProfile(sysname);
	}

	// �α��α��
		public String cLogin(CustomerDto customer, HttpSession session, RedirectAttributes rttr) {
			log.info("login2()");
			String msg = null;
			String view = null;
			CustomerDto loggedInCustomer = cDao.login(customer);
			System.out.println(loggedInCustomer);
			
			if (loggedInCustomer != null) {
				msg = "�α��� ����";
				view = "redirect:/";

				System.out.println(loggedInCustomer);
				// �α��ν� ���ǿ� ����
				session.setAttribute("cLogin", loggedInCustomer);
				System.out.println(loggedInCustomer);

			} else {
				msg = "�̸��� �� ��й�ȣ�� �ٽ� Ȯ�����ּ���.";
				view = "redirect:cLogin";
			}

			rttr.addFlashAttribute("msg", msg);
			System.out.println(msg);

			return view;
		}
	// ȸ������ ���� ó��
		public String customerUpdate(List<MultipartFile> files, CustomerDto customer, HttpSession session,
				RedirectAttributes rttr) {
			log.info("customerUpdate()");
			String msg = null;
			String view = null;
			String poster = customer.getCustomerProfile();// ��������(������)
			
			try {
				if (!files.get(0).isEmpty()) {
					FileUpload(files, session, customer);

					// �������� ����
					if (poster != null) {
						cFileDelete(poster, session);
					}
				}
				cDao.updateCustomer(customer);
				System.out.println("cServ" + customer);

				view = "redirect:/"; // + member.getMemberId();
				msg = "���� ����";
				// ���� ���� ����
			} catch (Exception e) {
				e.printStackTrace();
				view = "redirect:mUpdate?memberId=" + customer.getCustomerId();
				msg = "���� ����";
			}

			rttr.addFlashAttribute("msg", msg);
			return view;
		}
		
		// ���� ���ε��̹��� ���� ó�� �޼���
		private void cFileDelete(String poster, HttpSession session) throws Exception {
			log.info("fileDelete()");

			String realPath = session.getServletContext().getRealPath("/");
			realPath += "resouces/upload/" + poster;
			File file = new File(realPath);
			if (file.exists()) {
				file.delete();
			}

		}

		// ȸ�� Ż�� �޼���
		public String cDelete(Integer customerId, HttpSession session, RedirectAttributes rttr) {
			log.info("cDelete()");
			String msg = null;
			String view = null;
			CustomerDto loginInfo = (CustomerDto) session.getAttribute("cLogin");
			int id = loginInfo.getCustomerId();

			try {
				if (loginInfo != null) {
					cDao.deleteCustomer(id);
					System.out.println("cServ" + id);

					view = "redirect:/"; 
					msg = "Ż�� ����";
				}

				// ���� ���� ����
			} catch (Exception e) {
				e.printStackTrace();
				view = "redirect:/";
				msg = "Ż�� ����";
			}

			rttr.addFlashAttribute("msg", msg);
			return view;

		}
		
		// �����ȸ�� �̸���ã��
		public String cFindById(CustomerDto customer, Model model, RedirectAttributes rttr) {
		    log.info("cFindById()");
		    System.out.println(customer);
		    String msg = null;
		    CustomerDto EmailResult = cDao.FindById(customer);
		    System.out.println(EmailResult);
		    
		    if(EmailResult == null) {
		        msg = "���Ե� ������ �����ϴ� �ٽ� Ȯ�����ּ���.";
		        rttr.addFlashAttribute("msg", msg);
		        return "redirect:/cFindById";
		    } else {
		        model.addAttribute("EmailResult", EmailResult);
		        return "cFindById";
		    }
		}
		
		// �����ȸ�� ��й�ȣã��
				public String cFindByPass(CustomerDto customer, Model model, RedirectAttributes rttr) {
				    log.info("cFindByPass()");
				    System.out.println(customer);
				    String msg = null;
				    CustomerDto PassResult = cDao.FindByPass(customer);
				    System.out.println(PassResult);
				    
				    if(PassResult == null) {
				        msg = "���Ե� ������ �����ϴ� �ٽ� Ȯ�����ּ���.";
				        rttr.addFlashAttribute("msg", msg);
				        return "redirect:/cFindByPass";
				    } else {
				        model.addAttribute("PassResult", PassResult);
				        return "cPassUpdate";
				    }
				}
				
				//�����ȸ�� ��й�ȣ ó�� �޼���
				public String cUpdatePassProc(CustomerDto customer,RedirectAttributes rttr) {
					log.info("cUpdatePassProc()");
					System.out.println(customer);
					String msg = null;
					String view = null;
					cDao.cUpdatePassProc(customer);
					
					
					msg = "������ �Ϸ�Ǿ����ϴ� �α��� �� �̿����ּ���";
					view = "redirect:/cLogin";
					rttr.addFlashAttribute("msg", msg);
					
					return view;
				}
}