package com.icia.later.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("board")
public class BoardDto {
	private int boardId;
    private String category;
    private String companyName;
    private String periodStart; 
    private String periodEnd; 
    private int personnel; 
    private int price; 
    private String provideType; 
    private String detail; 
    private String checkInfo;  
    private String BoardFile; 
    private int customerId; 
}
