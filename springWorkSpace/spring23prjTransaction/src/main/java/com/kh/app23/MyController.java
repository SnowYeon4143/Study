package com.kh.app23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/my")
public class MyController {
	
	@Autowired
	private MyService service;
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		
		service.test();
		
		return "test called ~~~";
	}
}
