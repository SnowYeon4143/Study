package com.kh.app15.board.repository;

import org.apache.ibatis.session.SqlSession;

import com.kh.app15.board.entity.BoardDto;

public interface BoardRepository {
	
	int insert(BoardDto dto);
}
