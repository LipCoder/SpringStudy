package org.zerock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

// Controller의 예외처리 목적의 클래스
@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
	
	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {

		log.error("Exception ........." + ex.getMessage());
		
		// 에러를 뷰 화면에서도 보고 싶다면 model객체에 전달해줘야함
		model.addAttribute("exception", ex);
		log.error(model);
		
		return "error_page";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex) {
		return "custom404";
	}
	
}
