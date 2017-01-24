package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test04 {
	public static void main(String[] args) {
		
		// 조회된 결과값을 저장하기 위한 리스트 선언
		List<EmployeesVO> list = new ArrayList<>();
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
			String sql = "select employee_id, last_name, salary " 
						+ "from employees " 
						+ "order by last_name ";
			pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				EmployeesVO vo = new EmployeesVO();
				vo.setEmployeeId(rs.getInt("employee_id"));
				vo.setLastName(rs.getString("last_name"));
				vo.setSalary(rs.getInt("salary"));
				
				list.add(vo);
			}
			
			for(EmployeesVO vo : list) {
				System.out.printf(
					"%4d\t%10s\t%6d\n", vo.getEmployeeId(), vo.getLastName(), vo.getSalary());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}
}
