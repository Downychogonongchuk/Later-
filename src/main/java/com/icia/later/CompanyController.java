package com.icia.later;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dto.BoardDto;
import com.icia.later.dto.CustomerDto;
import com.icia.later.dto.MemberDto;
import com.icia.later.service.BoardService;
import com.icia.later.service.MemberService;
import com.icia.later.service.ReservationService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CompanyController {

	@Autowired
	private MemberService mServ;
	@Autowired
	private BoardService bServ;
	@Autowired
	private ReservationService rServ;

	// 업체 상세페이지
	@GetMapping("companyDetail")
	public String companyDetail(Integer boardId, Model model) {
		log.info("companyDetail()");
		//boardId = 15;

		bServ.getCompanyDetail(boardId, model);
		System.out.println(model);
		// model.addAttribute(model);

		return "companyDetail";
	}

	// 신청 예약페이지 이동
			@GetMapping("applyCompany")
			
			public String applyCompany(Integer pageNum, 
										Model model,
										HttpSession session,
										Integer memberId1 ) {		
				log.info("applyCompany()");
				
			    Object someValue = session.getAttribute("mLogin");

			    if (someValue instanceof MemberDto) {
			        MemberDto memberDto = (MemberDto) someValue;

			        Integer memberId11 = memberDto.getMemberId();
			        
					 String view = rServ.getBoardListBymemberId(pageNum, 
							 model,
							 session, 
							 memberId11);
					    return view;
				} else{
					
			        return "redirect:/mlogin"; // 로그인 페이지로 리다이렉트 예시
					
					}
				}
			
			
			// 모집글 페이지 이동
						@GetMapping("companyList")
						
						public String companyList(Integer pageNum, 
													Model model,
													HttpSession session,
													Integer customerId1 ) {		
							log.info("companyList()");
							
						    Object someValue = session.getAttribute("cLogin");

						    if (someValue instanceof CustomerDto) {
						    	CustomerDto customerDto = (CustomerDto) someValue;

						        Integer customerId = customerDto.getCustomerId();
						        
								 String view = bServ.getBoardListBycustomerId(pageNum, 
										 model,
										 session, 
										 customerId);
								    return view;
							} else{
								
						        return "redirect:/clogin"; // 로그인 페이지로 리다이렉트 예시
								
								}
							}
			
		}

	  
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			


