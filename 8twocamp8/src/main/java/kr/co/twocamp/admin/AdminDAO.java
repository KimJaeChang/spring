package kr.co.twocamp.admin;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAO {

	@Inject
	private SqlSession sqlSession;

	// 전체목록보기
	public int signup(AdminBean adminBean) throws Exception {
		return sqlSession.insert("admin.signup", adminBean);
	}

	// 전체목록보기
	public Map login(Map<String, String> map) throws Exception {
		return sqlSession.selectOne("admin.login", map);
	}

}
