package ajax.quiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/11_ajax/quiz/exam02")
public class Exam02 extends HttpServlet {

	QuizDAO dao = new QuizDAO();
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String code = request.getParameter("code");
		String codeName = dao.selectCode(code);
		
		PrintWriter out = response.getWriter();
		out.println(codeName);
		
		out.close();
		
		
	}
	
	

}
