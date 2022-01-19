package com.kh.app10.menu;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app10.menu.model.vo.MenuVo;

@Controller
@RequestMapping("menu")
public class MenuController {
	
//	@Autowired
//	private JdbcTemplate jt;
	
	@Autowired
	private SqlSession sqlSession;
	
	@GetMapping("insert")
	public String insert() {
		return "menu/insert";
	}
	
	@PostMapping("insert")
	public String insert(@ModelAttribute MenuVo m) {
		//insert ~~~
//		String sql = "INSERT INTO MENU(MENU, PRICE) VALUES(?, ?)";
//		Object[] params = /* new Object[] */ {menu, price};
//		jt.update(sql, params);
		
		//�𵨾�Ʈ����Ʈ�� ����ϸ� ��
//		MenuVo m = new MenuVo();
//		m.setMenu(menu);
//		m.setPrice(price);
		
//		sqlSession.insert(������, �������� ������ ����);
		sqlSession.insert("menu.insertMenu", m);
		
		return "redirect:/menu/insert";
	}
}
