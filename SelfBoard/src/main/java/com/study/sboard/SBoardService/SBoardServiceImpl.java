package com.study.sboard.SBoardService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.study.sboard.SBoardDAO.SBoardDAO;
import com.study.sboard.SBoardVO.SBoardVO;

@Service
public class SBoardServiceImpl implements SBoardService {

	
	private SBoardDAO sboardDAO;

	@Override
	public List<SBoardVO> list() throws Exception {
		// TODO Auto-generated method stub
		return sboardDAO.list();
	}

	

}
