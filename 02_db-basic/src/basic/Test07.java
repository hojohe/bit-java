package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test07 {
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			// �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// ����
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			
			// sql��
			String sql = "delete from tb_board where no = ? ";
			
			// ��ü ����
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, 7);
			
			// ����
			int cnt = pstmt.executeUpdate();
			
			// ���
			System.out.println(cnt + "���� ���� �����Ǿ����ϴ�.");
			
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
