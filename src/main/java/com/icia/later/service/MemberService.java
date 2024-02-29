package com.icia.later.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.text.View;

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
	
	public String mEmailCheck(String memberEmailCheck) {
		log.info("memberEmailCheck()");
		int cnt = mDao.checkDuplicateId(memberEmailCheck);

		String res = null;
		if (cnt > 0) {
			// ���̵� ����
			res = "fail";
		} else {
			// ���̵� ����
			res = "ok";
		}

		return res;
	}
	
	public String insertMember(List<MultipartFile> files, MemberDto member, HttpSession session,
			RedirectAttributes rttr) {
		log.info("insertMember()");
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
			msg = "���� ����";
		} catch (Exception e) {// ���� ������ ���
			e.printStackTrace();
			view = "redirect:/";
			msg = "���� ����";
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
		member.setMemberProfile(sysname);
	}

	// �Ϲ�ȸ�� �α��α��
	public String mLogin(MemberDto member, HttpSession session, RedirectAttributes rttr) {
		log.info("mLogin()");
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

	// �α׾ƿ� ó��
		public String logout(HttpSession session, RedirectAttributes rttr) {
			log.info("logout()");
			String msg = "�α׾ƿ� ����";

			session.removeAttribute("mLogin");

			rttr.addFlashAttribute("msg", msg);
			return "redirect:/";
		}

	// �󼼺��� ó�� �޼ҵ�
	public void getMember(Integer memberId, Model model, HttpSession session) {
		log.info("getMember()");
		// DB���� ������ ��������
		session.setAttribute("", session);
		MemberDto member = mDao.selectMember(memberId);
		// model�� ���
		model.addAttribute("member", member);
	}

	// ȸ������ ���� ó��
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
					mFileDelete(poster, session);
				}
			}
			mDao.updateMember(member);
			System.out.println("mServ" + member);

			view = "redirect:/"; 
			msg = "���� ����";
			// ���� ���� ����
		} catch (Exception e) {
			e.printStackTrace();
			view = "redirect:/";
			msg = "���� ����";
		}

		rttr.addFlashAttribute("msg", msg);
		return view;
	}

	// ���� ���ε��̹��� ���� ó�� �޼���
	private void mFileDelete(String poster, HttpSession session) throws Exception {
		log.info("fileDelete()");

		String realPath = session.getServletContext().getRealPath("/");
		realPath += "resouces/upload/" + poster;
		File file = new File(realPath);
		if (file.exists()) {
			file.delete();
		}

	}
	// ȸ�� Ż�� �޼���
	public String mDelete(Integer memberId, HttpSession session, RedirectAttributes rttr) {
		log.info("mDelete()");
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

	// �Ϲ�ȸ�� �̸���ã��
	public String mFindById(MemberDto member, Model model, RedirectAttributes rttr) {
	    log.info("mFindById()");
	    System.out.println(member);
	    String msg = null;
	    MemberDto EmailResult = mDao.FindById(member);
	    System.out.println(EmailResult);
	    
	    if(EmailResult == null) {
	        msg = "���Ե� ������ �����ϴ� �ٽ� Ȯ�����ּ���.";
	        rttr.addFlashAttribute("msg", msg);
	        return "redirect:/mFindById";
	    } else {
	        model.addAttribute("EmailResult", EmailResult);
	        return "mFindById";
	    }
	}
	
	// �Ϲ�ȸ�� ��й�ȣã��
		public String mFindByPass(MemberDto member, Model model, RedirectAttributes rttr) {
		    log.info("mFindByPass()");
		    System.out.println(member);
		    String msg = null;
		    MemberDto PassResult = mDao.FindByPass(member);
		    System.out.println(PassResult);
		    
		    if(PassResult == null) {
		        msg = "���Ե� ������ �����ϴ� �ٽ� Ȯ�����ּ���.";
		        rttr.addFlashAttribute("msg", msg);
		        return "redirect:/mFindByPass";
		    } else {
		        model.addAttribute("PassResult", PassResult);
		        return "mPassUpdate";
		    }
		}
		
		//�Ϲ�ȸ�� ��й�ȣ ó�� �޼���
		public String mUpdatePassProc(MemberDto member,RedirectAttributes rttr) {
			log.info("mUpdatePassProc()");
			System.out.println(member);
			String msg = null;
			String view = null;
			mDao.mUpdatePassProc(member);
			
			
			msg = "������ �Ϸ�Ǿ����ϴ� �α��� �� �̿����ּ���";
			view = "redirect:/mLogin";
			rttr.addFlashAttribute("msg", msg);
			
			return view;
		}

}