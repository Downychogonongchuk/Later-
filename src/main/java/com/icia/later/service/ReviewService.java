package com.icia.later.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dao.ReviewDao;
import com.icia.later.dto.CustomerDto;
import com.icia.later.dto.MemberDto;
import com.icia.later.dto.ReviewDto;
import com.icia.later.util.PagingUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReviewService {
	@Autowired
	private ReviewDao rDao;
	
	// 리뷰 작성 
	public String insertReview(List<MultipartFile> files, ReviewDto review, HttpSession session,
			RedirectAttributes rttr) {
		log.info("insertReview()");
		String msg = null; // DB에 저장 성공/실패 관련 메세지 저장
		String view = null;// 대상 페이지 지정 변수
		String upFile = files.get(0).getOriginalFilename();
		// 업로드하는 파일의 이름을 추출.

		try {
			if (!upFile.equals("")) {
				FileUpload(files, session, review);
			}
			rDao.insertReview(review);
			view = "redirect:/";
			msg = "작성 성공";
		} catch (Exception e) {// 저장 실패인 경우
			e.printStackTrace();
			view = "redirect:/";
			msg = "작성 실패";
		}
		rttr.addFlashAttribute("msg", msg);

		return view;
	}
	
	// 리뷰 정보 가져오기
	public void getReview(Integer reviewId, Model model) {
		log.info("getReview()");
		
		ReviewDto review = rDao.selectReview(reviewId);
		model.addAttribute("review", review);
	}
	
	// 리뷰 이미지 업로드
	private void FileUpload(List<MultipartFile> files, HttpSession session, ReviewDto review) throws Exception {
		log.info("fileUpload()");

		String sysname = null;// 변경하는 파일명
		String oriname = null;// 원래 파일명

		String realPath = session.getServletContext().getRealPath("/");
		log.info(realPath);
		realPath += "resources/upload/";
		File folder = new File(realPath);
//isDirectory() : 해당 이름이 폴더가 아니거나 존재하지않으면 false
		if (folder.isDirectory() == false) {
			folder.mkdir();// 폴더생성 메소드
		}

		MultipartFile mf = files.get(0);
		oriname = mf.getOriginalFilename();

		sysname = System.currentTimeMillis() + oriname.substring(oriname.lastIndexOf("."));

		File file = new File(realPath + sysname);

		mf.transferTo(file); // 하드디스크(경로상의 폴더)에 저장
		review.setReviewFile(sysname);
		
	}
	
	// 리뷰 정보 리스트 가져오기
	public String getReviewList(Integer pageNum, Model model, HttpSession session) {
		log.info("getReviewList()");
		
		if(pageNum == null) {
			pageNum = 1;
		}
		
		int listCnt = 10;
		
		Map<String, Integer> pMap = new HashMap<String, Integer>();
		pMap.put("pageNum", (pageNum - 1) * listCnt);
		pMap.put("listCnt", listCnt);
		
		
		List<ReviewDto> rList = rDao.getReviewList(pMap);
		model.addAttribute("rList", rList);
		
		// 로그인한 일반 회원 정보(2024-02-26)
		MemberDto mLogInInfo = (MemberDto) session.getAttribute("mLogin");
		// 로그인한 사업자 회원 정보(2024-02-26)
		CustomerDto cLogInInfo = (CustomerDto) session.getAttribute("cLogin");
	    // 로그인한 회원 정보를 모델에 추가하여 JSP로 전달
		model.addAttribute("mLogInInfo", mLogInInfo);
		// 로그인한 사업자 정보를 모델에 추가하여 JSP로 전달
		model.addAttribute("cLogInInfo", cLogInInfo);
		String pageHtml = getPaging(pageNum, listCnt);
		model.addAttribute("paging", pageHtml);
		return "review";
	}

	// 페이징
	private String getPaging(Integer pageNum, int listCnt) {
				String pageHtml = null;
		
				int maxNum = rDao.cntReview();
				
				int pageCnt = 2;
				
				PagingUtil paging = new PagingUtil(maxNum, pageNum, 
												listCnt, pageCnt, null);
				
				pageHtml = paging.makePaging();
				
				return pageHtml;
	}

}