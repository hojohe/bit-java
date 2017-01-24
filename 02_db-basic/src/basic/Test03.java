package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test03 {
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			// 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 연결
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			
			// sql문
			String sql = "delete from tb_board where no = 20 ";
			
			// 객체 생성
			pstmt = con.prepareStatement(sql);
			
			// 실행
			int cnt = pstmt.executeUpdate();
			
			// 결과
			System.out.println(cnt + "개의 행이 삭제되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
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
