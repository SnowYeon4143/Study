package com.kh.app04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyController {
	/**
	 * 1. 메소드 접근제한자는 무조건 public
	 * 2. return 값은 뷰페이지의 주소를 가지고 있어야 함
	 * 3. 매개변수는 있어도 되고, 없어도 됨
	 * 4. 메소드 이름은 자유
	 */
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	@RequestMapping("/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping("/member")
	public String member() {
		return "member/memberList";
	}
	
	@RequestMapping("/board")
	public String board() {
		return "board/boardWrite";
	}
	
}
