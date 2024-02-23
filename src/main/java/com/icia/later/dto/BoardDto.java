package com.icia.later.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("board")
public class BoardDto {
	private int boardId;
	private String periodStart; // ���� ����
	private String periodEnd; // ���� ����
	private String personnel; // ���� �ο�
	private String companyName; // ��ü��
	private String detail; // �󼼼���
	private String checkInfo; // üũ����
	private String provideType; // ����Ÿ��
	private int price; // ����
	private String boardfile; // �Խñ� ��ü����
}
