package com.icia.later.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dao.ReservationDao;
import com.icia.later.dto.ReservationDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReservationService {
	@Autowired
	private ReservationDao rDao;
	
	public String insertRev(Integer memberId, Integer boardId, RedirectAttributes rttr, HttpSession session) {
		
		log.info("insertRev()");
		String msg = null;
		String view = null;
		
		LocalDateTime currentTime = LocalDateTime.now();
		ReservationDto reservationDto = new ReservationDto();
			 
			reservationDto.setReservationTime(currentTime);
			reservationDto.setStatus("대기중");
			reservationDto.setMemberId(memberId);
			reservationDto.setBoardId(boardId);
			rDao.insertReservation(reservationDto); // 데이터베이스에 예약 정보 저장

			msg = "신청하였습니다.";
			view = "redirect:/";
			// 세션이 존재하고 비어 있지 않은 경우
			// 세션을 사용하여 필요한 작업을 수행합니다.
			
			rttr.addFlashAttribute("msg", msg);
			System.out.println(msg);
		
		return view;
	}

	public ReservationDto selectRev(Integer memberId, Integer boardId, RedirectAttributes rttr, HttpSession session) {
		Map<String, Integer> pMap = new HashMap<String, Integer>();
		pMap.put("memberId", memberId);
		pMap.put("boardId", boardId);
		
		ReservationDto rDto = rDao.selectRev(pMap);
		
		return rDto;
	}
	
}
