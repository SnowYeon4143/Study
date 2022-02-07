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
	
	//��Ű �����
	@GetMapping("/create")
	@ResponseBody
	public String create(HttpServletResponse response) {
		
		//��Ű �غ�
		Cookie c = new Cookie("k01", "v01");
		c.setMaxAge(60 * 60 * 24); //24�ð� ���� ����
		c.setPath("/");
		
		//��Ű ����
		response.addCookie(c);
		
		return "cookie create ~~~ !";
	}
	
	//��Ű ����
	@GetMapping("/delete")
	@ResponseBody
	public String delete(HttpServletResponse response) {
		
		//��Ű �غ�
		Cookie c = new Cookie("k01", "v01");
		c.setPath("/");
		
		//��Ű ����
		c.setMaxAge(0);
		
		//��Ű ����
		response.addCookie(c);
		
		return "cookie delete";
	}
	
	//��Ű Ȯ�� (JSP)
	@GetMapping("/check")
	public String check() {
		return "cookie/check";
	}
	
	//��Ű Ȯ�� (Controller)
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
