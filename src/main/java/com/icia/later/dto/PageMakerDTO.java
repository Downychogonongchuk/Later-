package com.icia.later.dto;

public class PageMakerDTO {
	private int startPage; // 시작 페이지
	private int endPage; // 끝 페이지
	private boolean prev; // 이전 페이지 존재 유무
	private boolean next; // 다음 페이지 존재 유무
	private int total; // 전체 게시물 수
	private Criteria cri; // 현재 페이지, 페이지당 게시물 표시 수 정보

	public PageMakerDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;

		// 마지막 페이지 계산
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
		// 시작 페이지 계산
		this.startPage = this.endPage - 9;

		// 전체 마지막 페이지 계산
		int realEnd = (int) (Math.ceil((double) total / cri.getAmount()));

		// 전체 마지막 페이지가 화면에 보이는 마지막 페이지보다 작은 경우, 보이는 페이지 값 조정
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}

		// 시작 페이지 값이 1보다 큰 경우 true
		this.prev = this.startPage > 1;

		// 마지막 페이지 값이 1보다 큰 경우 true
		this.next = this.endPage < realEnd;
	}

	// getter 및 setter 메서드
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
}
