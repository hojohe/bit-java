package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import basic.EmployeesVO;

public class Exam02 {
	
	public static void selectDptmInfo() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�μ���ȣ : ");
		int inputId = Integer.parseInt(sc.nextLine());
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			
			String sql = " select department_id "
						+ ", department_name "
						+ ", manager_id "
						+ " from departments "
						+ "where department_id = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, inputId);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				System.out.println("�Է��Ͻ� �μ����̵�(" + inputId + ") �� �ش��ϴ� �μ����� �����ϴ�.");
				return;
			}
			
			EmployeesVO vo = new EmployeesVO();
			System.out.println("�Է��Ͻ� �μ����̵�(" + inputId + ") �� �ش��ϴ�");
			System.out.println("�μ��� :: " + rs.getString("department_name") );
			System.out.println("�μ��� ���̵� :: " + rs.getString("manager_id") );
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		selectDptmInfo();
	}
}
