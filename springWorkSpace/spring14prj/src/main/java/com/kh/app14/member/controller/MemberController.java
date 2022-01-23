package com.kh.app14.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app14.member.entity.MemberDto;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//회원가입 화면
	@GetMapping("/join")
	public String join() {
		return "member/join";
	}
	
	//회원가입 처리
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto m) {
		
		//암호화
//		String newPwd = m.getPwd() + "abc";
		String newPwd = passwordEncoder.encode(m.getPwd());
		System.out.println("회원가입 pwd =====\n " + newPwd);
		m.setPwd(newPwd);
		
		//m 객체를, DB에 insert
		sqlSession.insert("member.join", m);
		
		return "redirect:/";
	}
	
	//로그인 화면
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	//로그인 처리
	@PostMapping("/login")
	public String login(String id, String pwd) {
		
		String newPwd = passwordEncoder.encode(pwd);
		System.out.println("로그인 pwd =====\n " + newPwd);
		
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
//		map.put("pwd", pwd + "abc");
		map.put("pwd", newPwd);
		
		//DB에서 현재 ID의 PWD 가져오기
		//그리고 그 패스워드랑 화면에서 입력받은 데이터를 비교하기
		//위에서 비교한 그 결과값이 로그인 성공 여부
		
		boolean x = passwordEncoder.matches(pwd, "$2a$10$nXmNl7KHObfB5VCQSZmmP.2xwQVKYv0bnUxzYpox3B.mlYxH9lSkO");
		System.out.println(x);
//		$2a$10$nXmNl7KHObfB5VCQSZmmP.2xwQVKYv0bnUxzYpox3B.mlYxH9lSkO
//		$2a$10$omdfLfeE8sw6e0bMB2Ou.ujaX4G/gih5r22arwL.pGgPgc.nC/R2S
		
		MemberDto loginMember = sqlSession.selectOne("member.login", map);
		System.out.println("loginMember : " + loginMember);
		
		return "redirect:/";
	}
	
	
	//회원목록
	@GetMapping("/list")
	public String list(Model model, String type, String value) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("t", type);
		map.put("v", value);
		if("age".equals(type)) {
			map.put("v", value.split(","));
		}
		
		List<MemberDto> memberList = sqlSession.selectList("member.search", map);
		
		model.addAttribute("memberList", memberList);
		
		return "member/list";
	}
	
}
