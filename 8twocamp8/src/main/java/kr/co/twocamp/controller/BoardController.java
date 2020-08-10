package kr.co.twocamp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.twocamp.board.Criteria;
import kr.co.twocamp.board.PageMaker;
import kr.co.twocamp.board.BoardBean;
import kr.co.twocamp.board.BoardReply;
import kr.co.twocamp.board.BoardService;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	BoardService boardService;


	// 목록 조회
	@RequestMapping(value = "board/list", method = RequestMethod.GET)
	public ModelAndView list(Model model, Criteria criteria) throws Exception{
		logger.info("===list, list, list===");
		ModelAndView mav = new ModelAndView();

		List<BoardBean> list = boardService.list();
		for(int i=0;i<list.size();i++) {
			int a = boardService.replyCnt(list.get(i).getBno());
			if(a!=0) {
			String b = Integer.toString(a);
			String replycnt =list.get(i).getTitle() +" ("+b+")";
			list.get(i).setTitle(replycnt);
			}
		}
		

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(boardService.countBoard(criteria));
		
//		model.addAttribute("board", boardService.listCriteria(criteria));
//		model.addAttribute("pageMaker", pageMaker);
		mav.addObject("board",boardService.listCriteria(criteria));
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("list", list);
		mav.setViewName("list");
		
		return mav;
	}

	// 글쓰기 get 방식
	@RequestMapping(value = "board/register", method = RequestMethod.GET)
	public String register() {
		logger.info("글쓰기로 이동");
		return "register";
	}

	// 글쓰기 post 방식
	@RequestMapping(value = "board/register", method = RequestMethod.POST)
	public String register(BoardBean boardBean, RedirectAttributes rttr) {
				
		int r = boardService.register(boardBean);
		if (r > 0) {
			rttr.addFlashAttribute("msg", "게시판 글 등록에 성공하였습니다.");
			
			return "redirect:list";
		}
		
		else if(r==-1){
			logger.info("제목이 없습니다.");
		}
		else if(r==-2) {
			logger.info("내용이 없습니다.");
		}
			return "redirect:register";
		}



	// 글 상세보기
	@RequestMapping(value = "board/detail", method = RequestMethod.GET)
	public String detail(@RequestParam("bno") int bno, Model model) {

		boardService.updateReadCnt(bno);// 조회수
		BoardBean boardBean = boardService.getDetail(bno);
		model.addAttribute("board", boardBean);
		
//		//댓글 목록 조회
//		List<BoardReply> replylist = boardService.getReplywrite(bno);
//		model.addAttribute("list", replylist);

		return "detail";

	}

	// 수정 GET 방식
	@RequestMapping(value = "board/update", method = RequestMethod.GET)
	public String update(@RequestParam("bno") int bno, Model model) {
		BoardBean board = boardService.getDetail(bno);
		model.addAttribute("board", board);

		return "update";

	}

	// 수정 POST 방식
	@RequestMapping(value = "board/update", method = RequestMethod.POST)
	public String update(BoardBean boardbean, RedirectAttributes attr) {
		int r = boardService.update(boardbean);

		if (r > 0) {
			attr.addFlashAttribute("msg", "수정에 성공 하였습니다.");
			return "redirect:detail?bno=" + boardbean.getBno();
		}
		return "redirect:update?bno=" + boardbean.getBno();
	}

	// 삭제
	@RequestMapping(value = "board/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("bno") int bno, RedirectAttributes rttr) {
		int r = boardService.delete(bno);

		if (r > 0) {
			rttr.addFlashAttribute("msg", "글삭제에 성공하였습니다.");
			return "redirect:list";
		}
		return "redirect:detail?bno=" + bno;
	}
	
//	//댓글 작성 get방식
//	@RequestMapping (value ="board/reply",method =RequestMethod.GET)
//	public String saveReply() {
//		return "reply";
//		
//	}
//	//댓글작성 post 방식
//	@RequestMapping (value ="board/reply", method = RequestMethod.POST)
//	public String Reply(BoardReply boardReply) {
//		int r = boardService.reply(boardReply);
//		
//		if (r>0) {
//			return "redirect:detail?bno=" +boardReply.getBno();
//		}
//		return "reply";
//		
//	}
	
	//댓글 목록 ajax
	@ResponseBody
	@RequestMapping(value ="board/replywrite", method =RequestMethod.POST)
	public List<BoardReply> replywrite(@RequestParam("bno")int bno){
		return boardService.getReplywrite(bno);
	}
	
	//댓글쓰기 ajax
	   @ResponseBody
	   @RequestMapping(value="board/reply", method = RequestMethod.POST)
	   public Map<String , Object> reply(BoardReply boardreply) {
	      Map<String , Object> result = new HashMap<>();      
	      try{
	          boardService.reply(boardreply);  // 추가
	         result.put("status", "OK");
	      }
	      catch(Exception e) {
	         e.printStackTrace();
	         result.put("status", "Fail");
	      }
	      
	      return result;
	   }
	
	//댓글 수정 ajax
	@ResponseBody
	@RequestMapping(value = "board/replyUpdate", method =RequestMethod.POST)
	public Map<String, Object> replyUpdate (BoardReply boardReply){
		Map <String, Object> result = new HashMap<>();
		
		try {
			boardService.replyUpdate(boardReply);
			result.put("status", "OK");
		}
		catch (Exception e) {
			e.printStackTrace();
			result.put("status", "Fail");
		}
		return result;
	}
	@ResponseBody
	   @RequestMapping(value = "board/replyDelete", method = RequestMethod.POST)
	   public Map<String, Object> replyDelete(@RequestParam("reno") int reno) {
	      
	      Map<String , Object> result = new HashMap<>();
	      
	      try{
	         boardService.replyDelete(reno);  // 수정 또는 삭제
	         result.put("status", "OK");
	      }
	      catch(Exception e) {
	         e.printStackTrace();
	         result.put("status", "Fail");
	      }
	      
	      return result;
	   }	
	
	

	
	
}
