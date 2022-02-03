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
	
	//ÄíÅ° ¸¸µé±â
	@GetMapping("/create")
	@ResponseBody
	public String create(HttpServletResponse response) {
		
		//ÄíÅ° ÁØºñ
		Cookie c = new Cookie("k01", "v01");
		c.setPath("/");
		
		//ÄíÅ° Àü´Ş
		response.addCookie(c);
		
		return "cookie create ~~~ !";
	}
	
	//ÄíÅ° »èÁ¦
	@GetMapping("/delete")
	@ResponseBody
	public String delete(HttpServletResponse response) {
		
		//ÄíÅ° ÁØºñ
		Cookie c = new Cookie("k01", "v01");
		c.setPath("/");
		
		//ÄíÅ° »èÁ¦
		c.setMaxAge(0);
		
		//ÄíÅ° Àü´Ş
		response.addCookie(c);
		
		return "cookie delete";
	}
	
	//ÄíÅ° È®ÀÎ (JSP)
	@GetMapping("/check")
	public String check() {
		return "cookie/check";
	}
	
	//ÄíÅ° È®ÀÎ (Controller)
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
