package ajax.quiz;

import org.apache.ibatis.session.SqlSession;


public class QuizDAO {
	
	private static SqlSession sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
	
	public String getMemberInfo(String id) {
		//아이디
		return sqlMapper.selectOne("kr.co.mlec.board.dao.LoginMapper.getId", id);
	}
	public String selectCode(String code) {
		//코드
		return sqlMapper.selectOne("kr.co.mlec.board.dao.LoginMapper.selectCode", code);
	}

}
