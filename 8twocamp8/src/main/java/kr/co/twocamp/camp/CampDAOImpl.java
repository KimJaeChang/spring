package kr.co.twocamp.camp;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


@Repository
public class CampDAOImpl implements CampDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String nameSpace="kr.co.twocamp.camp";

	@Override
	public List<CampBean> camplist() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".camplist");
	}





		
}
