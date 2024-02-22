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
	
	// ����ó��
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
//            HttpSession session) { // HttpSession�� �Ķ���ͷ� �޾� ������ ����մϴ�.
//
//        String customer_id = getCustomerIdFromSession(session); // ���ǿ��� �� ID�� �����ɴϴ�.
//
//        ReservationDto reservationDto = new ReservationDto();
//        reservationDto.setMemberId(MemberId); // ���ǿ��� ������ �� ID�� �����մϴ�.
//        reservationDto.setBoardId(BoardId); // �Խñ� ID 
//        reservationDto.setStatus("1"); // ������ �Ϸ�Ǿ����� ��Ÿ���� ����
//        reservationDto.setperiodStart(periodStart);
//        reservationDto.setperiodEnd(periodEnd);
//
//        // �����ͺ��̽��� ����
//        seatReservationService.saveReservation(reservationDto);
//        log.info("���� ����");
//        return "redirect:/main"; // ������ ���������� �Ϸ�Ǹ� ���� �������� �����̷�Ʈ
//    }
//	
	
	
	
	
	
}
