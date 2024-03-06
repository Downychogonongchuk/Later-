package com.icia.later.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.icia.later.dto.ReviewDto;

public interface ReviewDao {
	
	// 리뷰 작성
	void insertReview(ReviewDto review);
	
	// 리뷰 정보 리스트 가져오기
	List<ReviewDto> getReviewList(Map<String, Integer> pMap);
	
	// 리뷰 정보 가져오기
	ReviewDto selectReview(Integer reviewId);
	
	// 리뷰 작성 갯수
	@Select("SELECT count(*) FROM review")
	int cntReview();

	// 멤버 탈퇴시 fk삭제용
	void deleteReview(int id);
	

}