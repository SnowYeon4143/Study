package com.kh.app999.notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.app999.common.PageVo;
import com.kh.app999.notice.vo.NoticeVo;

@Repository
public class NoticeDaoImpl implements NoticeDao{

	@Autowired
	private SqlSession ss;
	
	@Override
	public int write(NoticeVo vo) throws Exception {
		return ss.insert("notice.insertNotice", vo);
	}

	@Override
	public List<NoticeVo> getNoticeList(PageVo vo) throws Exception {
		return ss.selectList("notice.getNoticeList", vo);
	}

	@Override
	public int deleteNotice(String[] delArr) throws Exception {
		return ss.update("notice.deleteNotice", delArr);
	}

	@Override
	public int getNoticeCnt() throws Exception {
		return ss.selectOne("notice.getNoticeCnt");
	}

}
