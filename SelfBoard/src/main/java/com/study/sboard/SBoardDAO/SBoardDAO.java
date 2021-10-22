package com.study.sboard.SBoardDAO;

import java.util.List;

import com.study.sboard.SBoardVO.SBoardVO;

public interface SBoardDAO {
	
	public List<SBoardVO> list() throws Exception;
	
	public void write(SBoardVO sboardVO);

	public SBoardVO read(int sno);

	public void delete(int sno);

	public void modify(SBoardVO vo);

}
