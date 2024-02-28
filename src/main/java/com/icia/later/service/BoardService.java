package com.icia.later.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.icia.later.dao.BoardDao;
import com.icia.later.dto.BoardDto;
import com.icia.later.util.PagingUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardService {
	// DAO
	@Autowired
	private BoardDao bDao;

	public String getBoardListBycustomerId(Integer pageNum, 
											Model model, 
											HttpSession session) {
		log.info("getBoardListBycustomerId()");

		if (pageNum == null) {
			pageNum = 1; // 처음에 사이트가 열릴 때 첫페이지가 되도록 설정
		}
		
		int listCnt = 5; // 페이지당 보여질 콘텐츠 개수
		
		Map<String, Integer> pMap = new HashMap<>();
		pMap.put("pageNum", (pageNum - 1) * listCnt);
		pMap.put("listCnt", listCnt);
		
		List<BoardDto> bList = bDao.getBoardListBycustomerId(pMap, listCnt);

		
		model.addAttribute("bList", bList);
		
		// 페이징 처리
		String pageHtml = getPaging(pageNum, listCnt);
		model.addAttribute("pageHtml", pageHtml);
		model.addAttribute("pageNum", pageNum);
		
		return "home";
	}
	
	private String getPaging(Integer pageNum, Integer listCnt) {
		String pageHtml = null;
		
		int maxNum = bDao.cntBoard();
		int pageCnt = 2;
		
		
		PagingUtil paging = new PagingUtil(maxNum, pageCnt, maxNum, pageCnt);
		
		pageHtml = paging.makePaging();
		
		return pageHtml;
	}

	public void getCategory() {

	}

}
