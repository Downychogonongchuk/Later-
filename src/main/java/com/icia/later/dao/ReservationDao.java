package com.icia.later.dao;


import java.util.List;

import com.icia.later.dto.ReservationDto;

public interface ReservationDao {
	
	// 체험단 신청 정보 저장
	void insertReservation(ReservationDto reserv); 
	

	
}
