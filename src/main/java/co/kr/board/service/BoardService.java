package co.kr.board.service;

import java.util.HashMap;
import java.util.List;

public interface BoardService {

	public List<HashMap<String, Object>> list(int page, String keyword, String type);

	public int total(String type,String keyword);

	public HashMap<String, Object> detail(int board_no);

	public int insert(HashMap<String, Object> param);

	public int max();

	public int delete(HashMap<String, Object> param);

	public int modify(HashMap<String, Object> param);

	public int cntUp(int board_no, int board_view);

	







}
