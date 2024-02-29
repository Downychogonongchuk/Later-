package com.icia.later.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.icia.later.dto.ReviewDto;

public interface ReviewDao {

	void insertReview(ReviewDto review);

	List<ReviewDto> getReviewList(Map<String, Integer> pMap);

	ReviewDto selectReview(Integer reviewId);
	
	@Select("SELECT count(*) FROM review")
	int cntReview();

}