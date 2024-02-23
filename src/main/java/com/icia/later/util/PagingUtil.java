package com.icia.later.util;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PagingUtil {
	private int totalNum;// 전체 글의 개수
	private int pageNum;// 현재 페이지 번호
	private int listCount;// 페이지당 나타낼 글의 개수
	private int pageCount;// 페이지그룹당 페이지 개수

	// 페이징용 html 코드를 만드는 메소드
	public String makePaging() {
		String pageStr = null;
		StringBuffer sb = new StringBuffer();

		// 1. 전체 페이지 개수 구하기
		int totalPage = (totalNum % listCount) > 0 ? totalNum / listCount + 1 : totalNum / listCount;

		// 2. 현재 페이지가 속해 있는 번호 그룹 구하기
		int curGroup = (pageNum % pageCount) > 0 ? pageNum / pageCount + 1 : pageNum / pageCount;

		// 3. 번호 그룹의 시작 번호
		int start = (curGroup * pageCount) - (pageCount - 1);

		// 4. 번호 그룹의 마지막 번호
		int end = (curGroup * pageCount) >= totalPage ? totalPage : curGroup * pageCount;

		// 5. 이전 버튼 처리
		if (start != 1) {
			sb.append("<a class='pno' href='./?pageNum=");
			sb.append((start - 1) + "'>");
			sb.append("◀</a>");
		}

		// 6. 중간 번호 버튼 처리
		for (int i = start; i <= end; i++) {
			if (pageNum != i) {// 현재 보이는 페이지가 아닌 경우
				sb.append("<a class='pno' href='./?pageNum=");
				sb.append(i + "'>" + i + "</a>");
			} else {// 현재 보이는 페이지인 경우
				sb.append("<font class='pno'>" + i + "</font>");
			}
		}

		// 7. 다음 버튼 처리
		if (end != totalPage) {
			sb.append("<a class='pno' href='./?pageNum=");
			sb.append((end + 1) + "'>");
			sb.append("▶</a>");
		}

		// StringBuffer에 저장된 내용을 문자열로 변환
		pageStr = sb.toString();

		return pageStr;
	}
}