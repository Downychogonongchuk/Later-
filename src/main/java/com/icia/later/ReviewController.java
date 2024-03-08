package com.icia.later;

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

import com.icia.later.dto.CustomerDto;
import com.icia.later.dto.MemberDto;
import com.icia.later.dto.ReviewDto;
import com.icia.later.service.MemberService;
import com.icia.later.service.ReviewService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReviewController {
	@Autowired
	private ReviewService rServ;
	@Autowired
	MemberService mServ;
	
	//리뷰 페이지 이동
	@GetMapping("review")
	public String review(Integer pageNum,
						 Model model,
						 HttpSession session) {
		log.info("review()");
		// 리뷰 정보 리스트 가져오기
		String view = rServ.getReviewList(pageNum, model, session);
		
		return view;
	}
	
	//리뷰작성 페이지 이동
	@GetMapping("reviewWrite")
	public String reviewWrite(HttpSession session, Model model) {
		log.info("reviewWrite()");
		
		// 로그인한 회원 정보 가져오기
		MemberDto member = (MemberDto) session.getAttribute("mLogin");
		
		model.addAttribute("member", member);
		return "reviewWrite";
	}
	
	//리뷰작성 처리 메서드 
	@PostMapping("rWriteProc")
	public String rWriteProc(@RequestPart List<MultipartFile> files, 
			ReviewDto review,
			HttpSession session,
			RedirectAttributes rttr) {
		log.info("rWriteProc()");
		
		// 리뷰 작성
		String view = rServ.insertReview(files, review, session, rttr);
		return view;
	}

	//리뷰 상세페이지 이동
	@GetMapping("reviewDetail")
	public String reviewDetail(Model model, Integer reviewId, Integer memberId,HttpSession session) {
		log.info("reviewDetail()");
		
		MemberDto mLogInInfo = (MemberDto) session.getAttribute("mLogin");
		CustomerDto cLogInInfo = (CustomerDto) session.getAttribute("cLogin");
		
		// 리뷰를 작성한 회원의 정보 가져오기
		mServ.getReviewByMemberId(memberId, model);
		// 리뷰 정보 가져오기
		rServ.getReview(reviewId, model);
		model.addAttribute("mLogInInfo", mLogInInfo);
		model.addAttribute("cLogInInfo", cLogInInfo);
		System.out.println(model);
		
		return "reviewDetail";
	}
}