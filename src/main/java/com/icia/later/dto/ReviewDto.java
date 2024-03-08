package com.icia.later.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("review")
public class ReviewDto {
	 private int reviewId;
	 private String reviewFile;
	 private String reviewTitle;
	 private String time;
	 private String reviewLink;
	 private String contents;
	 private int memberId;
	 private int boardId;
}