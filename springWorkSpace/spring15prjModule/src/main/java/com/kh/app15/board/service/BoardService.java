package com.kh.app15.board.service;

import java.util.List;

import com.kh.app15.board.entity.BoardDto;

public interface BoardService {
	int enrollBoard(BoardDto dto) throws Exception;

	List<BoardDto> selectList();

	int edit(BoardDto dto);

	int delete(BoardDto dto);
}
