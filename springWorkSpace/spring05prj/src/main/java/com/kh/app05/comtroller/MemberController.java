package com.kh.app05.comtroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.app05.member.model.vo.MemberVo;

@Controller
@RequestMapping("/member")
public class MemberController {
	
//	@RequestMapping(value = "/view", method = RequestMethod.GET)
	@GetMapping("/join")
	public String join() {
		System.out.println("join get ��û ó����");
		return "member/join";
	}
	
//	@RequestMapping(value = "/join", method = RequestMethod.POST)
	@PostMapping("/join")
	public String join2(
			//<���������� �����͸� �޴� ���>
			//��� 1 : req.getParam(..);
			//HttpServletRequest req
			//req.getParameter("id");
			
			//��� 2 : �޼ҵ��� �Ķ���� (@RequestParam)
			// - required : ȭ�鿡�� �Ѿ���� name �� �ش� �� ���� ����
			// - defaultValue : �⺻ �� ����
			// - name : ȭ�鿡�� �Ѿ���� �Ķ���� �̸�
			// - value : name�� ���� ���
			//@RequestParam String id
			
			//��� 3 : @ModelAttribute
			// - setXXX �̿��Ͽ� �����͸� ����
			// - camelCase ���缭 �۾��� �Ѵ�.
			@ModelAttribute MemberVo m
			){
		System.out.println("join post ��û ó����");

		System.out.println("id : " + m.getId());
		System.out.println("pwd : " + m.getPwd());
		System.out.println("nick : " + m.getNick());
		System.out.println("age : " + m.getAge());
		
		return "member/join_result";
	}
	
}
