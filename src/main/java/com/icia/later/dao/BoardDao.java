package com.icia.later.dao;

import java.util.List;
import java.util.Map;

import com.icia.later.dto.BoardDto;

public interface BoardDao {
	//�Խñ� ��� ��������
		List<BoardDto> getBoardList(Map<String, Integer> pMap);
	
	
	
	//�Խñ� ���� �󼼺���
		BoardDto selectBoard(Integer boardId);
	
}
