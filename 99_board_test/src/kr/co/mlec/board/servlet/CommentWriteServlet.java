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

@WebServlet("/comment/write")
public class CommentWriteServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("no"));
		String userId = request.getParameter("userId");
		String content = request.getParameter("content");
		
		BoardCommentVO comment = new BoardCommentVO();
		comment.setNo(no);
		comment.setContent(content);
		comment.setUserId(userId);
		
		BoardDAO dao = new BoardDAO();
		dao.insertComment(comment);
		
		
		response.getWriter().println(dao.selectCommentList(no));
		response.getWriter().close();
	
	}
}
