package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	
	private String title;
	
	// InitBinder 말고도 DateTimeFormat을 사용하여 
	// Date 형식으로 자동 변환이 가능하다.
	// 이 경우에는 InitBinder 설정은 필요 없다.
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dueDate;
	
	
}
