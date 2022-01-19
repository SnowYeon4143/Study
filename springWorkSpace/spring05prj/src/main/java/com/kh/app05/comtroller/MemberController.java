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
		System.out.println("join get 요청 처리함");
		return "member/join";
	}
	
//	@RequestMapping(value = "/join", method = RequestMethod.POST)
	@PostMapping("/join")
	public String join2(
			//<스프링에서 데이터를 받는 방법>
			//방법 1 : req.getParam(..);
			//HttpServletRequest req
			//req.getParameter("id");
			
			//방법 2 : 메소드의 파라미터 (@RequestParam)
			// - required : 화면에서 넘어오는 name 중 해당 값 존재 여부
			// - defaultValue : 기본 값 설정
			// - name : 화면에서 넘어오는 파라미터 이름
			// - value : name과 같은 기능
			//@RequestParam String id
			
			//방법 3 : @ModelAttribute
			// - setXXX 이용하여 데이터를 맵핑
			// - camelCase 맞춰서 작업을 한다.
			@ModelAttribute MemberVo m
			){
		System.out.println("join post 요청 처리함");

		System.out.println("id : " + m.getId());
		System.out.println("pwd : " + m.getPwd());
		System.out.println("nick : " + m.getNick());
		System.out.println("age : " + m.getAge());
		
		return "member/join_result";
	}
	
}
