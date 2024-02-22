package com.icia.later;

import java.time.LocalDateTime;
import java.util.List;

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
	private ReservationService rServ;
	
	// 예약처리
			@PostMapping("rev")
			public String rev(@RequestPart List<MultipartFile> files, 
					BoardDto board,
					HttpSession session,
					RedirectAttributes rttr) {
				log.info("rev()");
				
				String view = rServ.insertRev(files, board, session, rttr);
				System.out.println(board);
				
				
				return view;
			}
	
	
	
	
//	@PostMapping("/rsv")
//    public String processPayment(@PathVariable String room_name,
//            @RequestParam("boardId") int boardId,
//            @RequestParam("periodStart") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime periodStart,
//            @RequestParam("periodEnd") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime periodEnd,
//            HttpSession session) { // HttpSession을 파라미터로 받아 세션을 사용합니다.
//
//        String customer_id = getCustomerIdFromSession(session); // 세션에서 고객 ID를 가져옵니다.
//
//        ReservationDto reservationDto = new ReservationDto();
//        reservationDto.setMemberId(MemberId); // 세션에서 가져온 고객 ID를 설정합니다.
//        reservationDto.setBoardId(BoardId); // 게시글 ID 
//        reservationDto.setStatus("1"); // 결제가 완료되었음을 나타내는 상태
//        reservationDto.setperiodStart(periodStart);
//        reservationDto.setperiodEnd(periodEnd);
//
//        // 데이터베이스에 저장
//        seatReservationService.saveReservation(reservationDto);
//        log.info("예약 성공");
//        return "redirect:/main"; // 결제가 성공적으로 완료되면 메인 페이지로 리다이렉트
//    }
//	
	
	
	
	
	
}
