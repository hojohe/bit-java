package servlet.forward;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/forward/test01")
public class Test01 extends HttpServlet{

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 페이지 자동 이동 - servlet/forward/test01.jsp
		// 이동되는 페이지에서 사용하도록 데이터를 공유영역에 등록한다.
		
		// 공유하려는 데이터
		String msg = "테스트";
		Date time = new Date();
		
		// 공유 영역에 등록
		request.setAttribute("msg", msg);
		request.setAttribute("time", time);
		
		// 페이지를 이동시키기 위한 객체 얻기
		// http://localhost:9090/06_servletjsp/servlet/forward/test01(서블릿 경로)
		// http://localhost:9090/06_servletjsp/servlet/forward/test01.jsp
		
		RequestDispatcher  rd = request.getRequestDispatcher("test01.jsp");
		rd.forward(request, response);
		
		/*
		 * 경로에 "/"로 시작했을때 프로젝트 경로가 자동 포함되는 경우
		 * 1.web.xml
		 * 2. @WebServlet
		 * RequestDispatcher
		 * 
		 */
		
		//RequestDispatcher  rd = request.getRequestDispatcher("/servlet/forward/test01.jsp");
	}
	
}
