package com.icia.later.dao;

import java.util.List;
import java.util.Map;

import com.icia.later.dto.BoardDto;

public interface BoardDao {
	//게시글 목록 가져오기
		List<BoardDto> getBoardList(Map<String, Integer> pMap);
	
	
	
	//게시글 정보 상세보기
		BoardDto selectBoard(Integer boardId);
	
}
