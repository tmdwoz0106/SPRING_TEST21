package co.kr.board;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.kr.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	public BoardService boardService;
	
	//----------------------------리스트 페이지--------------------------
	//할만하노 ㅋ
	//2021-10-04 - 11시 41분 최승재 커밋 
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(HttpSession session,Model model) {

		return "board/list";
	}
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public ModelAndView home_ajax(int page, String keyword, String type) {
		ModelAndView json = new ModelAndView("jsonView");
		List<HashMap<String, Object>> list = boardService.list(page,keyword,type);
		int endPage = (int)(Math.ceil(page*1.0/10))*10;
		int startPage = endPage - 9;
		if(startPage <= 0) {
			startPage = 1;
		}
		
		int total = boardService.total(type,keyword);
		int totalPage = (int)(Math.ceil(total*1.0/10));
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		boolean prev = page > 1;
		boolean next = page < endPage;
		
		json.addObject("list", list);
		json.addObject("endPage", endPage);
		json.addObject("startPage", startPage);
		json.addObject("prev", prev);
		json.addObject("next", next);
		return json;
	}
}
