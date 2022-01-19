package com.kh.app12.menu.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.kh.app12.menu.model.vo.MenuVo;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	SqlSession sqlSession;
	
	@GetMapping("/insert")
	public String insert() {
		return "menu/insert";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute MenuVo m) {
		
		sqlSession.insert("menu.insertMenu", m);
		
		return "redirect:/menu/list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		//DB에서 메뉴 리스트를 가져와야 함
		List<MenuVo> menuList = sqlSession.selectList("menu.selectMenuList");
		
		for(MenuVo x : menuList) {
			System.out.println(x);
		}
		//가져온 리스트를, 화면에 전달해야 함 
//		req.setAttribute("list", menuList);
		model.addAttribute("list", menuList);
		
		return "menu/list";
	}
}
