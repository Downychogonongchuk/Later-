package com.icia.later.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.icia.later.dto.BoardDto;

public interface BoardDao {

	// ByMemberId 페이징 // 내가 신청한 글 목록
	int getTotalgetBoardByMemberId(String memberId);

	// 모집글 목록 보기 // 내가 모집한 글 목록
	List<BoardDto> getBoardListBycustomerId(@Param("pMap") Map<String, Integer> pMap, Integer customerId);

	// 모집글 수 구하기
	@Select("SELECT count(*) FROM board")
	int cntBoard();

}