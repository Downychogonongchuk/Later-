package com.icia.later.service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
import com.icia.later.dao.ReservationDao;
import com.icia.later.dto.BoardDto;
import com.icia.later.util.PagingUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardService {
	// DAO
	@Autowired
	private BoardDao bDao;
	@Autowired
	private ReservationDao rDao;

	// 모집글 작성
	public String insertBoard(List<MultipartFile> files, BoardDto board, HttpSession session, RedirectAttributes rttr) {
		log.info("insertBoard()");
		String msg = null; // DB에 저장 성공/실패 관련 메세지 저장
		String view = null;// 대상 페이지 지정 변수
		String upFile = files.get(0).getOriginalFilename();
		// 업로드하는 파일의 이름을 추출.

		try {
			if (!upFile.equals("")) {
				FileUpload(files, session, board);
			}
			bDao.insertBoard(board);
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

	private void FileUpload(List<MultipartFile> files, HttpSession session, BoardDto board) throws Exception {
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
		board.setBoardFile(sysname);
	}

	public String boardUpdate(List<MultipartFile> files, BoardDto board, HttpSession session, RedirectAttributes rttr) {

		log.info("boardUpdate()");
		String msg = null;
		String view = null;
		String poster = board.getBoardFile();// 기존파일(포스터)

		try {
			if (!files.get(0).isEmpty()) {
				FileUpload(files, session, board);

				// 기존파일 삭제
				if (poster != null) {
					fileDelete(poster, session);
				}
			}
				bDao.updateBoard(board);
				System.out.println("mServ" + board);

				view = "redirect:/"; // + member.getMemberId();
				msg = "수정 성공";

			// 기존 파일 삭제
		} catch (Exception e) {
			e.printStackTrace();
			view = "redirect:bUpdate";// mUpdate?memberId=" + board.getBoardId();
			msg = "수정 실패";
		}

		rttr.addFlashAttribute("msg", msg);
		return view;
	}

	// 수정할 업체정보 가져오기
	public BoardDto getBoard(Integer boardId) {
		log.info("getBoard()");

		BoardDto board = bDao.selectBoard(boardId);

		return board;
	}

		//게시되어있는 모집글 전부 가져오는 메서드
		public List<BoardDto> getBoardList() {

		List<BoardDto> bList = bDao.getBoardList();

		return bList;
	}

		public String boardDelete(Integer boardId, Integer customerId, HttpSession session, RedirectAttributes rttr) {
		log.info("boardDelete()");
		String view = null;
		String msg = null;

		// 업체 코드로 파일명 구하기
		BoardDto board = bDao.selectBoard(boardId);
		String poster = board.getBoardFile();

		try {
			if (poster != null) {
				fileDelete(poster, session);
			}
			// 업체 삭제 시 예약 삭제
			rDao.deleteReservation(boardId);
			Map<String, Integer> pMap = new HashMap<String, Integer>();
			pMap.put("boardId", boardId);
			pMap.put("customerId", customerId);
			bDao.deleteBoard(pMap);
			view = "redirect:/";
			msg = "삭제 성공";
		} catch (Exception e) {
			e.printStackTrace();
			view = "redirect:/";
			msg = "삭제 실패";
		}

		rttr.addFlashAttribute("msg", msg);
		return view;
	}

	// 업체 사진 삭제
	private void fileDelete(String poster, HttpSession session) throws Exception {
		log.info("fileDelete()");

		String realPath = session.getServletContext().getRealPath("/");
		realPath += "resources/upload" + poster;
		File file = new File(realPath);
		if (file.exists()) {
			file.delete();
		}
	}

	// 업체 상세 가져오기
	public void getCompanyDetail(Integer boardId, Model model) {
		log.info("getCompanyDetail()");
		// DB에서 데이터 가져오기
		BoardDto board = bDao.selectBoard(boardId);
		// DB에서 데이터 가져오기
		model.addAttribute("board", board);

	}

	// 모집글 목록을 가져오기
	public String getBoardListBycustomerId(Integer pageNum, Model model, HttpSession session, Integer customerId) {
		log.info("getBoardListBycustomerId()");

		if (pageNum == null) {
			pageNum = 1;// 처음에 사이트가 열릴 때 첫페이지가 되도록 설정.
		}

		int listCnt = 5;// 페이지당 보여질 콘텐츠 개수

		Map<String, Integer> pMap = new HashMap<String, Integer>();

		pMap.put("pageNum", (pageNum - 1) * listCnt);
		pMap.put("listCnt", listCnt);
		pMap.put("customerId", customerId);

		List<BoardDto> bList = bDao.getBoardListBycustomerId(pMap, customerId);
		model.addAttribute("bList", bList);

		// 페이징 처리
		String pageHtml = getPagingBoardList(customerId, pageNum, listCnt);
		model.addAttribute("paging", pageHtml);
		session.setAttribute("pageNum", pageNum);

		return "companyList";
	}
	


	private String getPagingBoardList(Integer customerId, Integer pageNum, Integer listCnt) {
		String pageHtml = null;

		// 신청한 업체 개수
		int maxNum = bDao.cntBoardByBoardList(customerId);
		// 페이지 당 보여질 번호 개수
		int pageCnt = 5;

		String urlName = "companyList";
		
		PagingUtil paging = new PagingUtil(maxNum, pageNum, listCnt, pageCnt, urlName);
		pageHtml = paging.makePaging();

		return pageHtml;
	}
	
	//모집시작 날짜별로 리스트 가져오기
	public List<BoardDto> getComingList(Model model) {
	    log.info("getComingList()");
	    
	    // 현재 날짜와 시간을 가져옵니다.
	    LocalDateTime now = LocalDateTime.now();
	    
	    // DB에서 모든 게시글을 가져옵니다.
	    List<BoardDto> cbList = bDao.getComingList();
	    
	    // 아직 기간이 남은 게시글을 담을 리스트를 생성합니다.
	    List<BoardDto> comingList = new ArrayList<>();
	    
	    // 모든 게시글을 순회하며, periodStart가 현재 날짜와 시간보다 이후인 게시글을 찾습니다.
	    for (BoardDto board : cbList) {
	        // 문자열 형식의 periodStart를 LocalDateTime으로 변환합니다.
	        LocalDateTime periodStart = board.getPeriodStart();
	        
	        if (periodStart.isAfter(now)) {
	            comingList.add(board); // 아직 기간이 남은 게시글을 리스트에 추가합니다.
	        }
	    }
	    
	    return comingList;
	}

		// 업체 예약자 수 증가하는 메서드
		public void updateHits(Integer boardId, Integer hits) {
			log.info("updateHits()");
			
			Map<String, Integer> pMap = new HashMap<String, Integer>();
			pMap.put("boardId", boardId);
			pMap.put("hits", hits);
			bDao.updateHits(pMap);
		}

		// 카테고리 목록 가져오기
		public String getCategoryList(Integer cateNum, Integer pageNum, Model model, HttpSession session) {
			log.info("getCategoryList()");

			if (pageNum == null) {
				pageNum = 1; // 처음에 사이트가 열릴 때 첫페이지가 되도록 설정
			}

			int listCnt = 5; // 페이지당 보여질 콘텐츠 개수

			// 페이징을 위한 매개변수 설정
			Map<String, Integer> pMap = new HashMap<>();
			pMap.put("pageNum", (pageNum - 1) * listCnt);
			pMap.put("listCnt", listCnt);
			pMap.put("cateNum", cateNum);

			// DAO를 통해 카테고리 목록을 가져옴
			List<BoardDto> bList = bDao.getBoardListByCategory(pMap);

			// 게시글 목록 추가
			model.addAttribute("bList", bList);

			// 페이징 처리
			String pageHtml = getPagingByCategory(cateNum, pageNum, listCnt);
			model.addAttribute("pageHtml", pageHtml);
			model.addAttribute("pageNum", pageNum);

			return "category" + cateNum; // 해당 카테고리 페이지로 이동
		}

		// 카테고리별 페이징 처리 
		private String getPagingByCategory(Integer cateNum, Integer pageNum, int listCnt) {
			String pageHtml = null;
			// 카테고리별 개시글 개수
			int maxNum = bDao.cntBoardByCategory(cateNum);
			int pageCnt = 5; // 페이지당 보일 번호 개수

			String urlName = "category"; 

			PagingUtil paging = new PagingUtil(maxNum, pageNum, listCnt, pageCnt, urlName);
			pageHtml = paging.makePaging();

			return pageHtml;
		}
		// 전체 게시글 페이징 처리
		private String getPaging(Integer pageNum, Integer listCnt) {
			String pageHtml = null;

			int maxNum = bDao.cntBoard(); // 게시물 총 개수
			int pageCnt = 5; // 페이지당 보일 번호 개수

			// 전체 페이지 수
			PagingUtil paging = new PagingUtil(maxNum, pageCnt, maxNum, pageCnt, null);
			pageHtml = paging.makePaging();

			return pageHtml;
		}


}