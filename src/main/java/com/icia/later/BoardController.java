package com.icia.later;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dto.BoardDto;
import com.icia.later.dto.CustomerDto;
import com.icia.later.dto.MemberDto;
import com.icia.later.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	@Autowired
	private BoardService bServ;
	

	//모집등록페이지 전환
		@GetMapping("writeFrm")
		public String writeFrm(Model model, HttpSession session) {
			log.info("writeFrm()");
			
			CustomerDto cLogInInfo = (CustomerDto) session.getAttribute("cLogin");
			
			System.out.println(cLogInInfo);
			if(cLogInInfo != null) {
				model.addAttribute("customer", cLogInInfo);
				
			}
			
			return "writeFrm";
		}
		
	// 모집등록 처리 메서드
		@PostMapping("writeProc")
		public String writeProc(@RequestPart List<MultipartFile> files, 
				HttpServletRequest request,
				@Param("board")BoardDto board,
				HttpSession session,
				RedirectAttributes rttr) {
			log.info("writeProc()");
			
			// http session 가져오기
			HttpSession session1 = request.getSession();
			System.out.println("session1"+session1);
			
			Object someValue = (Object) session1.getAttribute("cLogin");
			
		
			// 속성이 null이 아니고  // 로그인 정보가 MemberDto의 인스턴스인지 확인
			if (someValue != null && someValue instanceof CustomerDto) {
				
			    // 로그인 정보(객체)를 MemberDto로 형변환합니다.
				CustomerDto customerDto = (CustomerDto) someValue;
				 
				 // 회원 ID 가져오기
				 Integer customerId = customerDto.getCustomerId();
				 System.out.println("customerId"+customerId);
				 
				 String view = bServ.insertBoard(files,customerId, board, rttr, session);
				    return view;
			} else{
				
		        return "redirect:/login"; // 로그인 페이지로 리다이렉트 예시
				
				}
			}
			
			
			
		}
		
	
	
		
		
		
		
		
