package ajax.quiz;

import org.apache.ibatis.session.SqlSession;


public class MemberDAO {
	
	private static SqlSession sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
	
	public String getMemberInfo(String id) {
		//회원
		return sqlMapper.selectOne("kr.co.mlec.board.dao.LoginMapper.getId", id);
	}

}
