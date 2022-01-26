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
	
	//게시글 작성 페이지 보여주기
	@GetMapping("/insert")
	public String insert() {
		return "board/insert";
	}
	
	//게시글 작성 로직 처리
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
	
	//게시글 목록 조회
	@GetMapping("/list")
	public ModelAndView list(ModelAndView mv) {
		//디비가서 가져오고,
//		List<BoardDto> list = ss.selectList("board.selectAll");
		List<BoardDto> list = service.selectList();
		
		//model
		mv.addObject("list", list);
		//view
		mv.setViewName("board/list");
		
		//view 선택
		return mv;
	}
	
	//상세 페이지 조회
	@GetMapping("/detail/{t}")
	public String detail(@PathVariable String t, Model model) {		
//		BoardDto dto = ss.selectOne("board.selectOneByTitle", t);
		BoardDto dto = service.selectOne(t);
		
		
		model.addAttribute("data", dto);
		return "board/detail";
	}
	
	//상세페이지 수정
	@PostMapping("/edit")
	public String edit(BoardDto dto) {
		//dto 가지고 처리
		int result = service.edit(dto);
		
		if(result > 0) {
			//success
			return "redirect:/board/list";
		}else {
			//fail
			return "redirect:/common/error";
		}
	}
	
	//상세페이지 삭제
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
