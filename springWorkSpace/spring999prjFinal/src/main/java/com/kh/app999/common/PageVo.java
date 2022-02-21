package com.kh.app999.common;

import lombok.Data;

@Data
public class PageVo {
	//�̸� �޾ƿ��ų� ��ȸ�ϴ� ����
	private int currentPage; // ���� ������
	private int cntPerPage; //���������� ������ row��
	private int pageBtnCnt; //������ ��ư � ��������
	private int totalRow; // ���̺��� ��ü row ����
	
	//����ؾ��ϴ� ����
	private int startRow; //��񰡼� ��ȸ�� rownum
	private int endRow; //��񰡼� ��ȸ�� rownum
	private int startPage; // ���� ������
	private int endPage; // ������ ������
	private int lastPage; // DB�� row �������� ������ �������� ������

	public PageVo(String currentPageStr, int cntPerPage, int pageBtnCnt, int totalRow) {
		this.currentPage = Integer.parseInt(currentPageStr);
		this.cntPerPage = cntPerPage;
		this.pageBtnCnt = pageBtnCnt;
		this.totalRow = totalRow;
		calc(currentPage, cntPerPage, pageBtnCnt, totalRow);
	}

	private void calc(int currentPage, int cntPerPage, int pageBtnCnt, int totalRow) {
		this.setEndRow(this.getCurrentPage() * this.getCntPerPage());
		this.setStartRow(this.getEndRow() - this.getCntPerPage() + 1);
		
		int lastPage = this.getTotalRow() / this.getCntPerPage();
		if(this.getTotalRow() / this.getCntPerPage() > 0) {
			lastPage++;
		}
		this.setLastPage(lastPage);
		
		int endPage = this.getCurrentPage() / this.getPageBtnCnt();
		if(this.getCurrentPage() % this.getPageBtnCnt() > 0) {
			endPage++;
		}
		
		//ȭ�鿡�� ó��
//		if(endPage > lastPage) {
//			endPage = lastPage;
//		}
		
		this.setEndPage(endPage * this.getPageBtnCnt());
		
		this.setStartPage(this.getEndPage() - this.getPageBtnCnt() + 1);
		
	}

}






