package kr.co.twocamp.controller;
//게시판 검색 기능

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.twocamp.board.BoardService;
import kr.co.twocamp.board.PageMaker;
import kr.co.twocamp.board.SearchCriteria;

@Controller
@RequestMapping ("/board/paging/search")

public class BoardPagingSearchController {
	private static final Logger logger = LoggerFactory.getLogger(BoardPagingSearchController.class);
	
	private final BoardService boardService;
	
	@Inject 
	public BoardPagingSearchController (BoardService boardService) {
		this.boardService = boardService;
	}
	@RequestMapping (value = "/board/list", method = RequestMethod.GET)
	public String list (@ModelAttribute ("searchCriteria") SearchCriteria searchCriteria, Model model) throws Exception {
		logger.info("search list() called....");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(searchCriteria);
		pageMaker.setTotalCount(boardService.countBoard(searchCriteria));
		
		model.addAttribute("board", boardService.listCriteria(searchCriteria));
		model.addAttribute("pageMaker", pageMaker);
		return "board/search/list";
		
	}
	
	
}
