package com.kh.app15.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kh.app15.board.entity.BoardDto;
import com.kh.app15.board.repository.BoardRepository;

@Component
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardRepository dao;
	
	@Override
	public int enrollBoard(BoardDto dto) throws Exception {
		return dao.insert(dto);
	}

	@Override
	public List<BoardDto> selectList() {
		return dao.selectAll();
	}

	@Override
	public int edit(BoardDto dto) {
		return dao.edit(dto);
	}

	@Override
	public int delete(BoardDto dto) {
		return dao.delete(dto);
	}

}
