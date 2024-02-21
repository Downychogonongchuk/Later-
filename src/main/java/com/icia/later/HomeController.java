package com.icia.later;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dto.BoardDto;
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
	
	//������������� ��ȯ
	@GetMapping("writeFrm")
	public String writeFrm() {
		log.info("writeFrm()");
			
		return "writeFrm";
	}
	
	//ȸ������ ���� ������ �̵�
	@GetMapping("mUpdate")
	public String mUpdate() {
		log.info("mUpdate");
		
		return("mUpdate");
	}
	
	// �α��������� �̵�
	@GetMapping("loginPage")
	public String loginPage() {
		log.info("loginPage()");
		
		return "loginPage";
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
	
	// ������� ó�� �޼���
	@PostMapping("writeProc")
	public String writeProc(@RequestPart List<MultipartFile> files, 
			BoardDto board,
			HttpSession session,
			RedirectAttributes rttr) {
		log.info("writeProc()");
		
		String view = bServ.insertBoard(files, board, session, rttr);
		return view;
	}
	
	
}