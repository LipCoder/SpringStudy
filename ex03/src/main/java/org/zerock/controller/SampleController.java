package org.zerock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

import lombok.extern.log4j.Log4j;

//REST는 순수한 데이터를 보내는 것!
@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}
	
	// 객체 반환
	@GetMapping(value = "/getSample", 
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, 
						MediaType.APPLICATION_XML_VALUE }) 
	// XML과 JSON 방식의 데이터를 생성할 수 있도록 작성
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}
	
	// produces는 생략 가능
	@GetMapping(value = "/getSample2", produces = {MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample2() {
		return new SampleVO(112, "스타", "로드");
	}
	
	// 컬렉션 타입의 객체 반환
	@GetMapping(value = "/getList")
	public List<SampleVO> getList() {
		return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, i + "First", i + "Last"))
				.collect(Collectors.toList());
	}
	
	@GetMapping(value = "/getMap")
	public Map<String, SampleVO> getMap() {

		Map<String, SampleVO> map = new HashMap<>();
		map.put("First", new SampleVO(111, "그루트", "주니어"));
		
		return map;
	}
	
	// ResponseEntity 타입을 사용하면 기존 데이터와 함께
	// HTTP 헤더 상태 데이터도 전달 가능
	@GetMapping(value = "/check", params = {"height", "weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight) {
		
		SampleVO vo = new SampleVO(0, "" + height, "" + weight);
		
		ResponseEntity<SampleVO> result = null;
		
		if(height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
	}
	
	// @RestController에서 파라미터
	// @PathVariable
	// 기존 방식의 파라미터를 가져오는 
	// 쿼리 스트링 방식보다 간편하다.
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(
			@PathVariable("cat") String cat,
			@PathVariable("pid") String pid) {
		
		return new String[] {"category: " + cat, "productid: " + pid};
	}
	
	// @RequestBody
	// 요청한 내용(JSON 등)을 해당 파라미터 타입으로 바꾼다.
	
	// 요청한 내용을 처리하기 때문에 
	// 일반적인 파라미터 전달방식을 사용할 수 없음
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		
		log.info("convert.......ticket" + ticket);
		
		return ticket;
	}
}


















