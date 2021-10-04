package co.kr.board;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.kr.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	public BoardService boardService;
	
	//----------------------------리스트 페이지--------------------------
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home() {
		
		return "board/list";
	}
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public ModelAndView home_ajax() {
		ModelAndView json = new ModelAndView("jsonView");
		List<HashMap<String, Object>> list = boardService.list();
		json.addObject("list", list);
		return json;
	}
}
