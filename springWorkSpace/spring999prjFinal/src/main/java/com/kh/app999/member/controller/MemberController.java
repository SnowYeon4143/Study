package com.kh.app999.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app999.member.entity.MemberDto;
import com.kh.app999.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {
	
	@Autowired
	private MemberService service;

	//�α��� ȭ�� �����ֱ�
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	//�α��� ���� ó��
	@PostMapping("login")
	public String login(MemberDto dto) {
		//�α��� ó�� ~~
		return "member/login";
	}

	//ȸ������ ȭ�� �����ֱ�
	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	
	// ȸ������ ���� ó��
	@PostMapping("join")
	public String join(MemberDto dto) throws Exception {
		
		log.info(dto.toString());
		
		int result = service.join(dto);
		
		log.info(dto.toString());
		
		return "member/join";
	}
}
