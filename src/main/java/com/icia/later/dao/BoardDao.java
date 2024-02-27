package com.icia.later.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.icia.later.dto.BoardDto;
import com.icia.later.dto.MemberDto;

public interface BoardDao {
	// 게시글 목록 가져오기
	List<BoardDto> getBoardList(Map<String, Integer> pMap);

	// 게시글 정보 상세보기
	BoardDto selectBoard(Integer boardId);

	// 로그인
	MemberDto login(BoardDto board);

	// ByMemberId 페이징
	int getTotalgetBoardByMemberId(String memberId);

	// 모집글 목록 보기
	List<BoardDto> getBoardListBycustomerId(Map<String, Integer> pMap, Integer customerId);

	// 모집글 수 구하기
	@Select("SELECT count(*) FROM board")
	int cntBoard();
	




}
