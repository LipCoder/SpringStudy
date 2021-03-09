package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	// InitBinder 사용 의도적인 형변환 처리
	/*
	 * @InitBinder public void InitBinder(WebDataBinder binder) { SimpleDateFormat
	 * dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	 * binder.registerCustomEditor(java.util.Date.class, new
	 * CustomDateEditor(dateFormat, false)); }
	 */
	
	@RequestMapping("")
	public void basic() {
		
		log.info("basic........................");
		
	}
	
	// Get,Post 방식 모두 사용가능
	@RequestMapping(value=  "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basticGet() {
		
		log.info("basic get...........................");
		
	}
	
	// Get 방식만 사용가능
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		
		log.info("basic get only get.......................");
		
	}
	
	//
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		
		log.info("" + dto);
		
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		
		log.info("name : " + name);
		log.info("age: " + age);
		
		return "ex2";
	}

	// 리스트, 배열 처리
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		
		log.info("ids: " + ids);
		
		return "ex02List";
	}
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids")String[] ids) {
		
		log.info("Array ids: " + Arrays.toString(ids));
		
		return "ex02Array";
	}
	
	// 객체 리스트 처리
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		
		log.info("list dtos: " + list);
		
		return "ex02Bean";
	}
	
	// InitBinder 사용 의도적인 형변환 처리
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		
		log.info("todo: " + todo);
		
		return "ex03";
	}
	
	// ModelAttribute 어노테이션
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		
		// SampleDTO는 Java Bean 규칙에 맞기 때문에 화면까지 알아서 전달된다.
		log.info("dto: " + dto);
		// Java Bean 규칙에 맞지 않는 타입은 Model 객체를 이용해 화면까지 전달해야한다.
		// ModelAttribute 사용필요
		log.info("page: " + page);
		
		
		return "/sample/ex04";
	}
	
	// Controller의 리턴 타입
	/*
		String : jsp를 이용하는 경우에는 jsp 파일의 경로와 파일이름을 나타내기 위해 사용
		
		void : 호출하는 URL과 동일한 이름의 jsp를 의미
		
		VO, DTO 타입 : 주로 JSON 타입의 데이터를 만들어 반환하는 용도로 사용

		ResponseEntity 타입 : response 할 때 Http 헤더 정보와 내용을 가공하는 용도로 사용
		
		Model, ModelAndView : Model로 데이터를 반환하거나 화면까지 같이 지정하는 경우에 사용 (최근 사용 X)
		
		HttpHeaders : 응답에 내용 없이 Http 헤더 메시지만 전달하는 용도로 사용
	*/
	
	// void 리턴 타입
	@GetMapping("/ex05")
	public void ex05() {
		log.info("/ex05............");
	}
	
	// 객체 리턴 타입 (JSON으로 변환하여 전달)
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06............");
		
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		
		return dto;
	}
	
	// ResponseEntity 타입
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		log.info("/ex07.............");
		
		String msg = "{\"name\": \"홍길동\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<String>(msg, header, HttpStatus.OK);
	}
	
	
	// 파일 업로드
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload...............");
	}
	
	// 업로드 처리
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		
		files.forEach(file -> {
			log.info("----------------------------------");
			log.info("name: " + file.getOriginalFilename() );
			log.info("size: " + file.getSize() );
			
		});
	}
	
}
