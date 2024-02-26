package com.icia.later.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

		
@Data
@Alias("board")
public class BoardDto {	
		 private int boardId;  
		 private String category; // ī�װ�
		 private String companyName; // ��ü��
		 private String periodStart; // ���� ���� 
		 private String periodEnd;  // ���� ����
		 private String personnel;  // ���� �ο� 
		 private int price; // ����
		 private String provideType; // ����Ÿ��
		 private String detail;  // �󼼼��� 
		 private String checkInfo;  // üũ����
		 private String boardFile; // �Խñ� ��ü���� 
		 private int customerId; //  ����� ���̵�  // �߰� dao controller
}
