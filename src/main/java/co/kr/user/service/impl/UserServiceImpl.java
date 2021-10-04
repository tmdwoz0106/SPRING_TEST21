package co.kr.user.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.user.service.UserService;
import co.kr.user.service.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	public UserMapper userMapper;

	@Override
	public HashMap<String, Object> login(HashMap<String, Object> param, HttpSession session) {
		String id = (String)param.get("user_id");
		String pw = (String)param.get("user_pw");
		int i = userMapper.idCheck(id);
		if(i > 0) {			
			param = userMapper.login(param);
			if(param == null) {
				param = new HashMap<String, Object>();
				param.put("msg", "잘못된 비밀번호입니다.");
				return param;
			}else {
				session.setAttribute("id", param.get("user_id"));
				session.setAttribute("kinck", param.get("user_kicnk") );
				return param;
			}
		}else {
			param = new HashMap<String, Object>();
			param.put("msg", "없는 아이디입니다.");
			return param;
		}
	}

	@Override
	public int cntMax() {
		return userMapper.cntMax();
	}

	@Override
	public int insert(HashMap<String, Object> param) {
		String id = (String)param.get("user_id");
		List<HashMap<String, Object>> list = userMapper.userCheck();
		for(int i = 0; i < list.size(); i++) {
			if(param.get("user_id").equals(list.get(i).get("USER_ID"))) {
				return 0;
			}
		}
		return  userMapper.insert(param);
	}
}
