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
		
		//���Ϲ�ȣ ��������
		int no = dao.getSeq();
		vo.setNo(no);
		vo.setFname(f.getOriginalFilename());
		vo.setFtype(f.getContentType());
		vo.setFsize(f.getSize());
		
		//��� vo ����
		int result = dao.insert(vo);
		
		//����(�츮��ǻ��)�� ����
		//���� �����
		File file = new File("C:\\dev\\06_Framework\\upload", String.valueOf(no));
		
		//���Ͽ� �ű�� 
		f.transferTo(file);
		
		return result;
	}

}
