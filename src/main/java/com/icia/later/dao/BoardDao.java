package com.icia.later.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.icia.later.dto.BoardDto;

public interface BoardDao {
	
	void insertBoard(BoardDto board);

	void updateBoard(BoardDto board);

	BoardDto selectBoard(Integer boardId);

	List<BoardDto> getBoardList();

	void deleteBoard(Integer boardId);
	
	// 모집글 수 구하기
	@Select("SELECT count(*) FROM board")	
	int cntBoard();

	List<BoardDto> getBoardListBycustomerId(@Param("pMap") Map<String, Integer> pMap);
	
}