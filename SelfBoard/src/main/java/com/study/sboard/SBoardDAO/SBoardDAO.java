package com.study.sboard.SBoardDAO;

import java.util.List;

import com.study.sboard.SBoardVO.SBoardVO;

public interface SBoardDAO {
	
	public List<SBoardVO> list() throws Exception;

}
