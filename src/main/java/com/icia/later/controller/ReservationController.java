package com.icia.later.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dto.MemberDto;
import com.icia.later.service.ReservationService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReservationController {
	@Autowired
	private ReservationService rServ;
	
	@PostMapping("rev")
	public String rev(HttpSession session, RedirectAttributes rttr,
					  Integer boardId) {
		log.info("rev()");
		
		MemberDto member = (MemberDto) session.getAttribute("mLogin");
		
		if(member != null) {
			Integer memberId = member.getMemberId();
			System.out.println(memberId);
			
			String view = rServ.insertRev(memberId, boardId, rttr, session);
			return view;
		} else {
			
			return "redirect:login";
		}
		
	}
}
