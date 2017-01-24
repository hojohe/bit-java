package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test05 {
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");	
			
			String sql = "insert into tb_board(no, title, writer, content) "
					   + "values(s_board_no.nextVal, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "연습중..");
			pstmt.setString(2, "홍길동");
			pstmt.setString(3, "정말 연습중..");
			
			int cnt = pstmt.executeUpdate();
			
			
			System.out.println(cnt + "개의 행이 등록되었습니다.");
			
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
