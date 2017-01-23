package jsp.session;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/jsp/session/login")
public class Login extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// id=a이고 password =1일 경우에만 로그인 성공처리..
		if("a".equals(id) && "1".equals(password)) {
			
			LoginVO login = new LoginVO();
			login.setId("a");
			login.setName("정찬성");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			login.setLoginTime(sdf.format(new Date()));
			
			HttpSession session = request.getSession();
			session.setAttribute("user", login);
			
			response.sendRedirect("main.jsp");
		} 
		// 로그인 실패시 loginForm.jsp로 이동
		else {
			
			request.setAttribute("msg", "입력하신 정보가 올바르지 않습니다.");
			RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
			rd.forward(request, response);
			
		}
		
		
		
	}

}
