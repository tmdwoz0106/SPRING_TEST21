package co.kr.board;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.kr.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	public BoardService boardService;
	
	//----------------------------리스트 페이지--------------------------

	//2021-10-04 - 11시 41분 최승재 커밋 
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(HttpSession session,Model model) {
		int i = Integer.parseInt(session.getAttribute("param").toString());
		model.addAttribute("user_no", i);
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
	//-------------------------------상세보기-------------------------------------
	//게시판 나머지 완성
	//2021년 10월 06일 오전 11시 19분
	//상세보기, 조회수 증가, 추가 수정 삭제 완료
	@RequestMapping(value = "/BoardDetail.do", method = RequestMethod.GET)
	public String detail(Model model,int board_no,HttpSession session) {
		HashMap<String, Object> param = boardService.detail(board_no);	
		int board_view = Integer.parseInt(param.get("BOARD_VIEW").toString());
		boardService.cntUp(board_no,board_view+1);
		model.addAttribute("vo", param);
		return "board/detail";
	}
	//-------------------------------게시글 추가-------------------------------------
	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.GET)
	public String insert(HttpSession session,Model model)  {
		int user_no = Integer.parseInt(session.getAttribute("param").toString());		
		int max = boardService.max();
		
		model.addAttribute("user_no", user_no);
		model.addAttribute("max", max+1);
		return "board/insert";
	}
	@RequestMapping(value = "/BoardInsert.do", method = RequestMethod.POST)
	public ModelAndView unsert_ajax(@RequestParam HashMap<String, Object> param) {
		ModelAndView json = new ModelAndView("jsonView");
		boardService.insert(param);
		return json;
	}
	//-------------------------------게시글 삭제-------------------------------------
	@RequestMapping(value = "/BoardDelete.do", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam HashMap<String, Object> param) {
		ModelAndView json = new ModelAndView("jsonView");
		boardService.delete(param);
		return json;
	}
	
	//-------------------------------게시글 수정-------------------------------------
	@RequestMapping(value = "/BoardModify.do", method = RequestMethod.GET)
	public String modify(Model model,int board_no) {
		HashMap<String, Object> vo = boardService.detail(board_no);
		model.addAttribute("vo", vo);
		return "board/modify";
	}
	@RequestMapping(value = "/ModifyBoard.do", method = RequestMethod.POST)
	public ModelAndView modify_ajax(@RequestParam HashMap<String, Object> param) {
		ModelAndView json = new ModelAndView("jsonView");
		
		boardService.modify(param);
		return json;
	}
}
