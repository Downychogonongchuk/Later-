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

import com.icia.later.dao.BoardDao;
import com.icia.later.dao.MemberDao;
import com.icia.later.dao.ReservationDao;
import com.icia.later.dto.BoardDto;
import com.icia.later.dto.MemberDto;
import com.icia.later.dto.ReservationDto;
import com.icia.later.util.PagingUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class ReservationService {
	@Autowired
	private ReservationDao rDao;
	@Autowired
	private BoardDao bDao;
	

	// 예약 정보 저장 
	public String insertRev(Integer memberId1, Integer boardId1, RedirectAttributes rttr,
			HttpSession session) {

		log.info("insertRev()");
		String msg = null;
		String view = null;
		
		LocalDateTime currentTime = LocalDateTime.now();
		ReservationDto reservationDto = new ReservationDto();
			 
			reservationDto.setReservationTime(currentTime);
			reservationDto.setStatus("대기중");
			reservationDto.setMemberId(memberId1);
			reservationDto.setBoardId(boardId1);
			rDao.insertReservation(reservationDto); // 데이터베이스에 예약 정보 저장

			msg = "신청하였습니다.";
			view = "redirect:/";
			// 세션이 존재하고 비어 있지 않은 경우
			// 세션을 사용하여 필요한 작업을 수행합니다.
			
			rttr.addFlashAttribute("msg", msg);
			System.out.println(msg);
		
		return view;
	}
	
	

	// 신청 목록을 가져와서 컨트롤러에 넘기는 메소드
	public String getBoardListBymemberId(Integer pageNum, 
			Model model,
			HttpSession session,
			Integer memberId11) {
		log.info("getBoardListBymemberId()");
		System.out.println("mId"+memberId11);
		
		if(pageNum == null) {
			pageNum = 1;//처음에 사이트가 열릴 때 첫페이지가 되도록 설정.
		}
		
		int listCnt = 5;//페이지당 보여질 콘텐츠 개수
		
		Map<String, Integer> pMap = new HashMap<String, Integer>();
		
		pMap.put("pageNum", (pageNum - 1) * listCnt);
		pMap.put("listCnt", listCnt);
		pMap.put("memberId11", memberId11);
		
		List<BoardDto> bList = rDao.getBoardListBymemberId(pMap);
		System.out.println("bList"+ bList);
		model.addAttribute("bList", bList);
		
		//페이징 처리
		String pageHtml = getPaging(pageNum, listCnt);
		model.addAttribute("paging", pageHtml);
		
		session.setAttribute("pageNum", pageNum);
		
		return "applyCompany";
	}

	
	private String getPaging(Integer pageNum, Integer listCnt) {
		String pageHtml = null;
		
		//신청한 업체 개수
		int maxNum = rDao.cntBoard();
		//페이지 당 보여질 번호 개수
		int pageCnt = 2;
		
		PagingUtil paging = new PagingUtil(maxNum, pageCnt, listCnt, pageCnt);
		
		pageHtml = paging.makePaging();
		
		return pageHtml;
	}



	public ReservationDto selectRev(Integer memberId, Integer boardId, RedirectAttributes rttr, HttpSession session) {
		
		
		Map<String, Integer> pMap = new HashMap<String, Integer>();
		pMap.put("memberId", memberId);
		pMap.put("boardId", boardId);
		
		ReservationDto rDto = rDao.selectRev(pMap);
		
		return rDto;
	
	}


		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
