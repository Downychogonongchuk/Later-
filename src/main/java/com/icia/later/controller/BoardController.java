package com.icia.later.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dto.BoardDto;
import com.icia.later.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	@Autowired
	private BoardService bServ;
	
	//모집등록페이지 전환
		@GetMapping("writeFrm")
		public String writeFrm() {
			log.info("writeFrm()");
				
			return "writeFrm";
		}
		
	// 모집등록 처리 메서드
		@PostMapping("writeProc")
		public String writeProc(@RequestPart List<MultipartFile> files, 
				BoardDto board,
				HttpSession session,
				RedirectAttributes rttr) {
			log.info("writeProc()");
			
			String view = bServ.insertBoard(files, board, session, rttr);
			return view;
		}
		
		//업체정보 수정페이지 전환
		@GetMapping("bUpdate")
		public String bUpdate(Integer boardId, Model model) {
			log.info("bUpdate()");
			
			bServ.getBoard(boardId, model);
			
			return "bUpdate";
		}
		
		//업체정보 수정 처리 메서드
		@PostMapping("bUpdateProc")
		public String bUpdateProc(@RequestPart List<MultipartFile> files, 
				BoardDto board,
				HttpSession session,
				RedirectAttributes rttr) {
			log.info("bUpdateProc()");
			String view = bServ.boardUpdate(files, board, session, rttr);
			
			return view;
		}
}
