package com.kh.app15.board.repository;

import java.util.List;

import com.kh.app15.board.entity.BoardDto;

public interface BoardRepository {
	int insert(BoardDto dto) throws Exception;

	List<BoardDto> selectAll();

	int edit(BoardDto dto);

	int delete(BoardDto dto);

	BoardDto selectOne(String t);
}
