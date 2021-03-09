package org.zerock.domain;


import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private Long BNO;
	private String TITLE;
	private String CONTENT;
	private String WRITER;
	private Date REGDATE;
	private Date UPDATEDATE;

}
