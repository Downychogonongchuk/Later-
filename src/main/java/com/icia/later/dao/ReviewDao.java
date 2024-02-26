package com.icia.later.dao;

import com.icia.later.dto.ReviewDto;

public interface ReviewDao {

	void insertReview(ReviewDto review);

	//ReviewDto getReview(Integer reviewId);

}
