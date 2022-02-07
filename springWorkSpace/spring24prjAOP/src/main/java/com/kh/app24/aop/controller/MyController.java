package com.kh.app24.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app24.aop.service.MyService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/my")
public class MyController {
	
	@Autowired
	private MyService service;
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		log.info("test method called...");
		service.test();
		
		return "test ~~~~~";
	}
}
