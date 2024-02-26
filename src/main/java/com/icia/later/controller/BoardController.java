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
import com.icia.later.dto.CustomerDto;
import com.icia.later.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	@Autowired
	private BoardService bServ;
	
	//������������� ��ȯ
		@GetMapping("writeFrm")
		public String writeFrm(Model model, HttpSession session) {
			log.info("writeFrm()");
			
			CustomerDto cLogInInfo = (CustomerDto) session.getAttribute("cLogin");
			
			System.out.println(cLogInInfo);
			if(cLogInInfo != null) {
				model.addAttribute("customer", cLogInInfo);
				
			}
			
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
		
		//��ü���� ���������� ��ȯ
		@GetMapping("bUpdate")
		public String bUpdate(Integer boardId, Model model, HttpSession session) {
			log.info("bUpdate()");
			
			bServ.getBoard(boardId, model);
			
//			CustomerDto cLogInInfo = (CustomerDto) session.getAttribute("cLogin");
//			
//			System.out.println(cLogInInfo);
//			if(cLogInInfo != null) {
//				model.addAttribute("customer", cLogInInfo);
//			}
			
			return "bUpdate";
		}
		
		//��ü���� ���� ó�� �޼���
		@PostMapping("bUpdateProc")
		public String bUpdateProc(@RequestPart List<MultipartFile> files, 
				BoardDto board,
				HttpSession session,
				RedirectAttributes rttr) {
			log.info("bUpdateProc()");
			String view = bServ.boardUpdate(files, board, session, rttr);
			
			return view;
		}
		
		// ��ü ���� �޼���
		@GetMapping("bDelete")
		public String bDelete(Integer boardId,
							  HttpSession session,
							  RedirectAttributes rttr) {
			log.info("bDelete()");
			String view = bServ.boardDelete(boardId, session, rttr);
			return view;
		}
}
