package com.study.sboard.SBoardService;

import java.util.List;

import com.study.sboard.SBoardVO.SBoardVO;

public interface SBoardService {
	
	public List<SBoardVO> list() throws Exception;

	public void write(SBoardVO sboardVO);

}
