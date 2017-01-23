package kr.co.mlec.board.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.CommentDAO;

@WebServlet("/board/comment/delete")
public class CommentDeleteServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int no = Integer.parseInt(request.getParameter("no"));
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		
		CommentDAO dao = new CommentDAO();
		
		dao.deleteComment(commentNo);
		
		request.setAttribute("no", no);
		RequestDispatcher rd = request.getRequestDispatcher("/board/detail");
		rd.forward(request, response);
			
			
	}
}
