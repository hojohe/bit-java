package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) {
		
		Connection con = null;
		// ��� ȿ���� ����. ����ó��, complie�� �̸� �س���, ����ó������(dynamic)
		PreparedStatement pstmt = null;
		
		try {
			// 1�ܰ�. ����̹� �ε�
			// ����Ŭ ����̹� Ŭ������ : ����Ŭ ����
			// ojdbc14.jar�� ���Ե� Ŭ������(��Ű�� ����)
			Class.forName("oracle.jdbc.driver.OracleDriver"); // Ŭ���� not found : �����н� ���� x �Ǵ� ��Ÿ�� Ŭ�������� ��ã��
			System.out.println("����̹� �ε� ����");
			
			// 2�ܰ�. ���ᰴü ������
			// jdbc ����Ʈ���� ����ϰڴ�. 127.0.0.1 or localhost or ����Ŭ ��ġ�� ip / port : 8080 ������ ���� 1521 ���� DB ����
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");	
			System.out.println("�������� : " + con);
			
			// 3�ܰ� : SQL �� �ۼ��ϱ�
			String sql = "insert into tb_board(no, title, writer, content) "
					   + "values(s_board_no.nextVal, 'test', 'hong', 'exam')";
			
			// 4�ܰ� : SQL ���� ��ü ���
			pstmt = con.prepareStatement(sql);
			
			// 5�ܰ� : SQL ����
			int cnt = pstmt.executeUpdate();
			
			// 6�ܰ� �� ��� ó��
			System.out.println(cnt + "���� ���� ����Ǿ����ϴ�.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			// 7�ܰ� : ��ü �ݱ�
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
