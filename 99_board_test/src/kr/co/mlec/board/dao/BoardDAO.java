package kr.co.mlec.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.board.vo.BoardCommentVO;
import kr.co.mlec.board.vo.BoardFileVO;
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
		BoardVO board =  sqlMapper.selectOne(
				"kr.co.mlec.board.dao.BoardMapper.selectOneBoard", no);
		return board;
	}
	
	public int insertBoard(BoardVO board) {
		sqlMapper.insert(
				"kr.co.mlec.board.dao.BoardMapper.insertBoard", board);
		sqlMapper.commit();
		return board.getNo();
	}
	public void updateBoard(BoardVO board) {
		sqlMapper.update(
				"kr.co.mlec.board.dao.BoardMapper.updateBoard", board);
		sqlMapper.commit();
	}
	public void deleteBoard(int no) {
		sqlMapper.delete(
				"kr.co.mlec.board.dao.BoardMapper.deleteBoard", no);
		sqlMapper.commit();
	}
	
	
	public List<BoardCommentVO> selectCommentList(int no) {
		List<BoardCommentVO> comment = sqlMapper.selectList(
				"kr.co.mlec.board.dao.BoardMapper.selectCommentList", no);
		return comment;
	}
	public void insertComment(BoardCommentVO comment) {
		sqlMapper.insert(
				"kr.co.mlec.board.dao.BoardMapper.insertComment", comment);
		sqlMapper.commit();
	}
	public void updateComment(BoardCommentVO comment) {
		sqlMapper.update(
				"kr.co.mlec.board.dao.BoardMapper.updateComment", comment);
		sqlMapper.commit();
	}
	public void deleteComment(int commentNo) {
		sqlMapper.delete(
				"kr.co.mlec.board.dao.BoardMapper.deleteComment", commentNo);
		sqlMapper.commit();
	}
	
	public BoardFileVO selectFile(int no) {
		BoardFileVO file = sqlMapper.selectOne(
				"kr.co.mlec.board.dao.BoardMapper.selectFile", no);
		return file;
	}
	public void insertFile(BoardFileVO file) {
		sqlMapper.insert(
				"kr.co.mlec.board.dao.BoardMapper.insertFile", file);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
