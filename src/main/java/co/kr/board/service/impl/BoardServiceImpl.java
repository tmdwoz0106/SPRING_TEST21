package co.kr.board.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.board.service.BoardService;
import co.kr.board.service.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	public BoardMapper boardMapper;

//	@Override
//	public List<HashMap<String, Object>> list() {
//		return boardMapper.list();
//	}

	@Override
	public List<HashMap<String, Object>> list(int page, String keyword, String type) {
		int amount = 10;
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("startRn", (page-1)*amount);
		param.put("endRn", page*amount);
		param.put("type", type);
		param.put("keyword", keyword);
		return boardMapper.list(param);
	}

	@Override
	public int total(String type, String keyword) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("type", type);
		param.put("keyword", keyword);
		return boardMapper.total(param);
	}
}
