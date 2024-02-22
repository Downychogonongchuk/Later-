package com.icia.later.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	//������������� ��ȯ
		@GetMapping("writeFrm")
		public String writeFrm() {
			log.info("writeFrm()");
				
			return "writeFrm";
		}
		
	// ������� ó�� �޼���
		@PostMapping("writeProc")
		public String writeProc(@RequestPart List<MultipartFile> files, 
				BoardDto board,
				HttpSession session,
				RedirectAttributes rttr) {
			log.info("writeProc()");
			
			String view = bServ.insertBoard(files, board, session, rttr);
			return view;
		}
}
