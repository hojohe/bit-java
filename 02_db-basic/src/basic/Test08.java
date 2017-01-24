package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Test08 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		List<BoardVO> list = new ArrayList<>(); 
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			
			String sql = "select no, title, writer, reg_date "
						+ "from tb_board "
						+ "order by no desc ";
			
			
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				
				vo.setNo(rs.getInt("no"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				// 시분초 정보가 없음..
				//vo.setRegDate(rs.getDate("reg_date"));
				// 시분초 정보를 유지하기
				vo.setRegDate(rs.getTimestamp("reg_date"));
				
				list.add(vo);
			}
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for(BoardVO vo : list) {
				System.out.printf(
						"%3d\t%-10s\t%-10s\t%10s\n",
						vo.getNo(), vo.getTitle(), vo.getWriter(), sdf.format(vo.getRegDate()));
			}
			
			
		} catch(Exception e) {
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
