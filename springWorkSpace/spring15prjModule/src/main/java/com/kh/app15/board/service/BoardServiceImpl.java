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
		//�Խñ� ��� -> DAO�� ����
		//������ ��ȯ
		return dao.insert(dto);
	}

}
