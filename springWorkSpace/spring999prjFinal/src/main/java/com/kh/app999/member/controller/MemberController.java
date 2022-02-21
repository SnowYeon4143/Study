package com.kh.app999.member.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.app999.member.entity.MemberDto;
import com.kh.app999.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {
	
	@Autowired
	private MemberService service;

	//로그인 화면 보여주기
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	//로그인 로직 처리
	@PostMapping("/login")
	public String login(MemberDto dto, HttpSession session) throws Exception {
		//로그인 처리 ~~
		MemberDto loginUser = service.login(dto);
		
		if(loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			return "redirect:/";
		}else {
			return "member/login";
		}
		
	}

	//회원가입 화면 보여주기
	@GetMapping("/join")
	public String join() {
		return "member/join";
	}
	
	// 회원가입 로직 처리
	@PostMapping("/join")
	public String join(MemberDto dto, HttpServletRequest req) throws Exception {
		
		System.out.println(dto);
		
		int result = service.join(dto, req);
		
		if(result > 0) {
			return "redirect:/member/login";
		}else {
			return "redirect:/member/join";
		}
		
	}
	
	//로그아웃 처리
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//session 만료
		session.invalidate();
		return "redirect:/";
	}
	
	//마이페이지 화면 보여주기
	@GetMapping("/mypage")
	public String mypage(HttpServletRequest req, HttpSession session) {
		//로그인 한 경우에만 보여주기
		MemberDto loginUser = (MemberDto) session.getAttribute("loginUser");
		if(loginUser == null) {
			req.setAttribute("msg", "로그인 하고 오세요 ~~~");
			return "error/errorPage";
		}
		
		return "member/mypage";
	}
	
	//마이페이지 내 정보 수정 로직 처리
	@PostMapping("/mypage")
	public String mypage(MemberDto dto, HttpSession session) throws Exception {
		
		MemberDto m = service.editMember(dto);
		
		if(m != null) {
			session.setAttribute("loginUser", m);
			return "redirect:/member/mypage";			
		}else {
			return "redirect:/error/mypagezz";						
		}
		
	}
}
