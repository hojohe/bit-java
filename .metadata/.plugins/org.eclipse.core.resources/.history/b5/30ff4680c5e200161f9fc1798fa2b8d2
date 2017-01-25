package kr.co.mlec.board.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.CommentDAO;
import kr.co.mlec.board.vo.CommentVO;

@WebServlet("/board/comment/update")
public class CommentUpdateServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		int no = Integer.parseInt(request.getParameter("no"));
		String comments = request.getParameter("comments");
		
		CommentVO vo = new CommentVO();
		vo.setCommentNo(commentNo);
		vo.setComments(comments);
		
		CommentDAO dao = new CommentDAO();
		dao.updateComment(vo);
		
		request.setAttribute("no", no);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/detail");
		rd.forward(request, response);
	}
	
}