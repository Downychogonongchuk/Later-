package com.icia.later.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dao.BoardDao;
import com.icia.later.dto.BoardDto;
import com.icia.later.dto.MemberDto;
import com.icia.later.util.PagingUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardService {
	// DAO
		@Autowired
		private BoardDao bDao;

		
		
		
		
		
		// 업체 상세 가져오기
		public void getCompanyDetail(Integer boardId,Model model) {
			log.info("getCompanyDetail()");
			//DB에서 데이터 가져오기
			BoardDto board = bDao.selectBoard(boardId);
			//DB에서 데이터 가져오기
			model.addAttribute("board", board);
			System.out.println(model);
			
		}

		// 모집글 목록을 가져오기 
		public String getBoardListBycustomerId(Integer pageNum, 
				Model model,
				HttpSession session,
				Integer customerId) {
			log.info("getBoardListBycustomerId()");
			System.out.println("cId"+customerId);
			
			if(pageNum == null) {
				pageNum = 1;//처음에 사이트가 열릴 때 첫페이지가 되도록 설정.
			}
			
			int listCnt = 5;//페이지당 보여질 콘텐츠 개수
			
			Map<String, Integer> pMap = new HashMap<String, Integer>();
			
			pMap.put("pageNum", (pageNum - 1) * listCnt);
			pMap.put("listCnt", listCnt);
			pMap.put("customerId", customerId);
			
			List<BoardDto> bList = bDao.getBoardListBycustomerId(pMap,customerId);
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
			int maxNum = bDao.cntBoard();
			//페이지 당 보여질 번호 개수
			int pageCnt = 2;
			
			PagingUtil paging = new PagingUtil(maxNum, pageCnt, listCnt, pageCnt);
			
			pageHtml = paging.makePaging();
			
			return pageHtml;
		}

		


		


		
}
