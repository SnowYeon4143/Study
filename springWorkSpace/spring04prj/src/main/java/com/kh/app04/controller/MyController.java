package com.kh.app04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyController {
	/**
	 * 1. �޼ҵ� ���������ڴ� ������ public
	 * 2. return ���� ���������� �ּҸ� ������ �־�� ��
	 * 3. �Ű������� �־ �ǰ�, ��� ��
	 * 4. �޼ҵ� �̸��� ����
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
