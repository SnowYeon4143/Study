package com.kh.app17.controller;

import java.io.File;
import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.app17.service.GalleryService;
import com.kh.app17.vo.GalleryVo;

@Controller
@RequestMapping("/gallery")
public class GalleryController {
	
	@Autowired
	private GalleryService service;
	
	@GetMapping("/enroll")
	public String enroll() {
		return "gallery/enroll";
	}
	
	@PostMapping("/enroll")
	public String enroll(GalleryVo vo, MultipartFile f) throws IllegalStateException, IOException {
		
		if(f.isEmpty()) {
			return "redirect:/errorPage";
		}
		
		int result = service.enroll(vo, f);
		
		if(result > 0) {
			return "redirect:/gallery/enroll";
		}else {
			return "redirect:/errorPage";
		}
		
	}
}
