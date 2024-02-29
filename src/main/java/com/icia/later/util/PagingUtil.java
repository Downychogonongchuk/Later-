package com.icia.later.util;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class PagingUtil {
	private int maxNum;//��ü ������ ���� ���� ����
	private int pageNum;//���� ���̴� �������� ��ȣ ���� ����
	private int listCnt;//�� ������ �� ���� ������ ���� ���� ����
	private int pageCnt;//������ ������ ��ȣ ���� ���� ����
	
	//����¡�� html �ڵ带 ����� �޼ҵ�
	public String makePaging() {
		String pageStr = null;
		StringBuffer sb = new StringBuffer();
		
		//1. ��ü ������ ���� ���ϱ�
		// ��ü ������ ���� 5, ������ 5���� ���
		int totalPage = (maxNum % listCnt) > 0 ?
				maxNum / listCnt + 1 :
				maxNum / listCnt;
		
		//2. ���� �������� ���� �ִ� ��ȣ �׷� ���ϱ�
		int curGroup = (pageNum % pageCnt) > 0 ?
				pageNum / pageCnt + 1 :
				pageNum / pageCnt;
		
		//3. ��ȣ �׷��� ���� ��ȣ
		int start = (curGroup * pageCnt) - (pageCnt - 1);
		//�ι�° �׷� ���۹�ȣ : 2 * pageCnt(5) - (5 - 1) = 6  
		
		//4. ��ȣ �׷��� ������ ��ȣ
		int end = (curGroup * pageCnt) >= totalPage ?
				totalPage : curGroup * pageCnt;
		//�ι�° �׷� ��������ȣ : 2 * pageCnt(5) = 10 
		
		//5. ���� ��ư ó��
		if(start != 1) {
			sb.append("<a class='pno' href='./?pageNum=");
			sb.append((start - 1) + "'>");
			sb.append("��</a>");
		}//<a class='pno' href='./?pageNum=5'>��</a>
		
		//6. �߰� ��ȣ ��ư ó��
		for(int i = start; i <= end; i++) {
			if(pageNum != i){//���� ���̴� �������� �ƴ� ���
				sb.append("<a class='pno' href='./?pageNum=");
				sb.append(i + "'>" + i + "</a>");
			}//<a class='pno' href='./?pageNum=2'>2</a>
			else {//���� ���̴� �������� ���
				sb.append("<font class='pno'>" + i + "</font>");
			}//<font class='pno'>3</font>
		}
		
		//7. ���� ��ư ó��
		if(end != totalPage) {
			sb.append("<a class='pno' href='./?pageNum=");
			sb.append((end + 1) + "'>");
			sb.append("��</a>");
		}//<a class='pno' href='./?pageNum=6'>��</a>
		
		//StringBuffer�� ����� ������ ���ڿ��� ��ȯ
		pageStr = sb.toString();
		
		return pageStr;
	}
}
