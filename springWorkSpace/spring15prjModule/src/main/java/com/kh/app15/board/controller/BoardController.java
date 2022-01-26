package com.kh.app15.board.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.app15.board.entity.BoardDto;
import com.kh.app15.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	SqlSession ss;
	
	@Autowired
	BoardService service;
	
	//�Խñ� �ۼ� ������ �����ֱ�
	@GetMapping("/insert")
	public String insert() {
		return "board/insert";
	}
	
	//�Խñ� �ۼ� ���� ó��
	@PostMapping("/insert")
	public String insert(@ModelAttribute BoardDto dto) {
		
		int result = 0;
		try {
			result = service.enrollBoard(dto);
		} catch (Exception e) {
			return "redirect:/common/error/fail";
		}
		
		if(result > 0) {
			return "redirect:/board/list";
		}else {
			return "redirect:/common/error";
		}
	}
	
	//�Խñ� ��� ��ȸ
	@GetMapping("/list")
	public ModelAndView list(ModelAndView mv) {
		//��񰡼� ��������,
//		List<BoardDto> list = ss.selectList("board.selectAll");
		List<BoardDto> list = service.selectList();
		
		//model
		mv.addObject("list", list);
		//view
		mv.setViewName("board/list");
		
		//view ����
		return mv;
	}
	
	//�� ������ ��ȸ
	@GetMapping("/detail/{t}")
	public String detail(@PathVariable String t, Model model) {		
//		BoardDto dto = ss.selectOne("board.selectOneByTitle", t);
		BoardDto dto = service.selectOne(t);
		
		
		model.addAttribute("data", dto);
		return "board/detail";
	}
	
	//�������� ����
	@PostMapping("/edit")
	public String edit(BoardDto dto) {
		//dto ������ ó��
		int result = service.edit(dto);
		
		if(result > 0) {
			//success
			return "redirect:/board/list";
		}else {
			//fail
			return "redirect:/common/error";
		}
	}
	
	//�������� ����
	@PostMapping("/delete")
	public String delete(BoardDto dto) {
		int result = service.delete(dto);
		
		if(result > 0) {
			//success
			return "redirect:/board/list";
		}else {
			//fail
			return "redirect:/common/error";
		}
	}
}
