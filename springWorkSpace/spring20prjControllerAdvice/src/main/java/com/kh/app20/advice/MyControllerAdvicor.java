package com.kh.app20.advice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

//@ControllerAdvice(basePackages = "con.kh.app20.controller")
@ControllerAdvice(annotations = Controller.class)
public class MyControllerAdvicor {

	//감시할 대상
	//@GetMapping("member/join")
//	@ExceptionHandler(NullPointerException.class)
//	public String method01(NullPointerException e) {
//		System.out.println("======== npe =======");
//		e.printStackTrace();
//		return "error/npe";
//	}
//	
//	@ExceptionHandler(ArithmeticException.class)
//	public String method2(ArithmeticException e) {
//		System.out.println("======== zero =======");
//		e.printStackTrace();
//		return "error/zero";
//	}
//	
//	@ExceptionHandler(NumberFormatException.class)
//	public String method3(NumberFormatException e) {
//		System.out.println("======= number ======");
//		e.printStackTrace();
////		return "error/number";
//		return "error/number";
//	}
	
	//RuntimeException, Exception으로 한번에 처리
	@ExceptionHandler(Exception.class)
	public String method4(Exception e) {
		System.out.println("======= error ======");
		e.printStackTrace();
		return "error/error";
	}
	
	
}
