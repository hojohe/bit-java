package servlet.send;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/send/test01")
public class Test01 extends HttpServlet{

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String msg = "redirect는 데이터 공유 안됨";
		request.setAttribute("msg", msg);
		// sendRedirect - 이동
		// http://localhost:9090/06_servletjsp/servlet/send/test01(서블릿 경로)
		// http://localhost:9090/06_servletjsp/servlet/send/test01.jsp
		
		/*
		 * Forward와 다르게 "/"로 시작할 경우 프로젝트 경로를 표시해야 한다. 
		 */
//		response.sendRedirect("/06_servletjsp/servlet/send/test01.jsp");
		response.sendRedirect("test01.jsp");
	}
	
}
