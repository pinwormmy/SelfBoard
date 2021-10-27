package com.study.sboard.SBoardDAO;

import java.util.List;

import com.study.sboard.SBoardVO.SBoardVO;

public interface SBoardDAO {
	
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
