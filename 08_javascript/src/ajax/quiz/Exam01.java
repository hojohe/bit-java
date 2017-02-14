package ajax.quiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/11_ajax/quiz/exam01")
public class Exam01 extends HttpServlet {

	QuizDAO dao = new QuizDAO();
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String id = request.getParameter("id");
		String validId = dao.getMemberInfo(id);
		
		PrintWriter out = response.getWriter();
		if(id.equals(validId)) {
			out.println("이미 사용중인 아이디 입니다.");
		} else {
			out.println("사용가능한 아이디 입니다.");
		}
		
		out.close();
		
		
	}
	
	

}
