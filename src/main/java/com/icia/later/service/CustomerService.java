package com.icia.later.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

	public String insertCustomer(List<MultipartFile> files,
									CustomerDto customer, 
									HttpSession session,
									RedirectAttributes rttr) {
		log.info("insertCustomer()");
		String msg = null; // DB에 저장 성공/실패 관련 메세지 저장
		String view = null;// 대상 페이지 지정 변수
		String upFile = files.get(0).getOriginalFilename();
		// 업로드하는 파일의 이름을 추출.

		try {
			if (!upFile.equals("")) {
				FileUpload(files, session, customer);
			}
			cDao.insertCustomer(customer);
			view = "redirect:/";
			msg = "가입 성공";
		} catch (Exception e) {// 저장 실패인 경우
			e.printStackTrace();
			view = "redirect:/";
			msg = "가입 실패";
		}
		rttr.addFlashAttribute("msg", msg);

		return view;
	}
	
	private void FileUpload(List<MultipartFile> files, HttpSession session, CustomerDto customer) throws Exception {
		log.info("cServ에 fileUpload()");

		String sysname = null;// 변경하는 파일명
		String oriname = null;// 원래 파일명

		String realPath = session.getServletContext().getRealPath("/");
		log.info(realPath);
		realPath += "resources/upload/";
		File folder = new File(realPath);
//isDirectory() : 해당 이름이 폴더가 아니거나 존재하지않으면 false
		if (folder.isDirectory() == false) {
			folder.mkdir();// 폴더생성 메소드
		}

		MultipartFile mf = files.get(0);
		oriname = mf.getOriginalFilename();

		sysname = System.currentTimeMillis() + oriname.substring(oriname.lastIndexOf("."));

		File file = new File(realPath + sysname);

		mf.transferTo(file); // 하드디스크(경로상의 폴더)에 저장
		customer.setCustomerProfile(sysname);
	}

	// 로그인기능
		public String cLogin(CustomerDto customer, HttpSession session, RedirectAttributes rttr) {
			log.info("login2()");
			String msg = null;
			String view = null;
			CustomerDto loggedInCustomer = cDao.login(customer);
			System.out.println(loggedInCustomer);
			
			if (loggedInCustomer != null) {
				msg = "로그인 성공";
				view = "redirect:/";

				System.out.println(loggedInCustomer);
				// 로그인시 세션에 저장
				session.setAttribute("login", loggedInCustomer);
				System.out.println(loggedInCustomer);

			} else {
				msg = "이메일 및 비밀번호를 다시 확인해주세요.";
				view = "redirect:cLogin";
			}

			rttr.addFlashAttribute("msg", msg);
			System.out.println(msg);

			return view;
		}
		
}
