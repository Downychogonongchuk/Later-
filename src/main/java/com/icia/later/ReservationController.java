package com.icia.later;

import java.time.LocalDateTime;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dto.BoardDto;
import com.icia.later.dto.MemberDto;
import com.icia.later.dto.ReservationDto;
import com.icia.later.service.BoardService;
import com.icia.later.service.MemberService;
import com.icia.later.service.ReservationService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReservationController {
	
	@Autowired
	private BoardService bServ;
	@Autowired
	private ReservationService rServ;
	

	
	// 예약처리
			@PostMapping("rev")
			public String rev(HttpServletRequest request,HttpSession session,
					RedirectAttributes rttr,
					Integer boardId) {
				log.info("rev()");

				    
				MemberDto member = (MemberDto) session.getAttribute("mLogin");

				
				Object someValue = (Object) session11.getAttribute("login");
			
				// 속성이 null이 아니고  // 로그인 정보가 MemberDto의 인스턴스인지 확인
				if (someValue != null && someValue instanceof MemberDto) {
					
				    // 로그인 정보(객체)를 MemberDto로 형변환합니다.
					 MemberDto memberDto = (MemberDto) someValue;
					 
					 // 회원 ID 가져오기
					 Integer memberId1 = memberDto.getMemberId();
					 System.out.println(memberId1);
					 
					 String view = rServ.insertRev(memberId1, boardId, rttr, session);
					    return view;
				} else{
					// 세션에 저장된 값이 MemberDto 타입이 아닌 경우 처리
			        // 예를 들어, 로그인이 되어 있지 않은 상태 등에 대한 처리를 추가할 수 있습니다.
			        // 여기에 적절한 로직을 추가하세요.
			        return "redirect:/login"; // 로그인 페이지로 리다이렉트 예시
					
					}
				}
				   
				
			}