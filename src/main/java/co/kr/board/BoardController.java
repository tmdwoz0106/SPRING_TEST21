package co.kr.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.kr.board.service.BoardService;

@Controller
public class BoardController {
	//1111111ReSetTest Success 
	@Autowired
	public BoardService boardService;
}
