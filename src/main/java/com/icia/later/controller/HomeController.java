package com.icia.later.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.icia.later.dto.BoardDto;
import com.icia.later.dto.CustomerDto;
import com.icia.later.dto.MemberDto;
import com.icia.later.service.BoardService;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class HomeController {
	@Autowired
	private BoardService bServ;
	
	//����������
	@GetMapping("/")
	public String home(Model model, HttpSession session) {
		log.info("home()");
		
		List<BoardDto> bList = bServ.getBoardList();
		// �α����� �Ϲ� ȸ�� ����(2024-02-26)
		MemberDto mLogInInfo = (MemberDto) session.getAttribute("mLogin");
		// �α����� ����� ȸ�� ����(2024-02-26)
		CustomerDto cLogInInfo = (CustomerDto) session.getAttribute("cLogin");
	    // �α����� ȸ�� ������ �𵨿� �߰��Ͽ� JSP�� ����
	    model.addAttribute("mLogInInfo", mLogInInfo);
	    // �α����� ����� ������ �𵨿� �߰��Ͽ� JSP�� ����
	    model.addAttribute("cLogInInfo", cLogInInfo);
	    
	    model.addAttribute("bList", bList);
		return "home";
	}
	
	//���������� �̵�
	@GetMapping("myPage")
	public String myPage(Model model, HttpSession session) {
		log.info("myPage()");
		
		// �α����� �Ϲ� ȸ�� ����(2024-02-26)
		MemberDto mLogInInfo = (MemberDto) session.getAttribute("mLogin");
		// �α����� ����� ȸ�� ����(2024-02-26)
		CustomerDto cLogInInfo = (CustomerDto) session.getAttribute("cLogin");
		// �α����� ȸ�� ������ �𵨿� �߰��Ͽ� JSP�� ����
		model.addAttribute("mLogInInfo", mLogInInfo);
		// �α����� ����� ������ �𵨿� �߰��Ͽ� JSP�� ����
		model.addAttribute("cLogInInfo", cLogInInfo);
			    
	    return "myPage";
	}
}