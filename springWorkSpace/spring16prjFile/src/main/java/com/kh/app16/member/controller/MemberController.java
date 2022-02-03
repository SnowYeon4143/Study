package com.kh.app16.member.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.app16.member.vo.MemberVo;

@Controller
@RequestMapping("/member")
public class MemberController {

	@GetMapping("/join")
	public String join() {

		return "member/join";
	}

	
	 @PostMapping("/join") 
	 public String join(@ModelAttribute MemberVo vo) throws IllegalStateException, IOException {
		 List<MultipartFile> list = vo.getProfileList();
		 
		 //������ �ִ���, ������ üũ 
		 if(list.get(0).isEmpty()) { return "redirect:/errorPage"; }
		 
		 //���� �� �� Ȯ�� 
		 for(MultipartFile p : list) {
			 System.out.println("=============="); 
			 System.out.println("�̸� : " + p.getOriginalFilename()); 
			 System.out.println("ũ�� : " + p.getSize());
			 System.out.println("Ÿ�� : " + p.getContentType());
		 
			 //���� 
			 File file = new File("C:\\dev\\06_Framework\\upload", p.getOriginalFilename()); 
			 p.transferTo(file); 
		 }
		 
		 return "redirect:/"; 
	 }
	 

}
