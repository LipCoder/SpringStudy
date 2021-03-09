package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)	// 현재 테스트 코드가 스프링을 실행하는 역할을 할것이다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 필요한 객체들을 등록
@Log4j // Lombok을 이용해서 로그를 기록하는 Logger 변로 생성
public class SampleTests {
	
	// @Autowired : 스프링에서 자동으로 주입해달라는 표시
	@Setter(onMethod_ = { @Autowired })
	private Restaurant restaurant;
	
	// JUnit에서 테스트 대상을 표시
	@Test
	public void testExist() {
		
		// 해당 매개변수(restaurant)가 null이 아니어야만 테스트가 성공
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("--------------------------------------");
		log.info(restaurant.getChef());
	}
	
}
