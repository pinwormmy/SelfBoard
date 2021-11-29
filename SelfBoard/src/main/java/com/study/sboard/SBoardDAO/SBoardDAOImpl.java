package com.study.sboard.SBoardDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.sboard.SBoardDTO.CommentDTO;
import com.study.sboard.SBoardDTO.SBoardDTO;

@Repository
public class SBoardDAOImpl implements SBoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private String Namespace = "com.study.mappers.SBoardMapper";

	@Override
	public List<SBoardDTO> list() throws Exception {
		return sqlSession.selectList(Namespace + ".list");
	}

	@Override
	public void write(SBoardDTO sboardDTO) {
		sqlSession.insert(Namespace + ".write", sboardDTO);
	}

	@Override
	public SBoardDTO read(int sno) {
		return sqlSession.selectOne(Namespace + ".read", sno);
	}
	
	@Override
	public List<CommentDTO> readComment(int sno) {
		return sqlSession.selectList(Namespace + ".readComment", sno);
	}
	
	@Override
	public void writeComment(CommentDTO commentDTO) {
		sqlSession.insert(Namespace + ".writeComment", commentDTO);
	}
	
	@Override
	public void deleteComment(CommentDTO commentDTO) {
		sqlSession.delete(Namespace + ".deleteComment", commentDTO);
	}

	@Override
	public void delete(int sno) {
		sqlSession.delete(Namespace + ".delete", sno);
	}

	@Override
	public void modify(SBoardDTO sboardDTO) {
		sqlSession.update(Namespace + ".modify", sboardDTO);
	}

	@Override
	public void postviews(int sno) {
		sqlSession.update(Namespace + ".postviews", sno);
	}

	@Override
	public List<SBoardDTO> searchTitle(String searchKeyword) {
		return sqlSession.selectList(Namespace + ".searchtitle", searchKeyword);
	}

	@Override
	public List<SBoardDTO> searchContent(String searchKeyword) {
		return sqlSession.selectList(Namespace + ".searchcontent", searchKeyword);
	}

	@Override
	public List<SBoardDTO> searchWriter(String searchKeyword) {
		return sqlSession.selectList(Namespace + ".searchwriter", searchKeyword);
	}
	
	@Override
	public List<SBoardDTO> searchTandC(String searchKeyword) {
		return sqlSession.selectList(Namespace + ".searchtandc", searchKeyword);
	}

	@Override
	public CommentDTO readCommentOne(CommentDTO commentDTO) {
		return sqlSession.selectOne(Namespace + ".readCommentOne", commentDTO);
	}

}
