package com.study.sboard.SBoardService;

import java.util.List;

import com.study.sboard.SBoardDTO.SBoardVO;

public interface SBoardService {
	
	// 게시글 기본목록
	public List<SBoardVO> list() throws Exception;

	public void write(SBoardVO sboardVO);

	public SBoardVO read(int sno);

	public void delete(int sno);

	public void modify(SBoardVO vo);

	public void postviews(int sno);

	public List<SBoardVO> searchTitle(String searchKeyword);
	public List<SBoardVO> searchContent(String searchKeyword);
	public List<SBoardVO> searchWriter(String searchKeyword);
	public List<SBoardVO> searchTandC(String searchKeyword);

}
