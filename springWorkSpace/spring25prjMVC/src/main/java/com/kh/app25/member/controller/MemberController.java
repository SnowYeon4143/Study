package com.kh.app25.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app25.member.entity.MemberDto;
import com.kh.app25.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	//회원가입 화면
	@GetMapping("/join")
	public String join() throws Exception {
		
		return"member/join";
	}
	
	//회원가입 화면
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto dto) throws Exception {

		int result = service.join(dto);

		return "member/join";
	}
}
