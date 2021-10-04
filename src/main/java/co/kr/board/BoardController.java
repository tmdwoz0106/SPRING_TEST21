package co.kr.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.kr.board.service.BoardService;

@Controller
public class BoardController {
	//test -seo
	@Autowired
	public BoardService boardService;
}
