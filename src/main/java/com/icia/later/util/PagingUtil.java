package com.icia.later.util;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PagingUtil {
	private int totalNum;// ��ü ���� ����
	private int pageNum;// ���� ������ ��ȣ
	private int listCount;// �������� ��Ÿ�� ���� ����
	private int pageCount;// �������׷�� ������ ����

	// ����¡�� html �ڵ带 ����� �޼ҵ�
	public String makePaging() {
		String pageStr = null;
		StringBuffer sb = new StringBuffer();

		// 1. ��ü ������ ���� ���ϱ�
		int totalPage = (totalNum % listCount) > 0 ? totalNum / listCount + 1 : totalNum / listCount;

		// 2. ���� �������� ���� �ִ� ��ȣ �׷� ���ϱ�
		int curGroup = (pageNum % pageCount) > 0 ? pageNum / pageCount + 1 : pageNum / pageCount;

		// 3. ��ȣ �׷��� ���� ��ȣ
		int start = (curGroup * pageCount) - (pageCount - 1);

		// 4. ��ȣ �׷��� ������ ��ȣ
		int end = (curGroup * pageCount) >= totalPage ? totalPage : curGroup * pageCount;

		// 5. ���� ��ư ó��
		if (start != 1) {
			sb.append("<a class='pno' href='./?pageNum=");
			sb.append((start - 1) + "'>");
			sb.append("��</a>");
		}

		// 6. �߰� ��ȣ ��ư ó��
		for (int i = start; i <= end; i++) {
			if (pageNum != i) {// ���� ���̴� �������� �ƴ� ���
				sb.append("<a class='pno' href='./?pageNum=");
				sb.append(i + "'>" + i + "</a>");
			} else {// ���� ���̴� �������� ���
				sb.append("<font class='pno'>" + i + "</font>");
			}
		}

		// 7. ���� ��ư ó��
		if (end != totalPage) {
			sb.append("<a class='pno' href='./?pageNum=");
			sb.append((end + 1) + "'>");
			sb.append("��</a>");
		}

		// StringBuffer�� ����� ������ ���ڿ��� ��ȯ
		pageStr = sb.toString();

		return pageStr;
	}
}