package com.icia.later;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
	                  Integer boardId,
	                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime periodStart,
	                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime periodEnd) {
	    log.info("rev()");
	    LocalDateTime now = LocalDateTime.now();
	    MemberDto member = (MemberDto) session.getAttribute("mLogin");
	    String msg = null;
	    String view = null;
	    
	    if (periodStart.isBefore(now) && periodEnd.isAfter(now)) {
	        if (member != null) {
	            Integer memberId = member.getMemberId();
	            System.out.println(memberId);
	            ReservationDto rDto = rServ.selectRev(memberId, boardId, rttr, session);
	            if (rDto == null) {
	                // 예약한 업체 가져오기
	                BoardDto board = bServ.getBoard(boardId);
	                // 예약을 했을 때 hits 증가
	                Integer hits = board.getHits();
	                hits++;
	                // 증가한 hits 수정
	                bServ.updateHits(boardId, hits);
	                view = rServ.insertRev(memberId, boardId, rttr, session);
	                return view;
	            } else {
	                msg = "이미 신청하셨습니다.";
	                view = "redirect:/";
	                rttr.addFlashAttribute("msg", msg);
	                return view;
	            }
	        } else {
	            return "redirect:mLogin";
	        }
	    } else if (periodStart.isAfter(now) || periodEnd.isBefore(now)) {
	        msg = "현재는 신청 기간이 아닙니다.";
	        view = "redirect:/";
	        rttr.addFlashAttribute("msg", msg);
	        return view;
	    }
	    
	    // 모든 조건을 처리하지 못한 경우 기본 반환값을 설정
	    return "redirect:/"; // 기본적으로는 홈페이지로 리다이렉트하도록 설정
	}
}

				
			
	
	
	
	

	
	
	
	

