package servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet/test03")
public class Test03 extends GenericServlet {
	
	// Servlet 생명주기는 init() -> service() -> destroy() 이기 때문에
	// Servlet 객체 만들어지면서 init()이 내부에서 실행됨 

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("재정의된 service");
	}
	
}
