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

import com.icia.later.dao.BoardDao;
import com.icia.later.dto.BoardDto;
import com.icia.later.util.PagingUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardService {
	@Autowired
	private BoardDao bDao;

	public String insertBoard(List<MultipartFile> files, BoardDto board, HttpSession session,
			RedirectAttributes rttr) {
		log.info("insertBoard()");
		String msg = null; // DB�� ���� ����/���� ���� �޼��� ����
		String view = null;// ��� ������ ���� ����
		String upFile = files.get(0).getOriginalFilename();
		// ���ε��ϴ� ������ �̸��� ����.

		try {
			if (!upFile.equals("")) {
				FileUpload(files, session, board);
			}
			bDao.insertBoard(board);
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

	private void FileUpload(List<MultipartFile> files, HttpSession session, BoardDto board) throws Exception {
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
		board.setBoardFile(sysname);
	}

	public String boardUpdate(List<MultipartFile> files, BoardDto board, HttpSession session, RedirectAttributes rttr) {
		
		log.info("boardUpdate()");
		String msg = null;
		String view = null;
		String poster = board.getBoardFile();// ��������(������)
		
		try {
			if (!files.get(0).isEmpty()) {
				FileUpload(files, session, board);

				// �������� ����
				if (poster != null) {
					fileDelete(poster, session);
				}
			}
			bDao.updateBoard(board);
			System.out.println("mServ" + board);

			view = "redirect:/"; // + member.getMemberId();
			msg = "���� ����";
			// ���� ���� ����
		} catch (Exception e) {
			e.printStackTrace();
			view = "redirect:bUpdate";//mUpdate?memberId=" + board.getBoardId();
			msg = "���� ����";
		}

		rttr.addFlashAttribute("msg", msg);
		return view;
	}
	
	//������ ��ü���� ��������
	public BoardDto getBoard(Integer boardId) {
		log.info("getBoard()");
		
		
		BoardDto board = bDao.selectBoard(boardId);
		
		return board;
	}

	public List<BoardDto> getBoardList() {
		
		List<BoardDto> bList = bDao.getBoardList();
		
		return bList;
	}
	
	public String boardDelete(Integer boardId, 
							  HttpSession session, 
							  RedirectAttributes rttr) {
		log.info("boardDelete()");
		String view = null;
		String msg = null;
		
		//��ü �ڵ�� ���ϸ� ���ϱ�
		BoardDto board = bDao.selectBoard(boardId);
		String poster = board.getBoardFile();
		
		try {
			if(poster != null) {
				fileDelete(poster, session);
			}
			bDao.deleteBoard(boardId);
			
			view = "redirect:/";
			msg = "���� ����";
		} catch (Exception e) {
			e.printStackTrace();
			view = "redirect:/";
			msg = "���� ����";
		}
		
		rttr.addFlashAttribute("msg", msg);
		return view;
	}
	// ��ü ���� ����
	private void fileDelete(String poster,
							HttpSession session) 
							throws Exception{
		log.info("fileDelete()");
		
		String realPath = session.getServletContext()
				.getRealPath("/");
		realPath += "resources/upload" + poster;
		File file = new File(realPath);
		if(file.exists()) {
			file.delete();
		}
	}

	public String getBoardListBycustomerId(Integer pageNum, Model model, HttpSession session, Integer customerId) {
		log.info("getBoardListBycustomerId()");
		System.out.println("cId"+customerId);
		
		if(pageNum == null) {
			pageNum = 1;//ó���� ����Ʈ�� ���� �� ù�������� �ǵ��� ����.
		}
		
		int listCnt = 5;//�������� ������ ������ ����
		
		Map<String, Integer> pMap = new HashMap<String, Integer>();
		
		pMap.put("pageNum", (pageNum - 1) * listCnt);
		pMap.put("listCnt", listCnt);
		pMap.put("customerId", customerId);
		
		List<BoardDto> bList = bDao.getBoardListBycustomerId(pMap);
		System.out.println("bList"+ bList);
		model.addAttribute("bList", bList);
		
		//����¡ ó��
		String pageHtml = getPaging(pageNum, listCnt);
		model.addAttribute("paging", pageHtml);
		
		session.setAttribute("pageNum", pageNum);
		
		return "companyList";
	}

	private String getPaging(Integer pageNum, int listCnt) {
		String pageHtml = null;
		
		//��û�� ��ü ����
		int maxNum = bDao.cntBoard();
		//������ �� ������ ��ȣ ����
		int pageCnt = 2;
		
		PagingUtil paging = new PagingUtil(maxNum, pageCnt, listCnt, pageCnt);
		
		pageHtml = paging.makePaging();
		
		return pageHtml;
	}


}