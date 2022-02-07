package com.kh.app22;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/cookie")
public class CookieController {
	
	//쿠키 만들기
	@GetMapping("/create")
	@ResponseBody
	public String create(HttpServletResponse response) {
		
		//쿠키 준비
		Cookie c = new Cookie("k01", "v01");
		c.setMaxAge(60 * 60 * 24); //24시간 동안 유지
		c.setPath("/");
		
		//쿠키 전달
		response.addCookie(c);
		
		return "cookie create ~~~ !";
	}
	
	//쿠키 삭제
	@GetMapping("/delete")
	@ResponseBody
	public String delete(HttpServletResponse response) {
		
		//쿠키 준비
		Cookie c = new Cookie("k01", "v01");
		c.setPath("/");
		
		//쿠키 삭제
		c.setMaxAge(0);
		
		//쿠키 전달
		response.addCookie(c);
		
		return "cookie delete";
	}
	
	//쿠키 확인 (JSP)
	@GetMapping("/check")
	public String check() {
		return "cookie/check";
	}
	
	//쿠키 확인 (Controller)
	@GetMapping("check-ctrl")
	@ResponseBody
	public String checkCtrl(@CookieValue(required = false) Cookie k01) {
		
		if(k01 != null)
		{
			log.info(k01.getValue());						
		}
		
		return "cookie check at controller ~~~";
	}
	
}
