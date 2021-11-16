package com.study.sboard;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.sboard.SBoardDTO.SBoardVO;
import com.study.sboard.SBoardService.SBoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private SBoardService sboardService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) throws Exception{
		
		List<SBoardVO> list = sboardService.list();
		model.addAttribute("list", list);
		
		int pageNum = 1; 
		int displayLimit = 24; // 한 페이지에 표시되는 게시물 수
		int postEndNum = displayLimit * pageNum - 1; 
		int postStartNum = postEndNum - (displayLimit - 1);
		
		model.addAttribute("postStartNum", postStartNum);
		model.addAttribute("postEndNum", postEndNum);
		model.addAttribute("pageNum", pageNum);
		
		
		// 멍하니 되지도 않을 생각하고 있지말고 아무 주석이라도 쓰면서 정리해가며 작성
		// 어차피 쓰고 지우기 편한게 컴퓨터 환경 아니니
		
		int TotalnumPost = list.size();
		int pageLimit = 10;
		int pageStartNum = 1; // default	
		int MaxPageNum = (int)Math.ceil((double)TotalnumPost / displayLimit);
		int pageEndNum = pageStartNum + (pageLimit - 1);
		if(pageEndNum > MaxPageNum)
			pageEndNum = MaxPageNum; // 마지막 페이지묶음 세팅
		
		model.addAttribute("pageStartNum", pageStartNum);
		model.addAttribute("pageEndNum", pageEndNum);
		model.addAttribute("pageLimit", pageLimit);
		model.addAttribute("MaxPageNum", MaxPageNum);
		
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
	public String search(String searchOption, String searchKeyword, int pageNum, Model model) {
		
		List<SBoardVO> list = null;
		// 검색 옵션에 따른 조건문
		if(searchOption.equals("title"))
			list = sboardService.searchTitle(searchKeyword);
		else if(searchOption.equals("content"))
			list = sboardService.searchContent(searchKeyword);
		else if(searchOption.equals("writer"))
			list = sboardService.searchWriter(searchKeyword);
		else // 제목+내용
			list = sboardService.searchTandC(searchKeyword);
		
		model.addAttribute("list", list);
		
		int TotalnumPost = list.size();
		int displayLimit = 24; // 한 페이지에 표시되는 게시물 수
		
		int postEndNum = displayLimit * pageNum - 1; 
		int postStartNum = postEndNum - (displayLimit - 1);
		
		model.addAttribute("postStartNum", postStartNum);
		model.addAttribute("postEndNum", postEndNum);
		
		int MaxPageNum = (int)Math.ceil((double)TotalnumPost / displayLimit);
		
		model.addAttribute("searchOption", searchOption);
		model.addAttribute("searchKeyword", searchKeyword);
		model.addAttribute("pageNum", pageNum);
		
		int pageLimit = 10;
		// 묶음 첫페이지 구하는 공식. 나눗셈은 내림효과가 포함되어 괜히 복잡해보임
		int pageStartNum = (pageNum-1) / pageLimit * pageLimit + 1; 
		int pageEndNum = pageStartNum + (pageLimit - 1);
		if(pageEndNum > MaxPageNum)
			pageEndNum = MaxPageNum; // 마지막 페이지묶음 세팅
		
		model.addAttribute("pageStartNum", pageStartNum);
		model.addAttribute("pageEndNum", pageEndNum);
		model.addAttribute("pageLimit", pageLimit);
		model.addAttribute("MaxPageNum", MaxPageNum);
		
		return "home";
	}
	
	@RequestMapping(value="/pwcheck")
	public String pwcheck(int sno, Model model) {
		SBoardVO read = sboardService.read(sno);
		model.addAttribute("read", read);
		
		return "pwcheck";
	}
	
	@RequestMapping(value="signup")
	public String signup() {
		return "signup";
	}
}
