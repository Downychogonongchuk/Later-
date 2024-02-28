package com.icia.later.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dao.MemberDao;
import com.icia.later.dto.MemberDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService {
	@Autowired
	private MemberDao mDao;

	public String insertMember(List<MultipartFile> files, MemberDto member, HttpSession session,
			RedirectAttributes rttr) {
		log.info("insertMovie()");
		String msg = null; // DB에 저장 성공/실패 관련 메세지 저장
		String view = null;// 대상 페이지 지정 변수
		String upFile = files.get(0).getOriginalFilename();
		// 업로드하는 파일의 이름을 추출.

		try {
			if (!upFile.equals("")) {
				FileUpload(files, session, member);
			}
			mDao.insertMember(member);
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

	private void FileUpload(List<MultipartFile> files, HttpSession session, MemberDto member) throws Exception {
		log.info("fileUpload()");

		String sysname = null;// 변경하는 파일명
		String oriname = null;// 원래 파일명

		String realPath = session.getServletContext().getRealPath("/");
		log.info(realPath);
		realPath += "/resources/upload/";
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
		member.setMemberProfile(sysname);
	}

	public String login(MemberDto member, HttpSession session, RedirectAttributes rttr) {
		log.info("login2()");
		String msg = null;
		String view = null;
		MemberDto loggedInMember = mDao.login(member);
		System.out.println(loggedInMember);
		
		if (loggedInMember != null) {
			msg = "로그인 성공";
			view = "redirect:/";

			System.out.println(loggedInMember);
			// 로그인시 세션에 저장
			session.setAttribute("mLogin", loggedInMember);
			System.out.println(loggedInMember);

		} else {
			msg = "이메일 및 비밀번호를 다시 확인해주세요.";
			view = "redirect:mLogin";
		}

		rttr.addFlashAttribute("msg", msg);
		System.out.println(msg);

		return view;
	}

	public String memberUpdate(List<MultipartFile> files, MemberDto member, HttpSession session,
			RedirectAttributes rttr) {
		log.info("memberUpdate()");
		String msg = null;
		String view = null;
		String poster = member.getMemberProfile();// 기존파일(포스터)
		
		try {
			if (!files.get(0).isEmpty()) {
				FileUpload(files, session, member);

				// 기존파일 삭제
				if (poster != null) {
					FileDelete(poster, session);
				}
			}
			mDao.updateMember(member);
			System.out.println("mServ" + member);

			view = "redirect:/"; // + member.getMemberId();
			msg = "수정 성공";
			// 기존 파일 삭제
		} catch (Exception e) {
			e.printStackTrace();
			view = "redirect:mUpdate?memberId=" + member.getMemberId();
			msg = "수정 실패";
		}

		rttr.addFlashAttribute("msg", msg);
		return view;
	}

	private void FileDelete(String poster, HttpSession session) {
		String realPath = session.getServletContext().getRealPath("/");
		realPath += "resources/upload/" + poster;
		File file = new File(realPath);
		if (file.exists()) {
			file.delete();
		}
		
	}

	public String mDelete(Integer memberId, HttpSession session, RedirectAttributes rttr) {
		String msg = null;
		String view = null;
		MemberDto loginInfo = (MemberDto) session.getAttribute("mLogin");
		int id = loginInfo.getMemberId();

		try {
			if (loginInfo != null) {
				mDao.deleteMember(id);
				System.out.println("mServ" + id);

				view = "redirect:/"; // + member.getMemberId();
				msg = "탈퇴 성공";
			}

			// 기존 파일 삭제
		} catch (Exception e) {
			e.printStackTrace();
			view = "redirect:/";// + member.getMemberId();
			msg = "탈퇴 실패";
		}

		rttr.addFlashAttribute("msg", msg);
		return view;
	}

	public void getMember(Integer memberId, Model model) {
		log.info("getMember()");
		
		MemberDto member = mDao.selectMember(memberId);
		System.out.println(member);
		model.addAttribute("member", member);
		
	}

}