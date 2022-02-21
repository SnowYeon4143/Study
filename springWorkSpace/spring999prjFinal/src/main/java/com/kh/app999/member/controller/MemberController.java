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

	//�α��� ȭ�� �����ֱ�
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	//�α��� ���� ó��
	@PostMapping("/login")
	public String login(MemberDto dto, HttpSession session) throws Exception {
		//�α��� ó�� ~~
		MemberDto loginUser = service.login(dto);
		
		if(loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			return "redirect:/";
		}else {
			return "member/login";
		}
		
	}

	//ȸ������ ȭ�� �����ֱ�
	@GetMapping("/join")
	public String join() {
		return "member/join";
	}
	
	// ȸ������ ���� ó��
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
	
	//�α׾ƿ� ó��
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//session ����
		session.invalidate();
		return "redirect:/";
	}
	
	//���������� ȭ�� �����ֱ�
	@GetMapping("/mypage")
	public String mypage(HttpServletRequest req, HttpSession session) {
		//�α��� �� ��쿡�� �����ֱ�
		MemberDto loginUser = (MemberDto) session.getAttribute("loginUser");
		if(loginUser == null) {
			req.setAttribute("msg", "�α��� �ϰ� ������ ~~~");
			return "error/errorPage";
		}
		
		return "member/mypage";
	}
	
	//���������� �� ���� ���� ���� ó��
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
