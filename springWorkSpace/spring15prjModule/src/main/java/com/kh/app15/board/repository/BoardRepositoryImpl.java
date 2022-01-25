package com.kh.app15.board.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kh.app15.board.entity.BoardDto;

@Component
public class BoardRepositoryImpl implements BoardRepository{

	@Autowired
	private SqlSession ss;
	
//	@Autowired
//	public BoardRepositoryImpl(SqlSession sss) {
//		this.ss = sss;
//	}
	
	@Override
	public int insert(BoardDto dto) {
		return ss.insert("board.insert", dto);
	}

}
