package com.kh.app08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private JdbcTemplate jdbcTemplate;
//	JdbcTemplate jt = new JdbcTemplate();
	
	@GetMapping("/insert")
	public String insert() {
		return "menu/insert"; // /WEB-INF/views/menu/insert.jsp
	}
	
	@PostMapping("/insert")
	public String insert(String menu, int price) {
		
		// 직접 DB에 insert
		String sql = "INSERT INTO MENU(MENU, PRICE) VALUES(?, ?)";
//		Object[] params = new Object[] {menu , price};
		Object[] params = {menu , price};
		
		//jdbcTemplate.update(쿼리, 파라미터);
		jdbcTemplate.update(sql, params);
		
		System.out.println("menu : " + menu);
		System.out.println("price : " + price);
		return "redirect:/menu/insert";
	}
}
