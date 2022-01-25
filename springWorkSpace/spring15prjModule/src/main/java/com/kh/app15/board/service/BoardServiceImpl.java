package com.kh.app15.board.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kh.app15.board.entity.BoardDto;
import com.kh.app15.board.repository.BoardRepository;

@Component
public class BoardServiceImpl implements BoardService{

	@Autowired
	SqlSession ss;
	
	@Autowired
	BoardRepository dao;
	
	@Override
	public int enrollBoard(BoardDto dto) {
		//게시글 등록 -> DAO가 할일
		//실행결과 반환
		return dao.insert(dto);
	}

}
