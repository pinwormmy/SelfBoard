package com.study.sboard.SBoardService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.sboard.SBoardDAO.SBoardDAO;
import com.study.sboard.SBoardVO.SBoardVO;

@Service
public class SBoardServiceImpl implements SBoardService {

	@Autowired
	private SBoardDAO sboardDAO;

	// 게시물 목록
	@Override
	public List<SBoardVO> list() throws Exception {
		return sboardDAO.list();
	}

	// 게시물 작성
	@Override
	public void write(SBoardVO sboardVO) {
		sboardDAO.write(sboardVO);
	}

	@Override
	public List<SBoardVO> read(int sno) {
		return sboardDAO.read(sno);
	}
}
