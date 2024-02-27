package com.icia.later.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.icia.later.dto.BoardDto;
import com.icia.later.dto.MemberDto;

public interface BoardDao {
	// �Խñ� ��� ��������
	List<BoardDto> getBoardList(Map<String, Integer> pMap);

	// �Խñ� ���� �󼼺���
	BoardDto selectBoard(Integer boardId);

	// �α���
	MemberDto login(BoardDto board);

	// ByMemberId ����¡
	int getTotalgetBoardByMemberId(String memberId);

	// ������ ��� ����
	List<BoardDto> getBoardListBycustomerId(Map<String, Integer> pMap, Integer customerId);

	// ������ �� ���ϱ�
	@Select("SELECT count(*) FROM board")
	int cntBoard();
	




}
