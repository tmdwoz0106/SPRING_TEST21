package co.kr.user;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.kr.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	public UserService userService;
	//qwe
	//------------------------------------로그인---------------------------------------
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(Model model,HttpSession session) {
		String user_kinck = (String)session.getAttribute("user_kinck");
		
		model.addAttribute("user_kinck", user_kinck);
		return "user/login";
	}
	
	@RequestMapping(value = "/loginPost.do", method = RequestMethod.POST)
	public ModelAndView login_ajax(@RequestParam HashMap<String, Object> param ,HttpSession session) {
		ModelAndView json = new ModelAndView("jsonView");
		
		json.addObject("vo", userService.login(param,session));
		return json;
	}
	//------------------------------------로그아웃---------------------------------------
	@RequestMapping(value = "/logout.do", method = RequestMethod.POST)
	public ModelAndView logout(HttpSession session) {
		ModelAndView json = new ModelAndView("jsonView");
		session.invalidate();
		return json;
	}
	//------------------------------------회원가입---------------------------------------
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String join(Model model) {
		int max = userService.cntMax();
		model.addAttribute("max", max+1);
		return "user/join";
	}
	@RequestMapping(value = "/userJoin.do", method = RequestMethod.POST)
	public ModelAndView join_post(@RequestParam HashMap<String, Object> param) {
		ModelAndView json = new ModelAndView("jsonView");
		if(userService.insert(param) > 0) {
			json.addObject("msg", "회원가입 성공!");
			json.addObject("result", "1");
		}else {
			json.addObject("msg", "이미 등록된 아이디입니다.");
			json.addObject("result", "2");
		}	
		return json;
	}
	//------------------------------------회원 정보 확인----------------------------------
	//2021년 10월 06일 오후 4시 03분
	//유저 정보보기 , 수정 , 탈퇴 완성
	@RequestMapping(value = "/UserDetail.do", method = RequestMethod.GET)
	public String detail(int user_no,Model model) {
		HashMap<String, Object> param = userService.detail(user_no);
		model.addAttribute("vo", param);
		return "user/detail";
	}
	//------------------------------------회원 탈퇴----------------------------------
	@RequestMapping(value = "/UserDelete.do", method = RequestMethod.POST)
	public ModelAndView delete(int user_no) {
		ModelAndView json = new ModelAndView("jsonView");
		userService.delete(user_no);
		return json;
	}
	//------------------------------------회원 정보 수정----------------------------------
	@RequestMapping(value = "/UserModify.do", method = RequestMethod.GET)
	public String modify(int user_no,Model model) {
		HashMap<String, Object> vo = userService.detail(user_no);
		model.addAttribute("vo", vo);
		return "user/modify";
	}
	@RequestMapping(value = "/ModifyUser.do", method = RequestMethod.POST)
	public ModelAndView modify_ajax(@RequestParam HashMap<String, Object> param,HttpSession session) {
		ModelAndView json = new ModelAndView("jsonView");
		userService.modify(param,session);
		return json;
	}
}
