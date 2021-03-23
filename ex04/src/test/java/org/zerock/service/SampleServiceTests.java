package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class SampleServiceTests {

	@Setter(onMethod_ = @Autowired)
	private SampleService service;
	
	/*
	// Proxy 객체가 정상적으로 만들어졌는지 확인
	@Test
	public void testClass() {
		
		log.info(service);
		log.info(service.getClass().getName());
	}
	//-- 결과
	
	//INFO : org.zerock.service.SampleServiceTests - org.zerock.service.SampleServiceImpl@3b96c42e
	//INFO : org.zerock.service.SampleServiceTests - com.sun.proxy.$Proxy20 
	//											   ==> JDK의 다이나믹 프록시 기법이 적용된 결과

	@Test
	public void testAdd() throws Exception {
		
		log.info(service.doAdd("123", "456"));
	}
	
	
	*/
	@Test
	public void testAddError() throws Exception {
		log.info(service.doAdd("123", "456"));
	}

	
	
}
