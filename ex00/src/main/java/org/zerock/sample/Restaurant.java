package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;


// 스프링은 관리가 필요한 객체(Bean)를 어노테이션 등을 이용해서 
// 객체를 생성하고 관리하는 일종의 '컨테이너'나 '팩토리'의 기능을 가지고 있다.

@Component // 스프링에서 관리해야 하는 대상임을 표현
@Data
public class Restaurant {

	// Restaurant 객체는 Chef 타입의 객체를 필요로 한다.
	// Autowired를 이용해 스프링에서 Chef 객체를 자동으로 관리할 수 있도록 한다.
	@Setter(onMethod_ = @Autowired)
	private Chef chef;
	
}
