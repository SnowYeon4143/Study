package com.kh.app999.advicor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice(annotations = Controller.class)
@Slf4j
public class ErrorProcessor {

	@ExceptionHandler(Exception.class)
	public String errorProcess(Exception e) {
		
		//서버도 예외를 알게하기
		log.error(e.getMessage());
		e.printStackTrace();
		return "error/exception";
	}
	
}
