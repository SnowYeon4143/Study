package com.kh.app17.repository;

import com.kh.app17.vo.GalleryVo;

public interface GalleryDao {
	
	//파일번호 가져오기
	int getSeq();
	
	//DB에 VO 저장
	int insert(GalleryVo vo);

	//no를 기준으로 row하나 가져오기
	GalleryVo getGallery(int no);
}
