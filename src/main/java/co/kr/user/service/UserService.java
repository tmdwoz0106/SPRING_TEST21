package co.kr.user.service;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

public interface UserService {

	public HashMap<String, Object> login(HashMap<String, Object>param, HttpSession session);

	public int cntMax();

	public int insert(HashMap<String, Object> param);

}
