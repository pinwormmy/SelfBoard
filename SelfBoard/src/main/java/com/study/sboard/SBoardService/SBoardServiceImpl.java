package com.study.sboard.SBoardService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.sboard.SBoardDAO.SBoardDAO;
import com.study.sboard.SBoardDTO.CommentDTO;
import com.study.sboard.SBoardDTO.SBoardDTO;

@Service
public class SBoardServiceImpl implements SBoardService {

	@Autowired
	private SBoardDAO sboardDAO;

	// 게시판 기본목록
	@Override
	public List<SBoardDTO> list() throws Exception {
		return sboardDAO.list();
	}

	@Override
	public void write(SBoardDTO sboardDTO) {
		sboardDAO.write(sboardDTO);
	}

	@Override
	public SBoardDTO read(int sno) {
		return sboardDAO.read(sno);
	}
	
	@Override
	public List<CommentDTO> readComment(int sno) {
		return sboardDAO.readComment(sno);
	}

	@Override
	public void delete(int sno) {
		sboardDAO.delete(sno);
	}

	@Override
	public void modify(SBoardDTO sboardDTO) {
		sboardDAO.modify(sboardDTO);
	}

	public void postviews(int sno) {
		sboardDAO.postviews(sno);
	}

	// 검색 옵션에 따른 4가지 조회방법
	@Override
	public List<SBoardDTO> searchTitle(String searchKeyword) {
		return sboardDAO.searchTitle(searchKeyword);
	}
	@Override
	public List<SBoardDTO> searchContent(String searchKeyword) {
		return sboardDAO.searchContent(searchKeyword);
	}
	@Override
	public List<SBoardDTO> searchWriter(String searchKeyword) {
		return sboardDAO.searchWriter(searchKeyword);
	}
	@Override
	public List<SBoardDTO> searchTandC(String searchKeyword) {
		return sboardDAO.searchTandC(searchKeyword);
	}

	
}
