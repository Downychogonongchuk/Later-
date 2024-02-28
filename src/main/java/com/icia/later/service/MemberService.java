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
		String msg = null; // DB�� ���� ����/���� ���� �޼��� ����
		String view = null;// ��� ������ ���� ����
		String upFile = files.get(0).getOriginalFilename();
		// ���ε��ϴ� ������ �̸��� ����.

		try {
			if (!upFile.equals("")) {
				FileUpload(files, session, member);
			}
			mDao.insertMember(member);
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

	private void FileUpload(List<MultipartFile> files, HttpSession session, MemberDto member) throws Exception {
		log.info("fileUpload()");

		String sysname = null;// �����ϴ� ���ϸ�
		String oriname = null;// ���� ���ϸ�

		String realPath = session.getServletContext().getRealPath("/");
		log.info(realPath);
		realPath += "/resources/upload/";
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
		member.setMemberProfile(sysname);
	}

	public String login(MemberDto member, HttpSession session, RedirectAttributes rttr) {
		log.info("login2()");
		String msg = null;
		String view = null;
		MemberDto loggedInMember = mDao.login(member);
		System.out.println(loggedInMember);
		
		if (loggedInMember != null) {
			msg = "�α��� ����";
			view = "redirect:/";

			System.out.println(loggedInMember);
			// �α��ν� ���ǿ� ����
			session.setAttribute("mLogin", loggedInMember);
			System.out.println(loggedInMember);

		} else {
			msg = "�̸��� �� ��й�ȣ�� �ٽ� Ȯ�����ּ���.";
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
		String poster = member.getMemberProfile();// ��������(������)
		
		try {
			if (!files.get(0).isEmpty()) {
				FileUpload(files, session, member);

				// �������� ����
				if (poster != null) {
					FileDelete(poster, session);
				}
			}
			mDao.updateMember(member);
			System.out.println("mServ" + member);

			view = "redirect:/"; // + member.getMemberId();
			msg = "���� ����";
			// ���� ���� ����
		} catch (Exception e) {
			e.printStackTrace();
			view = "redirect:mUpdate?memberId=" + member.getMemberId();
			msg = "���� ����";
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
				msg = "Ż�� ����";
			}

			// ���� ���� ����
		} catch (Exception e) {
			e.printStackTrace();
			view = "redirect:/";// + member.getMemberId();
			msg = "Ż�� ����";
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