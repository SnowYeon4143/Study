package com.kh.app25.member.advicor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice(annotations = Controller.class)
//@ControllerAdvice(basePackages = "com.kh.app25.member.controller")
@Slf4j
public class MemberErrorProcessor {
	
	@ExceptionHandler(Exception.class)
	public String exceptionProcess(Exception e) {
		log.error("��Ʈ�ѷ� ��򰡿��� ���� �߻���\n{}\n", e.getMessage());
		return "common/error/exception";
	}
}
