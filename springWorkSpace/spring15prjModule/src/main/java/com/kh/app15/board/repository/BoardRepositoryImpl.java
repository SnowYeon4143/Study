package com.kh.app15.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kh.app15.board.entity.BoardDto;

@Component
public class BoardRepositoryImpl implements BoardRepository{

	@Autowired
	SqlSession ss;
	
	@Override
	public int insert(BoardDto dto) throws Exception {
		
		int result = ss.insert("board.insert", dto);
		
		return result;
	}

	@Override
	public List<BoardDto> selectAll() {
		return ss.selectList("board.selectAll");
	}

	@Override
	public int edit(BoardDto dto) {
		return ss.update("board.update", dto);
	}

	@Override
	public int delete(BoardDto dto) {
		return ss.delete("board.delete", dto);
	}

}
