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
import com.icia.later.dto.ReservationDto;
import com.icia.later.service.BoardService;
import com.icia.later.service.ReservationService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CompanyController {
	@Autowired
	private BoardService bServ;
	@Autowired
	private ReservationService rServ;	
	
	//��ü ��������
	@GetMapping("companyDetail")
	public String companyDetail(Integer boardId, Model model, HttpSession session) {
		log.info("companyDetail()");
		
		MemberDto mLogInInfo = (MemberDto) session.getAttribute("mLogin");
		// �α����� ����� ȸ�� ����(2024-02-26)
		CustomerDto cLogInInfo = (CustomerDto) session.getAttribute("cLogin");
	    // �α����� ȸ�� ������ �𵨿� �߰��Ͽ� JSP�� ����
	    model.addAttribute("mLogInInfo", mLogInInfo);
	    // �α����� ����� ������ �𵨿� �߰��Ͽ� JSP�� ����
	    model.addAttribute("cLogInInfo", cLogInInfo);
		
		BoardDto board = bServ.getBoard(boardId);
		
		model.addAttribute("board", board);
		return "companyDetail";
	}
	
	// ������ ������ �̵�
	@GetMapping("companyList")
	
	public String companyList(Integer pageNum, 
								Model model,
								HttpSession session,
								Integer customerId ) {		
		log.info("companyList()");
		
			 String view = bServ.getBoardListBycustomerId(pageNum, 
					 model,
					 session, 
					 customerId);
			    return view;
		}
	
	// ��û ���������� �̵�
	@GetMapping("applyCompany")
	
	public String applyCompany(Integer pageNum, 
								Model model,
								HttpSession session,
								Integer memberId1 ) {		
		log.info("applyCompany()");
		
	    MemberDto member = (MemberDto) session.getAttribute("mLogin");

	    if (member != null) {

	        Integer memberId = member.getMemberId();
	        
			 String view = rServ.getBoardListBymemberId(pageNum, 
					 model,
					 session, 
					 memberId);
			    return view;
	} else{
			
	        return "redirect:/login"; // �α��� �������� �����̷�Ʈ ����
		
			}
		}
	
	// ��ü�� ��û�� ȸ���� �����ִ� ������
	@GetMapping("selectApply")
	public String selectApply(Model model, Integer boardId, HttpSession session) {
		log.info("selectApply()");
		
		List<ReservationDto> rList = rServ.getReservationList(boardId);
		
		System.out.println(rList);
		
//		for(int i=0; i<=rList.size(); i++) {
//			MemberDto mDto = mDao.
//		}
		
		MemberDto mLogInInfo = (MemberDto) session.getAttribute("mLogin");
		// �α����� ����� ȸ�� ����(2024-02-26)
		CustomerDto cLogInInfo = (CustomerDto) session.getAttribute("cLogin");
	    // �α����� ȸ�� ������ �𵨿� �߰��Ͽ� JSP�� ����
	    model.addAttribute("mLogInInfo", mLogInInfo);
	    // �α����� ����� ������ �𵨿� �߰��Ͽ� JSP�� ����
	    model.addAttribute("cLogInInfo", cLogInInfo);
		model.addAttribute("rList", rList);
		
		
		return "selectApply";
	}
}