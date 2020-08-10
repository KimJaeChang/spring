package kr.co.twocamp.board;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.twocamp.board.BoardBean;
import kr.co.twocamp.board.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String nameSpace="kr.co.twocamp.board";
	//목록 가져오기
	@Override
	public List<BoardBean>list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".list");
	}
	//글추가
	@Override
	public int register(BoardBean boardBean) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace +".register", boardBean);
	}
	//조회수
	@Override
	public int updateReadCnt(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.update(nameSpace + ".updateReadCnt", bno);
	}
	//상세보기
	@Override
	public BoardBean getDetail(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".detail",bno);
	}
	//수정
	@Override
	public int update(BoardBean bbean) {
		return sqlSession.update(nameSpace +".update", bbean);
		
	}
	//삭제
	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.delete(nameSpace +".delete", bno);
	}
	
	//댓글 작성
	@Override
	public int reply(BoardReply boardReply) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace + ".reply", boardReply);
	}
	//댓글 리스트
	@Override
	public List<BoardReply> getReplywrite(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".replywrite",bno);
	}
	//해당 댓글 조회
	@Override
	public BoardReply detailReply(int reno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace +".detailReply", reno);
	}
	//댓글 수정
	@Override
	public int replyUpdate(BoardReply boardReply) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".replyUpdate", boardReply);
	}
	//댓글 삭제
	@Override
	   public int replyDelete(int reno) {
	      // TODO Auto-generated method stub
	      return sqlSession.delete(nameSpace+ ".replyDelete", reno);
	   }
	//댓글 갯수 카운트
	@Override
	public int replyCnt(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+ ".replyCnt",bno);
	}
	//페이징

		@Override
		public List<BoardBean> listCriteria(Criteria criteria) throws Exception {
			// TODO Auto-generated method stub
			
			return sqlSession.selectList(nameSpace +".listCriteria",criteria);
		}
		@Override
		public int countBoard (Criteria criteria) throws Exception{
			return sqlSession.selectOne(nameSpace + ".countBoard", criteria);
		}
	
	
	
	
	

}
