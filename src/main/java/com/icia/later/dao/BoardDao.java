package com.icia.later.dao;


import java.util.List;

import com.icia.later.dto.BoardDto;

public interface BoardDao {
	
	void insertBoard(BoardDto board);

	void updateBoard(BoardDto board);

	BoardDto selectBoard(Integer boardId);

	List<BoardDto> getBoardList();

	void deleteBoard(Integer boardId);
	
}