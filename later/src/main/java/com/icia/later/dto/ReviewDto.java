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
	 private Integer reviewId;
	 private String reviewFile;
	 private String time;
	 private String contents;
	 private Integer memberId;
	 private Integer boardId;
}