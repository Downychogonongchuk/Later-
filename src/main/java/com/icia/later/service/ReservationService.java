package com.icia.later.service;



import java.time.LocalDateTime;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dao.BoardDao;
import com.icia.later.dao.MemberDao;
import com.icia.later.dao.ReservationDao;
import com.icia.later.dto.BoardDto;
import com.icia.later.dto.MemberDto;
import com.icia.later.dto.ReservationDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class ReservationService {
	@Autowired
	private ReservationDao rDao;


	public String insertRev(Integer memberId1, Integer boardId1, RedirectAttributes rttr,
			HttpSession session) {

		log.info("insertRev()");
		String msg = null;
		String view = null;
		LocalDateTime currentTime = LocalDateTime.now();
	
		ReservationDto reservationDto = new ReservationDto();
			 
			reservationDto.setReservationTime(currentTime);
			reservationDto.setStatus("�����");
			reservationDto.setMemberId(memberId1);
			reservationDto.setBoardId(boardId1);
			rDao.insertReservation(reservationDto); // �����ͺ��̽��� ���� ���� ����

			msg = "��û�Ͽ����ϴ�.";
			view = "redirect:/";
			// ������ �����ϰ� ��� ���� ���� ���
			// ������ ����Ͽ� �ʿ��� �۾��� �����մϴ�.
			
			rttr.addFlashAttribute("msg", msg);
			System.out.println(msg);
		
		return view;
	}
	
	
}
