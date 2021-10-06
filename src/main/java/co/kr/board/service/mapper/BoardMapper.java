package co.kr.board.service.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

	public List<HashMap<String, Object>> list(HashMap<String, Object> param);

	public int total(HashMap<String, Object> param);

	public HashMap<String, Object> detail(int board_no);

	public int insert(HashMap<String, Object> param);

	public int max();

	public int delete(HashMap<String, Object> param);

	public int modify(HashMap<String, Object> param);

	public int cntUp(HashMap<String, Object> param);







}
