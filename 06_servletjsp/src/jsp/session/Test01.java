package jsp.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/jsp/session/test01")
public class Test01 extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 세션 가져오기
		// 호출한 사용자와 연관된 세션이 존재한다면 사용하는 세션을 반환하고
		// 연관된 세션이 없다면 새롭게 세션을 생성해서 반환한다.
		HttpSession session = request.getSession();
		
		// JSESSIONID
		String id = session.getId();
		
		session.setMaxInactiveInterval(3); //초단위!!!
		
		out.println("<h1>설정된 JSESSIONID : " + id + "</h1>");
		out.close();
		
	}
	
}
