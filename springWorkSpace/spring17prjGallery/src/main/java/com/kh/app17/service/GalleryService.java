package com.kh.app17.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.kh.app17.vo.GalleryVo;

public interface GalleryService {
	
	int enroll(GalleryVo vo, MultipartFile f) throws IllegalStateException, IOException;
	
}
