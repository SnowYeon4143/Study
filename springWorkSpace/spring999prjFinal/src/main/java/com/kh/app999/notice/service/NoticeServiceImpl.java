package com.kh.app999.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app999.common.PageVo;
import com.kh.app999.notice.dao.NoticeDao;
import com.kh.app999.notice.vo.NoticeVo;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeDao dao;
	
	@Override
	public int write(NoticeVo vo) throws Exception {
		
		return dao.write(vo);
	}

	@Override
	public List<NoticeVo> getNoticeList(PageVo vo) throws Exception {
		return dao.getNoticeList(vo);
	}

	@Override
	public int deleteNotice(String str) throws Exception {
		String[] delArr = str.split(",");
		return dao.deleteNotice(delArr);
	}

	@Override
	public int getNoticeCnt() throws Exception {
		return dao.getNoticeCnt();
	}

}
