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
	
	//�������� ȭ�� �����ֱ�
	@GetMapping(value = {"/list/{page}", "/list"})
	public String list(Model model, @PathVariable(required = false) String page) throws Exception {
		if(page == null) {
			return "redirect:list/1";
		}
		
		//������ vo ����
		int cntPerPage = 10; // �� �������� 10���� �����ֱ�
		int pageBtnCnt = 5;  // �ѹ��� ������ ������ ��ư ����
		int totalRow = service.getNoticeCnt(); // DB�� �ִ� ��� row ����
		//����������, ���������� ������ ����, ���������� ��ư
		PageVo vo = new PageVo(page, cntPerPage, pageBtnCnt, totalRow);
		
		//����Ʈ ��ȸ
		List<NoticeVo> list = service.getNoticeList(vo);
		model.addAttribute("list", list);
		model.addAttribute("page", vo);
		return "notice/list";
	}
	
	//�������� �ۼ��ϱ� ȭ�� �����ֱ�
	@GetMapping("/write")
	public String write() {
		return "notice/write";
	}
	
	//�������� �ۼ� ���� ó��
	@PostMapping("/write")
	public String write(HttpServletRequest req, NoticeVo vo) throws Exception {
		
//		for(int i = 0; i < 500; i++) {
//			service.write(vo);
//		}
		
		int result = service.write(vo);
		
		if(result > 0) {
			return "redirect:/notice/list";
		}else {
			req.setAttribute("msg", "�������� �ۼ� ����");
			return "error/errorPage";
		}
	}
	
	@PostMapping("delete")
	@ResponseBody
	public String delete(String str) throws Exception {
		int result = service.deleteNotice(str);
		
		log.warn("�ǵ帰 row ���� : {}", result);
		
		if(result == str.length()/2) {
			return "ok";
		}else {
			return "fail_" + result;
		}
	}
	
}
