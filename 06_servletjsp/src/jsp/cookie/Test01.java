package jsp.cookie;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp/cookie/test01")
public class Test01 extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String value = URLEncoder.encode(request.getParameter("value"), "utf-8");
		
		// 쿠키 생성
		Cookie c = new Cookie(name, value);
		
		// 쿠키 유효시간 설정(초)
		c.setMaxAge(60 * 60); // 1시간 유효한 쿠키
		
		response.addCookie(c);
		
		response.sendRedirect("exam01.jsp");
	
	}
	
	
	
}
