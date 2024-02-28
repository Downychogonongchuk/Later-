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
			reservationDto.setStatus("�����");
			reservationDto.setMemberId(memberId);
			reservationDto.setBoardId(boardId);
			rDao.insertReservation(reservationDto); // �����ͺ��̽��� ���� ���� ����

			msg = "��û�Ͽ����ϴ�.";
			view = "redirect:/";
			// ������ �����ϰ� ��� ���� ���� ���
			// ������ ����Ͽ� �ʿ��� �۾��� �����մϴ�.
			
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
