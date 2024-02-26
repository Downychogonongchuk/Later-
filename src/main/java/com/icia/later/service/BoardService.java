package com.icia.later.service;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dao.BoardDao;
import com.icia.later.dto.BoardDto;
import com.icia.later.dto.MemberDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardService {
	// DAO
		@Autowired
		private BoardDao bDao;

		public void getCompanyDetail(Integer boardId,Model model) {
			log.info("getCompanyDetail()");
			//DB에서 데이터 가져오기
			BoardDto board = bDao.selectBoard(boardId);
			//DB에서 데이터 가져오기
			model.addAttribute("board", board);
			System.out.println(model);
			
		}

		

		
//		public String insertboard(List<MultipartFile> files, reservationDto board, HttpSession session,
//				RedirectAttributes rttr) {
//			log.info("insertboard()");
//			String msg = null; // DB에 저장 성공/실패 관련 메세지 저장
//			String view = null;// 대상 페이지 지정 변수
//			String upFile = files.get(0).getOriginalFilename();
//			// 업로드하는 파일의 이름을 추출.
//
//			try {
//				if (!upFile.equals("")) {
//					FileUpload(files, session, board);
//				}
//				bDao.insertboard(board);
//				view = "redirect:/";
//				msg = "가입 성공";
//			} catch (Exception e) {// 저장 실패인 경우
//				e.printStackTrace();
//				view = "redirect:/";
//				msg = "가입 실패";
//			}
//			rttr.addFlashAttribute("msg", msg);
//
//			return view;
//		}
//
//		private void FileUpload(List<MultipartFile> files, HttpSession session, reservationDto reserv) throws Exception {
//			log.info("fileUpload()");
//
//			String sysname = null;// 변경하는 파일명
//			String oriname = null;// 원래 파일명
//
//			String realPath = session.getServletContext().getRealPath("/");
//			log.info(realPath);
//			realPath += "resources/upload/";
//			File folder = new File(realPath);
//			// isDirectory() : 해당 이름이 폴더가 아니거나 존재하지않으면 false
//			if (folder.isDirectory() == false) {
//				folder.mkdir();// 폴더생성 메소드
//			}
//
//			MultipartFile mf = files.get(0);
//			oriname = mf.getOriginalFilename();
//
//			sysname = System.currentTimeMillis() + oriname.substring(oriname.lastIndexOf("."));
//
//			File file = new File(realPath + sysname);
//
//			mf.transferTo(file); // 하드디스크(경로상의 폴더)에 저장
//			member.setMemberProfile(sysname);
//		}

		
}
