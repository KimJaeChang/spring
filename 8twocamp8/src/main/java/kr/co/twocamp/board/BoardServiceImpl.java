	package kr.co.twocamp.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sun.media.jfxmedia.logging.Logger;

import kr.co.twocamp.board.BoardBean;
import kr.co.twocamp.board.Criteria;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDAO boardDAO;

	// 목록
	@Override
	public List<BoardBean> list() {
		// TODO Auto-generated method stub
		return boardDAO.list();
	}

	// 글 추가
	@Override
	public int register(BoardBean boardBean) {
		// TODO Auto-generated method stub
		if (boardBean.getTitle().equals("")) {
			return -1;
		} else if (boardBean.getContent().equals("")) {
			return -2;
		}
		return boardDAO.register(boardBean);
	}

	// 조회수
	@Override
	public int updateReadCnt(int bno) {
		return boardDAO.updateReadCnt(bno);

	}

	// 상세보기
	@Override
	public BoardBean getDetail(int bno) {
		// TODO Auto-generated method stub
		return boardDAO.getDetail(bno);
	}

	// 수정
	@Override
	public int update(BoardBean bbean) {
		// TODO Auto-generated method stub
		return boardDAO.update(bbean);
	}

	// 삭제
	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub
		return boardDAO.delete(bno);
	}

	// 댓글 작성
	@Override
	public int reply(BoardReply boardReply) {
		// TODO Auto-generated method stub
		return boardDAO.reply(boardReply);
	}

	// 댓글리스트
	@Override
	public List<BoardReply> getReplywrite(int bno) {
		// TODO Auto-generated method stub
		return boardDAO.getReplywrite(bno);
	}

	// 해당 댓글 조회
	@Override
	public BoardReply detailReply(int reno) {
		// TODO Auto-generated method stub
		return boardDAO.detailReply(reno);
	}

	// 댓글 수정
	@Override
	public int replyUpdate(BoardReply boardReply) {
		// TODO Auto-generated method stub
		return boardDAO.replyUpdate(boardReply);
	}

	// 댓글 삭제
	@Override
	public int replyDelete(int reno) {
		// TODO Auto-generated method stub
		return boardDAO.replyDelete(reno);
	}

	// 댓글 갯수 카운트
	@Override
	public int replyCnt(int bno) {
		// TODO Auto-generated method stub
		return boardDAO.replyCnt(bno);
	}

//////////////[페이징 처리 부분]////////////////////////
	@Override
	public List<BoardBean> listCriteria(Criteria criteria) throws Exception {
		return boardDAO.listCriteria(criteria);
	}

	@Override
	public int countBoard(Criteria criteria) throws Exception {
		return boardDAO.countBoard(criteria);
	}

}
