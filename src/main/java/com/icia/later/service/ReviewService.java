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
	
	public String insertReview(List<MultipartFile> files, ReviewDto review, HttpSession session,
			RedirectAttributes rttr) {
		log.info("insertReview()");
		String msg = null; // DB�� ���� ����/���� ���� �޼��� ����
		String view = null;// ��� ������ ���� ����
		String upFile = files.get(0).getOriginalFilename();
		// ���ε��ϴ� ������ �̸��� ����.

		try {
			if (!upFile.equals("")) {
				FileUpload(files, session, review);
			}
			rDao.insertReview(review);
			view = "redirect:/";
			msg = "�ۼ� ����";
		} catch (Exception e) {// ���� ������ ���
			e.printStackTrace();
			view = "redirect:/";
			msg = "�ۼ� ����";
		}
		rttr.addFlashAttribute("msg", msg);

		return view;
	}

	public void getReview(Integer reviewId, Model model) {
		log.info("getReview()");
		
		ReviewDto review = rDao.selectReview(reviewId);
		System.out.println(review);
		model.addAttribute("review", review);
	}

	private void FileUpload(List<MultipartFile> files, HttpSession session, ReviewDto review) throws Exception {
		log.info("fileUpload()");

		String sysname = null;// �����ϴ� ���ϸ�
		String oriname = null;// ���� ���ϸ�

		String realPath = session.getServletContext().getRealPath("/");
		log.info(realPath);
		realPath += "resources/upload/";
		File folder = new File(realPath);
//isDirectory() : �ش� �̸��� ������ �ƴϰų� �������������� false
		if (folder.isDirectory() == false) {
			folder.mkdir();// �������� �޼ҵ�
		}

		MultipartFile mf = files.get(0);
		oriname = mf.getOriginalFilename();

		sysname = System.currentTimeMillis() + oriname.substring(oriname.lastIndexOf("."));

		File file = new File(realPath + sysname);

		mf.transferTo(file); // �ϵ��ũ(��λ��� ����)�� ����
		review.setReviewFile(sysname);
		
	}

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
		System.out.println(rList);
		model.addAttribute("rList", rList);
		
		// �α����� �Ϲ� ȸ�� ����(2024-02-26)
		MemberDto mLogInInfo = (MemberDto) session.getAttribute("mLogin");
		// �α����� ����� ȸ�� ����(2024-02-26)
		CustomerDto cLogInInfo = (CustomerDto) session.getAttribute("cLogin");
	    // �α����� ȸ�� ������ �𵨿� �߰��Ͽ� JSP�� ����
		model.addAttribute("mLogInInfo", mLogInInfo);
		// �α����� ����� ������ �𵨿� �߰��Ͽ� JSP�� ����
		model.addAttribute("cLogInInfo", cLogInInfo);
		String pageHtml = getPaging(pageNum, listCnt);
		model.addAttribute("paging", pageHtml);
		return "review";
	}

	private String getPaging(Integer pageNum, int listCnt) {
				String pageHtml = null;
		
				int maxNum = rDao.cntReview();
				
				int pageCnt = 2;
				
				PagingUtil paging = new PagingUtil(maxNum, pageNum, 
												listCnt, pageCnt);
				
				pageHtml = paging.makePaging();
				
				return pageHtml;
	}

}