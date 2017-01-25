package kr.co.mlec.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.common.db.MyAppSqlConfig;

public class BoardDAO {
	
	static SqlSession sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
	
	public List<BoardVO> selectBoardList() {
		List<BoardVO> board = sqlMapper.selectList(
				"kr.co.mlec.board.dao.BoardMapper.selectBoardList");
		return board;
	}
	
	public BoardVO selectOneBoard(int no) {
		
		BoardVO board = sqlMapper.selectOne(
				"kr.co.mlec.board.dao.BoardMapper.selectOneBoard", no);
		return board;
		
	}
	
	public void insertBoard(BoardVO vo) {
		sqlMapper.insert(
				"kr.co.mlec.board.dao.BoardMapper.insertBoard", vo);
		sqlMapper.commit();
	}
	
	public void updateBoard(int no) {
		sqlMapper.update(
				"kr.co.mlec.board.dao.BoardMapper.updateBoard", no);
		sqlMapper.commit();
	}
	
	public void deleteBoard(int no) {
		sqlMapper.update(
				"kr.co.mlec.board.dao.BoardMapper.deleteBoard", no);
		sqlMapper.commit();
	}
}
