package com.study.sboard;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.sboard.SBoardService.SBoardService;
import com.study.sboard.SBoardVO.SBoardVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private SBoardService sboardService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception{
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		List<SBoardVO> list = sboardService.list();
		model.addAttribute("list", list);
			
		return "home";
	}
	
	@RequestMapping(value="/write")
	public String write() {
		return "write";
	}
	
	@RequestMapping(value="/write", method = RequestMethod.POST)
	public String writesubmit(SBoardVO sboardVO, RedirectAttributes rttr) {
	
		sboardService.write(sboardVO);
		
		return "redirect:/";
	}
	
}
