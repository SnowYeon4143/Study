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
	
	//게시글 작성 페이지 보여주기
	@GetMapping("/insert")
	public String insert() {
		return "board/insert";
	}
	
	//게시글 작성 로직 처리
	@PostMapping("/insert")
	public String insert(@ModelAttribute BoardDto dto) {
		//데이터 받기 -> 이거는 파라미터에서 처리 됨
		
		//로직 처리
		int result = service.enrollBoard(dto);
		
		//화면 선택
		if(result > 0) {
			//success view
			return "redirect:/board/list";
		}else {
			//fail view
			return "board/";
		}
		
	}
	
	//게시글 목록 조회
	
	//상세 페이지 조회
	
	//상세페이지 수정
	
	//상세페이지 삭제
}
