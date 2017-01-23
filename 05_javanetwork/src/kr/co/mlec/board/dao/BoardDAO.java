package kr.co.mlec.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.common.db.MyAppSqlConfig;

public class BoardDAO {
	
	private static SqlSession sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
	
	// 전체 게시글 조회
	public List<BoardVO> selectBoard() throws Exception {
		List<BoardVO> boardList = sqlMapper.selectList("kr.co.mlec.board.dao.BoardMapper.getBoardList");
		return boardList;
	}
	
    // 글삭제
	public boolean deleteBoard(int no) throws Exception {
		sqlMapper.delete("kr.co.mlec.board.dao.BoardMapper.deleteBoard", no);
		sqlMapper.commit();
		return true;
	}
}














