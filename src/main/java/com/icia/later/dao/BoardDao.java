package com.icia.later.dao;

import java.util.List;
import java.util.Map;

import com.icia.later.dto.BoardDto;
import com.icia.later.dto.MemberDto;

public interface BoardDao {
	// 게시글 목록 가져오기
	List<BoardDto> getBoardList(Map<String, Integer> pMap);

	// 게시글 정보 상세보기
	BoardDto selectBoard(Integer boardId);

	// 로그인
	MemberDto login(BoardDto board);

	// 예약 목록보기
	List<BoardDto> getBoardListByMemberId(String memberId, int offset, int pageSize);

	// ByMemberId 페이징
	int getTotalgetBoardByMemberId(String memberId);
	




}
