package com.kh.app17.repository;

import com.kh.app17.vo.GalleryVo;

public interface GalleryDao {
	
	//���Ϲ�ȣ ��������
	int getSeq();
	
	//DB�� VO ����
	int insert(GalleryVo vo);
}
