package com.kh.app15.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	//홈 화면 보여주는 메소드 만들기
	@RequestMapping("/")
	public String home() {	
		int x = 1/0;
		
		return "/home";
	}
	
}
