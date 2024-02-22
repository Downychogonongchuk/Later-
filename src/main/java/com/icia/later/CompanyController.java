package com.icia.later;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dto.BoardDto;
import com.icia.later.dto.MemberDto;
import com.icia.later.service.BoardService;
import com.icia.later.service.MemberService;
import com.icia.later.service.ReservationService;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class CompanyController {

	@Autowired
	private MemberService mServ;
	@Autowired
	private BoardService bServ;
	@Autowired
	private ReservationService rServ;
	
	
	// 업체 상세페이지
	@GetMapping("companyDetail")
	public String companyDetail(Integer boardId, Model model) {
		log.info("companyDetail()");
		boardId =4;
		bServ.getCompanyDetail(boardId, model);
		System.out.println(model);
	//		model.addAttribute(model);
		
		return "companyDetail";
	}
		
//	@PostMapping("companyReserv")
//	public String companyReserv()

//	// 신청한 업체 목록
//	@GetMapping("applyCompany")
//	public String applyCompany(Integer boardId, Model model) {
//		log.info("detail()");
//		boardId =4;
//			rServ.applyCompany(boardId, model);
//			return "applyCompany"; // jsp파일명
//			
//	}
	
//	// 예약*신청 처리 메서드
//		@PostMapping("reservationProc")
//		public String reservationProc(@RequestPart List<MultipartFile> files, BoardDto board, HttpSession session,
//				RedirectAttributes rttr) {
//			log.info("reservationProc()");
//
//			String view = bServ.insertboard(files, board, session, rttr);
//
//			return view;
//		}

//	@GetMapping("applyCompany")
//	public String applyList(Integer MemberId, Model model) {
//		log.info("companyDetail()");
//		MemberId = 1;
//		bServ.getCompanyDetail(MemberId, model);
//		System.out.println(model);
////		model.addAttribute(model);
//		
//		return "companyDetail";
//	}
	

	
}
