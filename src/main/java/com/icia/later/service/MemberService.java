package com.icia.later.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

}