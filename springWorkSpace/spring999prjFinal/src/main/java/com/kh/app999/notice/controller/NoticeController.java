package com.kh.app999.notice.controller;

import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app999.common.PageVo;
import com.kh.app999.notice.service.NoticeService;
import com.kh.app999.notice.vo.NoticeVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/notice")
@Slf4j
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	//공지사항 화면 보여주기
	@GetMapping(value = {"/list/{page}", "/list"})
	public String list(Model model, @PathVariable(required = false) String page) throws Exception {
		if(page == null) {
			return "redirect:list/1";
		}
		
		//페이지 vo 생성
		int cntPerPage = 10; // 한 페이지당 10개씩 보여주기
		int pageBtnCnt = 5;  // 한번에 보여줄 페이지 버튼 갯수
		int totalRow = service.getNoticeCnt(); // DB에 있는 모든 row 갯수
		//현재페이지, 한페이지에 보여줄 개수, 한페이지당 버튼
		PageVo vo = new PageVo(page, cntPerPage, pageBtnCnt, totalRow);
		
		//리스트 조회
		List<NoticeVo> list = service.getNoticeList(vo);
		model.addAttribute("list", list);
		model.addAttribute("page", vo);
		return "notice/list";
	}
	
	//공지사항 작성하기 화면 보여주기
	@GetMapping("/write")
	public String write() {
		return "notice/write";
	}
	
	//공지사항 작성 로직 처리
	@PostMapping("/write")
	public String write(HttpServletRequest req, NoticeVo vo) throws Exception {
		
//		for(int i = 0; i < 500; i++) {
//			service.write(vo);
//		}
		
		int result = service.write(vo);
		
		if(result > 0) {
			return "redirect:/notice/list";
		}else {
			req.setAttribute("msg", "공지사항 작성 실패");
			return "error/errorPage";
		}
	}
	
	@PostMapping("delete")
	@ResponseBody
	public String delete(String str) throws Exception {
		int result = service.deleteNotice(str);
		
		log.warn("건드린 row 갯수 : {}", result);
		
		if(result == str.length()/2) {
			return "ok";
		}else {
			return "fail_" + result;
		}
	}
	
}
