package com.kh.app25.member.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app25.member.entity.MemberDto;
import com.kh.app25.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {
	
	public MemberController() {
		System.out.println("��� ��Ʈ�ѷ� �⺻ ������ ȣ��� ~~~");
	}
	
	@Autowired
	private MemberService service;
	@Autowired
	private SqlSession ss;
	
	@Autowired
	public MemberController(MemberService service, SqlSession ss) {
		System.out.println("��� ��Ʈ�ѷ� �Ķ���� �ִ� ������ ȣ��� ~~~");
		this.service = service;
		this.ss = ss;
	}
	
	//ȸ������ ȭ��
	@GetMapping("/join")
	public String join() throws Exception {
		
		return"member/join";
	}
	
	//ȸ������ ȭ��
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto dto) throws Exception {

		System.out.println(dto);
		
		int result = service.join(dto);

		return "member/join";
	}
	
	@GetMapping("/searchbyid")
	@ResponseBody
	public String searchById(String id) {
		log.info("id : {}", id);
		
		MemberDto dto = ss.selectOne("member.selectMemberById", id);
		
		log.info("dto : {}", dto);
		
		return "searchById ~~~";
	}
}
