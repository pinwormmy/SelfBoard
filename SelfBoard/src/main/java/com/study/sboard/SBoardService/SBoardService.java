package com.study.sboard.SBoardService;

import java.util.List;

import com.study.sboard.SBoardDTO.CommentDTO;
import com.study.sboard.SBoardDTO.SBoardDTO;

public interface SBoardService {
	
	// 게시글 기본목록
	public List<SBoardDTO> list() throws Exception;

	public void write(SBoardDTO sboardDTO);

	public SBoardDTO read(int sno);
	public List<CommentDTO> readComment(int sno);
	public void writeComment(CommentDTO commentDTO);
	public void deleteComment(CommentDTO commentDTO);
	
	public void delete(int sno);

	public void modify(SBoardDTO dto);

	public void postviews(int sno);

	public List<SBoardDTO> searchTitle(String searchKeyword);
	public List<SBoardDTO> searchContent(String searchKeyword);
	public List<SBoardDTO> searchWriter(String searchKeyword);
	public List<SBoardDTO> searchTandC(String searchKeyword);

	


	

}
