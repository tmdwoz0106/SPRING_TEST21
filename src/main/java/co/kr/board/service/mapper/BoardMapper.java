package co.kr.board.service.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

//	public List<HashMap<String, Object>> list();

	public List<HashMap<String, Object>> list(HashMap<String, Object> param);

}
