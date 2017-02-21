package kr.co.mlec.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;

@WebServlet("/board/servlet/detail")
public class DetailServlet extends HttpServlet {
	private BoardDAO dao;
	public DetailServlet() {
		this.dao = new BoardDAO();
	}

	@Override
	public void service(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
		BoardVO boardVO = dao.selectOneBoard(Integer.parseInt(request.getParameter("no")));
		
		response.setContentType("text/html; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		out.write("<html>");
		out.write("<body>");
		out.write("<hr>");
		if (boardVO != null) {
			out.write("번호 : " + boardVO.getNo() + "<br>");
			out.write("제목 : " + boardVO.getTitle() + "<br>");
			out.write("글쓴이 : " + boardVO.getWriter() + "<br>");
			out.write("내용 : " + boardVO.getContent() + "<br>");
			out.write(
					"등록일 : " + 
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(boardVO.getRegDate()) + "<br>");
		} else {
			out.write("글번호에 해당하는 게시물이 없습니다.");
		}
		out.write("<hr>");
		out.write("<a href='updateForm?no="+ boardVO.getNo() +"'>수정</a>");
		out.write("<a href='delete?no="+ boardVO.getNo() +"'>삭제</a>");
		out.write("<a href='list'>목록</a>");
		out.write("</body>");
		out.write("</html>");
		
	}

}
