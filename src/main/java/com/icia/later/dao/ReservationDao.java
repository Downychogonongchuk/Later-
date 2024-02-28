package com.icia.later.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.icia.later.dto.ReservationDto;

public interface ReservationDao {

	void insertReservation(ReservationDto reservationDto);

	ReservationDto selectRev(@Param("pMap") Map<String, Integer> pMap);

}
