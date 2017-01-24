package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import basic.EmployeesVO;

public class Exam01 {

	public static void printEmployee(String cityName, int salary) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		List<EmployeesVO> list = new ArrayList<>();
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			String sql = "  select emp.first_name, emp.salary, loc.city "
						 + "  from employees emp "
						 + " inner join departments dep on emp.department_id = dep.department_id "  
						 + " inner join locations loc on  loc.location_id = dep.location_id "
						 + " where loc.city like ? "
						 + "   and salary >= ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + cityName + "%");
			pstmt.setInt(2, salary);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				EmployeesVO vo = new EmployeesVO();
				vo.setFirstName(rs.getString("first_name"));
				vo.setCity(rs.getString("city"));
				vo.setSalary(rs.getInt("salary"));
				
				list.add(vo);
			}
			
			for (EmployeesVO vo : list) {
				System.out.printf(
						"%-10s\t%-10s\t%10d\n", vo.getCity(), vo.getFirstName(), vo.getSalary());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			con.close();
			pstmt.close();
		}
		
		
	}

	public static void main(String[] args) throws SQLException {
		System.out.println("==============================================");
		printEmployee("cisco", 6000);
		System.out.println("==============================================");
		printEmployee("attle", 15000);
		System.out.println("==============================================");
	}
}
