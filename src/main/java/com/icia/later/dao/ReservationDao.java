package com.icia.later.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.icia.later.dto.BoardDto;
import com.icia.later.dto.ReservationDto;

public interface ReservationDao {

	void insertReservation(ReservationDto reservationDto);

	ReservationDto selectRev(@Param("pMap") Map<String, Integer> pMap);

	List<BoardDto> getBoardListBymemberId(@Param("pMap") Map<String, Integer> pMap);
	
	@Select("SELECT count(*) FROM board")
	int cntBoard();

	List<ReservationDto> getReservationList(Integer boardId);

	void updateStatus(Map<String, Object> pMap);

}