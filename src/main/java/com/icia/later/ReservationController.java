package com.icia.later;

import java.time.LocalDateTime;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dto.BoardDto;
import com.icia.later.dto.MemberDto;
import com.icia.later.dto.ReservationDto;
import com.icia.later.service.BoardService;
import com.icia.later.service.MemberService;
import com.icia.later.service.ReservationService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReservationController {
	
	@Autowired
	private BoardService bServ;
	@Autowired
	private ReservationService rServ;
	

	
	// ����ó��
			@PostMapping("rev")
			public String rev(HttpServletRequest request,HttpSession session,
					RedirectAttributes rttr,
					Integer boardId) {
				log.info("rev()");
				
				// http session ��������
				HttpSession session11 = request.getSession();
				
				Object someValue = (Object) session11.getAttribute("login");
			
				// �Ӽ��� null�� �ƴϰ�  // �α��� ������ MemberDto�� �ν��Ͻ����� Ȯ��
				if (someValue != null && someValue instanceof MemberDto) {
					
				    // �α��� ����(��ü)�� MemberDto�� ����ȯ�մϴ�.
					 MemberDto memberDto = (MemberDto) someValue;
					 
					 // ȸ�� ID ��������
					 Integer memberId1 = memberDto.getMemberId();
					 System.out.println(memberId1);
					 
					 String view = rServ.insertRev(memberId1, boardId, rttr, session);
					    return view;
				} else{
					// ���ǿ� ����� ���� MemberDto Ÿ���� �ƴ� ��� ó��
			        // ���� ���, �α����� �Ǿ� ���� ���� ���� � ���� ó���� �߰��� �� �ֽ��ϴ�.
			        // ���⿡ ������ ������ �߰��ϼ���.
			        return "redirect:/mlogin"; // �α��� �������� �����̷�Ʈ ����
					
					}
				}
				   
				
			}
	
	
	
	

	
	
	
	

