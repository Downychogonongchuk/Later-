package com.icia.later.dto;

public class PageMakerDTO {
	private int startPage; // ���� ������
	private int endPage; // �� ������
	private boolean prev; // ���� ������ ���� ����
	private boolean next; // ���� ������ ���� ����
	private int total; // ��ü �Խù� ��
	private Criteria cri; // ���� ������, �������� �Խù� ǥ�� �� ����

	public PageMakerDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;

		// ������ ������ ���
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
		// ���� ������ ���
		this.startPage = this.endPage - 9;

		// ��ü ������ ������ ���
		int realEnd = (int) (Math.ceil((double) total / cri.getAmount()));

		// ��ü ������ �������� ȭ�鿡 ���̴� ������ ���������� ���� ���, ���̴� ������ �� ����
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}

		// ���� ������ ���� 1���� ū ��� true
		this.prev = this.startPage > 1;

		// ������ ������ ���� 1���� ū ��� true
		this.next = this.endPage < realEnd;
	}

	// getter �� setter �޼���
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
