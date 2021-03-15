package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total;
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		
		this.cri = cri;
		this.total = total;
		
		// 첫 페이지를 쉽게 구할 수 있게
		// 마지막 페이지를 먼저 구한다.
		this.endPage = (int) (Math.ceil(cri.getPageNum() /  10.0)) * 10;
		this.startPage = this.endPage - 9;
		
		// 총 게시물 수에 따른 페이지 수를 구한다.
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
		
		// 총 게시물 수가 10페이지를 넘지 않는 경우
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
	
}
