package com.study.sboard.SBoardDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.study.sboard.SBoardVO.SBoardVO;

public class SBoardDAOImpl implements SBoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private String Namespace = "com.study.mappers.SBoardMapper";

	@Override
	public List<SBoardVO> list() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(Namespace + ".list");
	}

}
