package com.kh.app999.advicor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(annotations = Controller.class)
public class ErrorProcessor {

	@ExceptionHandler(Exception.class)
	public String errorProcess() {
		return "error/exception";
	}
	
}
