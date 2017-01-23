package servlet.quiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/quiz/quiz01")
public class Quiz01 extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		String calculator= request.getParameter("calculator");
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int resultNum = 0;
		String type="";

		System.out.println(calculator);
		switch(calculator) {
			case "1":
				resultNum = num1 + num2;
				type = "+";
				break;
			case "2":
				resultNum = num1 - num2;
				type = "-";
				break;
			case "3":
				resultNum = num1 * num2;
				type = "*";
				break;
			case "4":
				resultNum = num1 / num2;
				type = "/";
				break;
		}

		response.setContentType("text/html; charset=utf-8"); 
		
		PrintWriter out = response.getWriter();
		
	
		out.println(	num1 + " " + type + " " + num2 + " = " + resultNum + "<br>");
		out.println("	<a href=\"/06_servletjsp/servlet/quiz/quiz01.html\">다시계산</a><br>");
		out.println("</body>");
		out.println("</html>");
		out.close();	
		
		
	}
	

}
