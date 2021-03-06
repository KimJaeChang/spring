package kr.co.twocamp.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import kr.co.twocamp.camp.CampBean;
import kr.co.twocamp.camp.CampService;
import kr.co.twocamp.camp.Criteria;
import kr.co.twocamp.camp.PageMaker;

@Controller
public class CampController {

	private static final Logger logger = LoggerFactory.getLogger(CampController.class);
	
	@Inject
	CampService campService;
	
	@RequestMapping(value = "camp/camplist", method = RequestMethod.GET)
	public ModelAndView camplist(Criteria criteria) throws Exception{
		logger.info("==============camplist=================");
		ModelAndView mav = new ModelAndView();
		
		List<CampBean> list = campService.camplist();
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(10);
		
		mav.addObject("camplist", list);
		mav.setViewName("camplist");
		
		return mav;
	}
}
