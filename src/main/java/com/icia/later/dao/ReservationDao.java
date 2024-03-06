package com.icia.later.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.icia.later.dto.BoardDto;
import com.icia.later.dto.ReservationDto;

public interface ReservationDao {

	// 체험단 신청 정보 저장
	void insertReservation(ReservationDto reserv);
	
	//회원탈퇴시 모집신청도 삭제
	void deleteApplyCompany(Integer id);

	// 예약 목록 가져오기
	List<BoardDto> getBoardListBymemberId(@Param("pMap") Map<String, Integer> pMap);

	// 내가 예약한 업체 수 구하기
	int cntBoardByApplyList(Integer memberId11);
	
	// 신청한 업체 수 구하기
	@Select("SELECT count(*) FROM board")
	int cntBoard();

	// 에약 유무 확인 데이터 가져오기 // 신청 중복
	ReservationDto selectRev(@Param("pMap") Map<String, Integer> pMap);
	
	// 내 업체 신청한 사람 목록 가져오기
	List<ReservationDto> getReservationList(Integer boardId);

	// 신청 상태
	void updateStatus(@Param("pMap") Map<String, Object> pMap);
	
	// 업체 삭제 시 예약 삭제
	void deleteReservation(Integer boardId);

	// 로그인한 회원이 예약한 리스트 가져오기
	List<ReservationDto> getReservationListByMemberId(Integer memberId);

	
	
}