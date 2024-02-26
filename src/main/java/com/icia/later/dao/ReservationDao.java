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

	// ��û�� ��� ��������
	List<BoardDto> getBoardListBymemberId(@Param("pMap") Map<String, Integer> pMap, Integer memberId11);

	// ��û�� ��ü �� ���ϱ�
	@Select("SELECT count(*) FROM board")
	int cntBoard();
	
	
}
