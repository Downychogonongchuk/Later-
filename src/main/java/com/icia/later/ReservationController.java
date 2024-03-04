package com.icia.later;


import javax.servlet.http.HttpSession;

import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dto.BoardDto;
import com.icia.later.dto.MemberDto;
import com.icia.later.dto.ReservationDto;
import com.icia.later.service.BoardService;
import com.icia.later.service.ReservationService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReservationController {
	
	@Autowired
	private ReservationService rServ;
	@Autowired
	private BoardService bServ;

	
	// 예약처리
			@PostMapping("rev")
			public String rev(HttpSession session,
					RedirectAttributes rttr,
					Integer boardId) {
				log.info("rev()");
				
				MemberDto member = (MemberDto) session.getAttribute("mLogin");
				
				if(member != null) {
					Integer memberId = member.getMemberId();
					System.out.println(memberId);
					ReservationDto rDto = rServ.selectRev(memberId, boardId, rttr, session);
					if (rDto == null) {
						// 예약한 업체 가져오기
						BoardDto board = bServ.getBoard(boardId);
						// 예약을 했을 때 hits 증가
						Integer hits = board.getHits();
						System.out.println(hits);
						hits++;
						System.out.println(hits);
						// 증가한 hits 수정
						bServ.updateHits(boardId, hits);
						String view = rServ.insertRev(memberId, boardId, rttr, session);
						return view;
					} else {
						String msg = "이미 신청하셨습니다.";
						String view = "redirect:/";
						rttr.addFlashAttribute("msg", msg);
						return view;
					}
					
					
				} else {
					
					return "redirect:mLogin";
				}
			}
}
				
			
	
	
	
	

	
	
	
	

