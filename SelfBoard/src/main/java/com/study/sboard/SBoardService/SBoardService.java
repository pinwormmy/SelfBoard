package com.study.sboard.SBoardService;

import java.util.List;

import com.study.sboard.SBoardVO.SBoardVO;

public interface SBoardService {
	
	// 글 목록
	public List<SBoardVO> list() throws Exception;

	// 글 작성
	public void write(SBoardVO sboardVO);

	public SBoardVO read(int sno);

	public void delete(int sno);

	public void modify(SBoardVO vo);

}
