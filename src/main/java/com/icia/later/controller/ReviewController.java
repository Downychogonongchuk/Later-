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

import com.icia.later.dto.ReviewDto;
import com.icia.later.service.ReviewService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReviewController {
	@Autowired
	private ReviewService rServ;
	
	//리뷰 페이지 이동
	@GetMapping("review")
	public String review() {
		log.info("review()");
		
		return "review";
	}
	
	//리뷰작성 페이지 이동
	@GetMapping("reviewWrite")
	public String reviewWrite() {
		log.info("reviewWrite()");
		
		return "reviewWrite";
	}
	
	//리뷰작성 처리 메서드 
	@PostMapping("rWriteProc")
	public String rWriteProc(@RequestPart List<MultipartFile> files, 
			ReviewDto review,
			HttpSession session,
			RedirectAttributes rttr) {
		log.info("rWriteProc()");
		
		String view = rServ.insertReview(files, review, session, rttr);
		return view;
	}

//	
//	
//	@GetMapping("reviewDetail")
//	public String reviewDetail(Model model, Integer reviewId, HttpSession session) {
//		log.info("reviewDetail()");
//		
//		ReviewDto reviewDto = rServ.getReview(reviewId);
//		
//		model.addAttribute("reviewDetail", reviewDto);
//		
//		return "reviewDetail";
//	}
}
