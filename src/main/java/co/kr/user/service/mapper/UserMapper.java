package co.kr.user.service.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	public int idCheck(String user_id);

	public HashMap<String, Object> login(HashMap<String, Object> param);

	public int cntMax();

	public List<HashMap<String, Object>> userCheck();

	public int insert(HashMap<String, Object> param);


}
