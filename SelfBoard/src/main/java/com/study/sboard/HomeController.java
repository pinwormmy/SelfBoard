package com.study.sboard;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.sboard.SBoardDTO.CommentDTO;
import com.study.sboard.SBoardDTO.MemberDTO;
import com.study.sboard.SBoardDTO.PageDTO;
import com.study.sboard.SBoardDTO.SBoardDTO;
import com.study.sboard.SBoardService.MemberService;
import com.study.sboard.SBoardService.PageService;
import com.study.sboard.SBoardService.SBoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private SBoardService sboardService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private PageService pageService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) throws Exception{
		
		List<SBoardDTO> list = sboardService.list();
		model.addAttribute("list", list);
		
		PageDTO pageDTO = new PageDTO();
		pageDTO.setPageNum(1);
		pageDTO.setTotalnumPost(list.size());
		pageService.DividePage(pageDTO);
		model.addAttribute("page", pageDTO);
				
		return "home";
	}
	
	@RequestMapping(value="/write")
	public String write() {
		return "write";
	}
	
	@RequestMapping(value="/writesubmit")
	public String writesubmit(SBoardDTO sboardDTO) {
	
		sboardService.write(sboardDTO);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/Bpost", method = RequestMethod.GET)
	public String bpost(int sno, Model model) throws Exception {
		
		SBoardDTO read = sboardService.read(sno);
		model.addAttribute("read", read);
		
		List<CommentDTO> readComment = sboardService.readComment(sno);
		model.addAttribute("readComment", readComment);
		
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
		SBoardDTO read = sboardService.read(sno);
		model.addAttribute("read", read);
		
		return "modify";
	}
	
	@RequestMapping(value="/modifysubmit")
	public String modifysubmit(SBoardDTO sboardDTO) {
	
		sboardService.modify(sboardDTO);
		
		return "redirect:/Bpost?sno=" + sboardDTO.getSno();
	}
	
	@RequestMapping(value="/search")
	public String search(String searchOption, String searchKeyword, int pageNum, Model model) throws Exception {
		
		List<SBoardDTO> list = null;
		// ?????? ????????? ?????? ?????????
		if(searchOption.equals("title"))
			list = sboardService.searchTitle(searchKeyword);
		else if(searchOption.equals("content"))
			list = sboardService.searchContent(searchKeyword);
		else if(searchOption.equals("writer"))
			list = sboardService.searchWriter(searchKeyword);
		else // ??????+??????
			list = sboardService.searchTandC(searchKeyword);
		
		model.addAttribute("list", list);
		
		PageDTO pageDTO = new PageDTO();
		pageDTO.setPageNum(pageNum);
		pageDTO.setTotalnumPost(list.size());
		pageService.DividePage(pageDTO);
		
		model.addAttribute("page", pageDTO);
		
		pageDTO.setSearchOption(searchOption);
		pageDTO.setSearchKeyword(searchKeyword);
		
		return "home";
	}
	
	@RequestMapping(value="/pwcheck")
	public String pwcheck(int sno, Model model) {
		SBoardDTO read = sboardService.read(sno);
		model.addAttribute("read", read);
		
		return "pwcheck";
	}
	
	@RequestMapping(value="/checkCommentPassword")
	public String checkCommentPassword(CommentDTO commentDTO, Model model) {
		CommentDTO readCommentOne = sboardService.readCommentOne(commentDTO);
		model.addAttribute("readComment", readCommentOne);
		
		return "checkCommentPassword";
	}
	
	@RequestMapping(value="/signup")
	public String signup() {
		
		return "signup";
	}
	
	@ResponseBody
	@RequestMapping(value="/signupIdCheck", method = RequestMethod.POST)
	public int signupIdCheck(HttpServletRequest httpServletRequest) throws Exception{
				
		String userId = httpServletRequest.getParameter("userId");
		int checkIdResult = memberService.ckeckId(userId);
		
		return checkIdResult;
	}
	
	@RequestMapping(value="/signupsubmit", method = RequestMethod.POST)
	public String signupsubmit(MemberDTO memberDTO) throws Exception {
		
		memberService.signup(memberDTO);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(MemberDTO memberDTO, HttpServletRequest httpServletRequest, 
			RedirectAttributes redirectAttributes) throws Exception{
		
		HttpSession session = httpServletRequest.getSession();
		MemberDTO login = memberService.login(memberDTO);
		
		if(login == null) {
			session.setAttribute("member", null);
			redirectAttributes.addFlashAttribute("loginerror", false);
		}
		else
		{
			session.setAttribute("member", login);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/commentSubmit")
	public String writeComment(CommentDTO commentDTO) throws Exception{
		
		sboardService.writeComment(commentDTO);
		sboardService.updateCommentCounter(commentDTO.getPostNum());
		
		return "redirect:/Bpost?sno=" + commentDTO.getPostNum();
	}
	
	@RequestMapping(value="/deleteComment")
	public String deleteComment(CommentDTO commentDTO) {
		
		sboardService.deleteComment(commentDTO);
		sboardService.updateCommentCounter(commentDTO.getPostNum());
		
		return "redirect:/Bpost?sno=" + commentDTO.getPostNum();
	}
}
