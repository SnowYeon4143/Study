package com.kh.app17.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.app17.vo.GalleryVo;

@Repository
public class GalleryDaoImpl implements GalleryDao{

	@Autowired
	SqlSession ss;
	
	@Override
	public int getSeq() {
		return ss.selectOne("gallery.getSeq");
	}

	@Override
	public int insert(GalleryVo vo) {
		return ss.insert("gallery.enroll", vo);
	}

	@Override
	public GalleryVo getGallery(int no) {
		//no를 기준으로 row 하나 가져오기
		return ss.selectOne("gallery.getByNo", no);
	}

}
