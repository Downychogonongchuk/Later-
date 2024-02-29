package com.icia.later.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dao.ReservationDao;
import com.icia.later.dto.BoardDto;
import com.icia.later.dto.ReservationDto;
import com.icia.later.util.PagingUtil;

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

	public String getBoardListBymemberId(Integer pageNum, Model model, HttpSession session, Integer memberId) {
		log.info("getBoardListBymemberId()");
		System.out.println("mId"+memberId);
		
		if(pageNum == null) {
			pageNum = 1;//ó���� ����Ʈ�� ���� �� ù�������� �ǵ��� ����.
		}
		
		int listCnt = 5;//�������� ������ ������ ����
		
		Map<String, Integer> pMap = new HashMap<String, Integer>();
		
		pMap.put("pageNum", (pageNum - 1) * listCnt);
		pMap.put("listCnt", listCnt);
		pMap.put("memberId", memberId);
		
		List<BoardDto> bList = rDao.getBoardListBymemberId(pMap);
		System.out.println("bList"+ bList);
		model.addAttribute("bList", bList);
		
		//����¡ ó��
		String pageHtml = getPaging(pageNum, listCnt);
		model.addAttribute("paging", pageHtml);
		
		session.setAttribute("pageNum", pageNum);
		
		return "applyCompany";
	}

	private String getPaging(Integer pageNum, int listCnt) {
String pageHtml = null;
		
		//��û�� ��ü ����
		int maxNum = rDao.cntBoard();
		//������ �� ������ ��ȣ ����
		int pageCnt = 2;
		
		PagingUtil paging = new PagingUtil(maxNum, pageCnt, listCnt, pageCnt);
		
		pageHtml = paging.makePaging();
		
		return pageHtml;
	}

	public List<ReservationDto> getReservationList(Integer boardId) {
		
		List<ReservationDto> rList = rDao.getReservationList(boardId);
		
		return rList;
	}
	
}