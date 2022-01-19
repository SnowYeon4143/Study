package com.kh.app11.menu.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app11.menu.model.vo.MenuVo;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	SqlSession sqlSession;
	
	@GetMapping("/insert")
	public String insert() {
		return "/menu/insert";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute MenuVo m) {
		
		sqlSession.insert("menu.insertMenu", m);
		
		return "redirect:/menu/insert";
	}
}
