package co.kr.reply;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.kr.reply.service.ReplyService;

@Controller
public class ReplyController {

	@Autowired
	public ReplyService replyService;
	//2021년 10월 07일
	//오후 4시11분 커밋
	//댓글 추가 삭제 수정 댓글보여주기
	@RequestMapping(value = "/replyInsert.do", method = RequestMethod.GET)
	public String replyInsert(@RequestParam HashMap<String, Object> param) {
		
		replyService.insert(param);

		return "redirect:/BoardDetail.do?board_no="+Integer.parseInt(param.get("board_no").toString());
	}
	//--------------------------------댓글 삭제-------------------------------------
	@RequestMapping(value = "/replyDelete.do", method = RequestMethod.POST)
	public ModelAndView replyDelete(int reply_no) {
		ModelAndView json = new ModelAndView("jsonView");
		replyService.delete(reply_no);
		return json;
	}
	//--------------------------------댓글 수정-------------------------------------
	@RequestMapping(value = "/replyModify.do", method = RequestMethod.GET)
	public String replyModify(@RequestParam  HashMap<String, Object> param) {
		replyService.modify(param);
		return "redirect:/BoardDetail.do?board_no="+Integer.parseInt(param.get("board_no").toString());
	}
}
