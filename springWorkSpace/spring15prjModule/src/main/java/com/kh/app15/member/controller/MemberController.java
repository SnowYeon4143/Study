package com.kh.app15.member.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app15.member.entity.MemberDto;
import com.kh.app15.member.service.MemberService;
import com.kh.app15.member.service.MemberServiceInter;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private SqlSession ss;
	
	@Autowired
	private PasswordEncoder pe;
	
	@Autowired
	private MemberServiceInter service;
	
	@GetMapping("/join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("/join")
	public String join(MemberDto dto) {
		
		//값을 받기(파라미터로 처리)
		
		int result = service.join(dto);
		//나머지 작업은 서비스 레이어한테 맡김
		
		//화면 선택
		if(result > 0) {
			//success
			return "redirect:/";
		}else {
			//fail
			return "redirect:/member/join";
		}

	}
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(MemberDto dto, HttpSession session) {
		
		//로그인 처리
		//아이디 가지고 디비가서 비번 가져오기
		MemberDto member = ss.selectOne("member.login", dto);
		if(member == null) {
			//이런 아이디 없음
			return"redirect:/member/login";
		}
		String dbPwd = member.getPwd();
		
		//가져온 비번이랑, 사용자 입력 비번이랑 일치하는지 확인
		String userPwd = dto.getPwd();
		
		if (pe.matches(userPwd, dbPwd)) {
			//success
			//session에 담기
			session.setAttribute("loginMember", member);
			
			return "redirect:/";
		}else {
			//fail
			return"redirect:/member/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
}
