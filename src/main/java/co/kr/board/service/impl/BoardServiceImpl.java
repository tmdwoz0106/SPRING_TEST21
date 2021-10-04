package co.kr.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.board.service.mapper.BoardMapper;

@Service
public class BoardServiceImpl {

	@Autowired
	public BoardMapper boardMapper;
}
