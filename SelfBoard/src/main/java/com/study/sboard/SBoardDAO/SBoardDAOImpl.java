package com.study.sboard.SBoardDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.sboard.SBoardVO.SBoardVO;

@Repository
public class SBoardDAOImpl implements SBoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private String Namespace = "com.study.mappers.SBoardMapper";

	@Override
	public List<SBoardVO> list() throws Exception {
		return sqlSession.selectList(Namespace + ".list");
	}

	@Override
	public void write(SBoardVO sboardVO) {
		sqlSession.insert(Namespace + ".write", sboardVO);
	}

	@Override
	public SBoardVO read(int sno) {
		return sqlSession.selectOne(Namespace + ".read", sno);
	}

	@Override
	public void delete(int sno) {
		sqlSession.delete(Namespace + ".delete", sno);
	}

	@Override
	public void modify(SBoardVO vo) {
		sqlSession.update(Namespace + ".modify", vo);
	}

	@Override
	public void postviews(int sno) {
		sqlSession.update(Namespace + ".postviews", sno);
	}

}
