package com.kh.app15.board.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		//������ �ޱ� -> �̰Ŵ� �Ķ���Ϳ��� ó�� ��
		
		//���� ó��
		int result = service.enrollBoard(dto);
		
		//ȭ�� ����
		if(result > 0) {
			//success view
			return "redirect:/board/list";
		}else {
			//fail view
			return "board/";
		}
		
	}
	
	//�Խñ� ��� ��ȸ
	
	//�� ������ ��ȸ
	
	//�������� ����
	
	//�������� ����
}
