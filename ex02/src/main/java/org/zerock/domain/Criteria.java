package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 검색의 기준

@Getter
@Setter
@ToString
public class Criteria {
	
	private int pageNum;
	private int amount;
	
	public Criteria() {
		this(1, 10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
