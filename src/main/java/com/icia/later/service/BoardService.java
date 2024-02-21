package com.icia.later.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.icia.later.dao.BoardDao;
import com.icia.later.dto.BoardDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardService {
	// DAO
		@Autowired
		private BoardDao bDao;

		public void getCompanyDetail(Integer boardId,Model model) {
			log.info("getCompanyDetail()");
			//DB에서 데이터 가져오기
			BoardDto board = bDao.selectBoard(boardId);
			//DB에서 데이터 가져오기
			model.addAttribute("board", board);
			System.out.println(model);
			
		}
		
}
