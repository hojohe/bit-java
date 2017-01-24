package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test02 {
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1�ܰ� ����̺� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2�ܰ� DB ����
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			
			// 3�ܰ� sql �ۼ�
			String sql = "update tb_board "
					   + "set title = '������...' "
					   + "where no = 20 ";
			
			// 4�ܰ�
			pstmt = con.prepareStatement(sql);
			
			// 5�ܰ�
			int cnt = pstmt.executeUpdate();
			
			// 6�ܰ� 
			System.out.println(cnt + "���� ���� ����Ǿ����ϴ�.");
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			// 7�ܰ�
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
