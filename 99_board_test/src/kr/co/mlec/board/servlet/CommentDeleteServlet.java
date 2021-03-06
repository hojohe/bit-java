package kr.co.mlec.board.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardCommentVO;
import kr.co.mlec.board.vo.BoardVO;

@WebServlet("/comment/delete")
public class CommentDeleteServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		System.out.println(commentNo + "########안녕???");
		BoardDAO dao = new BoardDAO();
		dao.deleteComment(commentNo);
		
		
		response.sendRedirect(request.getContextPath() + "/board/detail?no="+no);
	
	
	}
}
