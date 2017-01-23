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

@WebServlet("/board/comment/write")
public class CommentWriteServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		String id = request.getParameter("id");
		String comments = request.getParameter("comments");
		System.out.println("머라고 들어오지? > " + comments.trim());
			CommentVO vo = new CommentVO();
			vo.setNo(no);
			vo.setId(id);
			vo.setComments(comments);
			
			CommentDAO dao = new CommentDAO();
			dao.insertComment(vo);
			
			RequestDispatcher rd = request.getRequestDispatcher("/board/detail");
			rd.forward(request, response);
	}
	
	

}
