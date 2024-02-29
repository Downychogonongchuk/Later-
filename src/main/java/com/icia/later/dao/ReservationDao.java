package com.icia.later.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.icia.later.dto.BoardDto;
import com.icia.later.dto.ReservationDto;

public interface ReservationDao {

	// ü��� ��û ���� ����
	void insertReservation(ReservationDto reserv);

	// ���� ��� ��������
	List<BoardDto> getBoardListBymemberId(@Param("pMap") Map<String, Integer> pMap);

	// ��û�� ��ü �� ���ϱ�
	@Select("SELECT count(*) FROM board")
	int cntBoard();

	// ���� ���� Ȯ�� ������ ��������
	ReservationDto selectRev(@Param("pMap") Map<String, Integer> pMap);
	
	
}