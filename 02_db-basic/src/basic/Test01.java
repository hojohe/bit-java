package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) {
		
		Connection con = null;
		// 사용 효율이 좋다. 보안처리, complie을 미리 해놓음, 동적처리가능(dynamic)
		PreparedStatement pstmt = null;
		
		try {
			// 1단계. 드라이버 로딩
			// 오라클 드라이버 클래스명 : 오라클 제공
			// ojdbc14.jar에 포함된 클래스명(패키지 포함)
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 클래스 not found : 빌드패스 설정 x 또는 오타로 클래스파일 못찾음
			System.out.println("드라이버 로딩 성공");
			
			// 2단계. 연결객체 얻어오기
			// jdbc 프로트콜을 사용하겠다. 127.0.0.1 or localhost or 오라클 설치된 ip / port : 8080 웹에서 접근 1521 직접 DB 접근
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");	
			System.out.println("연결정보 : " + con);
			
			// 3단계 : SQL 문 작성하기
			String sql = "insert into tb_board(no, title, writer, content) "
					   + "values(s_board_no.nextVal, 'test', 'hong', 'exam')";
			
			// 4단계 : SQL 실행 객체 얻기
			pstmt = con.prepareStatement(sql);
			
			// 5단계 : SQL 실행
			int cnt = pstmt.executeUpdate();
			
			// 6단계 ㅣ 결과 처리
			System.out.println(cnt + "개의 행이 변경되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			// 7단계 : 객체 닫기
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
