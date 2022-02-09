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
		System.out.println("멤버 컨트롤러 기본 생성자 호출됨 ~~~");
	}
	
	@Autowired
	private MemberService service;
	@Autowired
	private SqlSession ss;
	
	@Autowired
	public MemberController(MemberService service, SqlSession ss) {
		System.out.println("멤버 컨트롤러 파라미터 있는 생성자 호출됨 ~~~");
		this.service = service;
		this.ss = ss;
	}
	
	//회원가입 화면
	@GetMapping("/join")
	public String join() throws Exception {
		
		return"member/join";
	}
	
	//회원가입 화면
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
