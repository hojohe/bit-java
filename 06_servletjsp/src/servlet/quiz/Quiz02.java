package servlet.quiz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/quiz/quiz02")
public class Quiz02 extends HttpServlet {
	
	Random r = new Random();
	private int i = 1;
	public int getI() {
		return i++;
	}
	int resultNum = r.nextInt(100) + 1;


	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		int inputNum = Integer.parseInt(request.getParameter("inputNum"));
		
		String msg = "";
		
		if (inputNum > resultNum) {
			msg = "작은 수를 입력하세요";
		}else if(inputNum < resultNum) {
			msg = "큰 수를 입력하세요";
		}else {
			msg = "정답입니다.";
		}
		
		

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("	<h1>정답 : " + resultNum + "</h1>");
		out.println("	<h1>" + getI() + "회 시도</h1>");
		out.println("	<h1>" + msg + "</h1>");
		out.println("	<a href=\"/06_servletjsp/servlet/quiz/quiz02.html\">다시입력</a>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	
}
