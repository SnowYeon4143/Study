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
		
		//���� �ޱ�(�Ķ���ͷ� ó��)
		
		int result = service.join(dto);
		//������ �۾��� ���� ���̾����� �ñ�
		
		//ȭ�� ����
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
		
		//�α��� ó��
		//���̵� ������ ��񰡼� ��� ��������
		MemberDto member = ss.selectOne("member.login", dto);
		if(member == null) {
			//�̷� ���̵� ����
			return"redirect:/member/login";
		}
		String dbPwd = member.getPwd();
		
		//������ ����̶�, ����� �Է� ����̶� ��ġ�ϴ��� Ȯ��
		String userPwd = dto.getPwd();
		
		if (pe.matches(userPwd, dbPwd)) {
			//success
			//session�� ���
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
