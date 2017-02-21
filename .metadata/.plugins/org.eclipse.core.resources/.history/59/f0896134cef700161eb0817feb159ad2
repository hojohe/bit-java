package kr.co.mlec.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.BoardDAO;

@WebServlet("/board/servlet/delete")
public class DeleteServlet extends HttpServlet {
	
	private BoardDAO dao;
	public DeleteServlet() {
		this.dao = new BoardDAO();
	}
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		dao.deleteBoard(no);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("<html>");
		out.write("<body>");
		if (dao.deleteBoard(no)) {
			out.write("<h2>게시물 삭제가 완료되었습니다.</h2><br>");
		} else {
			out.write("<h2>글번호에 해당하는 게시물이 없습니다.</h2><br>");
		}
		out.write("<a href='list'>목록</a>");
		out.write("</body>");
		out.write("</html>");
		
		out.close();
	}
}
