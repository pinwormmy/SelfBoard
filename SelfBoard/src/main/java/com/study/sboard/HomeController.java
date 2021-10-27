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
		
		// 게시판 글목록
		List<SBoardVO> list = sboardService.list();
		model.addAttribute("list", list);
			
		return "home";
	}
	
	// 글쓰기 버튼 눌러서 작성 페이지 이동
	@RequestMapping(value="/write")
	public String write() {
		return "write";
	}
	
	// 글 작성 완료 누르면 글 게시하고 다시 글목록 으로 복귀
	@RequestMapping(value="/writesubmit")
	public String writesubmit(SBoardVO vo) {
	
		sboardService.write(vo);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/Bpost", method = RequestMethod.GET)
	public String bpost(int sno, Model model) throws Exception {
		
		SBoardVO read = sboardService.read(sno);
		model.addAttribute("read", read);
		
		sboardService.postviews(sno);
	
		return "Bpost";
	}
	
	@RequestMapping(value="/delete")
	public String delete(int sno) {
		sboardService.delete(sno);
		return "redirect:/";
	}
	
	@RequestMapping(value="/modify")
	public String modify(int sno, Model model) {
		SBoardVO read = sboardService.read(sno);
		model.addAttribute("read", read);
		
		return "modify";
	}
	
	
	@RequestMapping(value="/modifysubmit")
	public String modifysubmit(SBoardVO vo) {
	
		sboardService.modify(vo);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/search")
	public String search(String searchOption, String searchKeyword, Model model) {
		
		List<SBoardVO> list = null;
		
		System.out.println("옵션 받은 값 : " + searchOption);
		
		if(searchOption.equals("title"))
		{
			System.out.println("검색 카테고리 : " + searchOption);
			list = sboardService.searchTitle(searchKeyword);
		}
		else if(searchOption.equals("content"))
			list = sboardService.searchContent(searchKeyword);
		else if(searchOption.equals("writer"))
			list = sboardService.searchWriter(searchKeyword);
		else
		{
			System.out.println("조건문 발동 안됨, 혹은 제목+내용 선택");
			list = sboardService.searchTandC(searchKeyword);
		}
		
		
		model.addAttribute("list", list);
		
		return "home";
	}
}
