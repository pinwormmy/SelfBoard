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

	@Override
	public List<SBoardVO> list() throws Exception {
		return sboardDAO.list();
	}

	@Override
	public void write(SBoardVO sboardVO) {
		sboardDAO.write(sboardVO);
	}

	

}
