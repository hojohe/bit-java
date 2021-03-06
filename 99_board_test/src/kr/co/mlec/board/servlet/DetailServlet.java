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
import kr.co.mlec.board.vo.BoardFileVO;
import kr.co.mlec.board.vo.BoardVO;

@WebServlet("/board/detail")
public class DetailServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		String commentNo = request.getParameter("commentNo");
		
		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.selectOneBoard(no);
		
		request.setAttribute("board", board);

		List<BoardCommentVO> comment = dao.selectCommentList(no);
		request.setAttribute("comment", comment);
		
		request.setAttribute("commentNo", commentNo);
		
		BoardFileVO file = dao.selectFile(no);
		request.setAttribute("file", file);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/board/detail.jsp");
		rd.forward(request, response);
	
	}

	
}
