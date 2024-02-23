package com.icia.later;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.icia.later.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	@Autowired BoardService bServ;
	
	// 2024.02.22 
	//모집등록페이지 전환
	@GetMapping("writeFrm")
	public String writeFrm() {
		log.info("writeFrm()");
			
		return "writeFrm";
	}
	
	//모집등록 처리 메서드
	@PostMapping("writeProc")
	public String writeProc() {
		
		
		
		return writeFrm();
	}
}
