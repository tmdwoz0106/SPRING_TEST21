package co.kr.board.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
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

	@Override
	public HashMap<String, Object> detail(int board_no) {
		return boardMapper.detail(board_no);
	}
	
	@Override
	public int insert(HashMap<String, Object> param) {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		param.put("board_day", simple.format(date));
		return boardMapper.insert(param);
	}

	@Override
	public int max() {
		return boardMapper.max();
	}

	@Override
	public int delete(HashMap<String, Object> param) {
		return boardMapper.delete(param);
	}

	@Override
	public int modify(HashMap<String, Object> param) {
		return boardMapper.modify(param);
	}

	@Override
	public int cntUp(int board_no, int board_view) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("board_no", board_no);
		param.put("board_view", board_view);
		return boardMapper.cntUp(param);
	}



}
