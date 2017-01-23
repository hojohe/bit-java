package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/test05")
public class Test05 extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 응답하려는 Content에 대한 타입을 설정
		// 톰캣이 시작라인과 해더를 다 구성해준다. 우리는 바디만 정의해서 보내주면 된다! 
//		response.setContentType("text/html");	//한글 깨짐
		
		// 1단계. 응답 데이터에 대한 문서타입 설정
		response.setContentType("text/html; charset=utf-8"); // text/html부분에 오타가 있거나, 브라우저가 해석을 못할떄는 팝업이 뜸! 다운로드 받으라고
		
		// 2단계. 사용자에게 데이터를 출력하기 위한 객체
		//OutputStream out = response.getOutputStream();	//byte처리: 이미지, 음악파일 등등..
		PrintWriter out = response.getWriter();// 출력전용IO (sysout과 비슷)
		
		// 3단계. 내용 출력
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>응답성공</h1>");
		out.println("</body>");
		out.println("</html>");
		
		
		
		// 4단계. 출력객체 닫기
		out.close();
		
	}

}
