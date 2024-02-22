package com.icia.later.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("board")
public class BoardDto {
	private int boardId;
	private String periodStart;
	private String periodEnd;
	private int personnel;
	private String companyName;
	private String detail;
	private String checkInfo;
	private String provideType;
	private int price;
	private String boardFile;
}