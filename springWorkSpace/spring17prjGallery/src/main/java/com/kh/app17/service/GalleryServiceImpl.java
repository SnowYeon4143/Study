package com.kh.app17.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.app17.repository.GalleryDao;
import com.kh.app17.vo.GalleryVo;

@Service
public class GalleryServiceImpl implements GalleryService{

	@Autowired
	private GalleryDao dao;
	
	@Override
	public int enroll(GalleryVo vo, MultipartFile f) throws IllegalStateException, IOException {
		
		//파일번호 가져오기
		int no = dao.getSeq();
		vo.setNo(no);
		vo.setFname(f.getOriginalFilename());
		vo.setFtype(f.getContentType());
		vo.setFsize(f.getSize());
		
		//디비에 vo 저장
		int result = dao.insert(vo);
		
		//서버(우리컴퓨터)에 저장
		//파일 만들기
		File file = new File("C:\\dev\\06_Framework\\upload", String.valueOf(no));
		
		//파일에 옮기기 
		f.transferTo(file);
		
		return result;
	}

}
