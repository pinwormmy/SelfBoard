package com.study.sboard.SBoardDAO;

import java.util.List;

import com.study.sboard.SBoardDTO.CommentDTO;
import com.study.sboard.SBoardDTO.SBoardDTO;

public interface SBoardDAO {
	
	public List<SBoardDTO> list() throws Exception;
	
	public void write(SBoardDTO sboardDTO);

	public SBoardDTO read(int sno);
	public List<CommentDTO> readComment(int sno);
	public void writeComment(CommentDTO commentDTO);

	public void delete(int sno);

	public void modify(SBoardDTO sboardDTO);

	public void postviews(int sno);

	public List<SBoardDTO> searchTitle(String searchKeyword);

	public List<SBoardDTO> searchContent(String searchKeyword);

	public List<SBoardDTO> searchWriter(String searchKeyword);
	
	public List<SBoardDTO> searchTandC(String searchKeyword);

	public void deleteComment(CommentDTO commentDTO);

	public CommentDTO readCommentOne(CommentDTO commentDTO);

	public void updateCommentCounter(int postNum);

	

}
