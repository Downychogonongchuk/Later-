package com.icia.later.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.icia.later.dto.BoardDto;
import com.icia.later.dto.MemberDto;
import com.icia.later.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CompanyController {
	@Autowired
	private BoardService bServ;
//	@Autowired
//	private BoardService bServ;	
	
	//��ü ��������
	@GetMapping("companyDetail")
	public String companyDetail(Integer boardId, Model model) {
		log.info("companyDetail()");
		
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
	
//	// ��û ���������� �̵�
//	@GetMapping("applyCompany")
	
//	public String applyCompany(Integer pageNum, 
//								Model model,
//								HttpSession session,
//								Integer memberId1 ) {		
//		log.info("applyCompany()");
//		
//	    MemberDto member = (MemberDto) session.getAttribute("mLogin");
//
//	    if (member != null) {
//
//	        Integer memberId = member.getMemberId();
//	        
////			 String view = rServ.getBoardListBymemberId(pageNum, 
////					 model,
////					 session, 
////					 memberId);
////			    return view;
//		} else{
//			
//	        return "redirect:/login"; // �α��� �������� �����̷�Ʈ ����
//			
//			}
//		}
}
