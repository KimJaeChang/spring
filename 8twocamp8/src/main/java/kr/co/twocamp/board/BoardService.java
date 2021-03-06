package kr.co.twocamp.board;

import java.util.List;

import kr.co.twocamp.board.BoardBean;
import kr.co.twocamp.board.Criteria;

public interface BoardService {
	
	//글 추가
	public int register(BoardBean boardBean);
	//목록 가져오기
	public List<BoardBean> list();
	//조회수
	public int updateReadCnt(int bno);
	//상세보기
	public BoardBean getDetail(int bno);
	//수정
	public int update (BoardBean bbean);
	//삭제
	public int delete(int bno);
	//댓글 작성
	public int reply (BoardReply boardReply);
	//댓글 목록
	public List<BoardReply> getReplywrite(int bno);
	//해당 댓글 조회
	public BoardReply detailReply (int reno);	
	//댓글 수정
	public int replyUpdate(BoardReply boardReply);
	//댓글 삭제
	public int replyDelete(int reno);

	//댓글수 카운트
	public int replyCnt(int bno);
	// 페이징 처리 서비스 메서드
	
    public List<BoardBean> listCriteria(Criteria criteria)throws Exception;

	public int countBoard(Criteria criteria) throws Exception;
}
