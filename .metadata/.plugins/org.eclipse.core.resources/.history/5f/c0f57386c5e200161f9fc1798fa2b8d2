package kr.co.mlec.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import kr.co.mlec.board.vo.CommentVO;
import kr.co.mlec.common.db.MyAppSqlConfig;

public class CommentDAO {
	
	public static SqlSession sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
	
	
	public List<CommentVO> selectComment(int no) {
		List<CommentVO> list = sqlMapper.selectList(
				"kr.co.mlec.board.dao.CommentMapper.selectComment", no);
		return list;
	}
	
	public void insertComment(CommentVO comment) {
		sqlMapper.insert(
				"kr.co.mlec.board.dao.CommentMapper.insertComment", comment);
		sqlMapper.commit();
	}
	
	public void deleteComment(int no) {
		sqlMapper.delete(
				"kr.co.mlec.board.dao.CommentMapper.deleteComment", no);
		sqlMapper.commit();
	}
	public void updateComment(CommentVO comment) {
		sqlMapper.update(
				"kr.co.mlec.board.dao.CommentMapper.updateComment", comment);
		sqlMapper.commit();
	}
	
}
