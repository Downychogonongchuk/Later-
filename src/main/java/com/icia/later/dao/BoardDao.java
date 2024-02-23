package com.icia.later.dao;

import java.util.List;
import java.util.Map;

import com.icia.later.dto.BoardDto;
import com.icia.later.dto.MemberDto;

public interface BoardDao {
	//�Խñ� ��� ��������
		List<BoardDto> getBoardList(Map<String, Integer> pMap);
	
	
	
	//�Խñ� ���� �󼼺���
		BoardDto selectBoard(Integer boardId);


	//���� ��û�� ��ü ��Ϻ���
		BoardDto applyCompany(Integer boardId);


	// �α��� 
		MemberDto login(BoardDto board);
	
}