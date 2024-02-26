package com.icia.later.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dao.ReviewDao;
import com.icia.later.dto.ReviewDto;

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
//	@Autowired
//	private ReviewDao rDao;
//	
//	public ReviewDto getReview(Integer reviewId) {
//		log.info("getReview()");
//		
//		ReviewDto reviewDto = rDao.getReview(reviewId);
//		
//		return reviewDto;
//	}

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

}
