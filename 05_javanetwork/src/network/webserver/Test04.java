package network.webserver;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class Test04 {
	public static void main(String[] args) {
		
		try {
			
			ServerSocket server = new ServerSocket(10001);
			
			while(true) {
				
				Socket client = server.accept();
				System.out.println("클라이언트 접속됨...");
				
				// 클라이언트 -> 서버 (Request)
				/*
					시작라인
					헤더

					바디
				*/
				InputStream in = client.getInputStream();
				HttpServletRequest request = new HttpServletRequest(in);
				
				// method : GET
				String method = request.getMethod();
				// URI : /test
				String uri = request.getRequestUri();
				// QueryString : id=aaa&pass=1111
				String QueryString = request.getQueryString();
				// id : aaa
				String id = request.getParameter("id");
				// pass : 1111
				String pass = request.getParameter("pass");

				System.out.println("method : " + method);
				System.out.println("uri : " + uri);
				System.out.println("QueryString : " + QueryString);
				System.out.println("id : " + id);
				System.out.println("pass : " + pass);
				 
				// 서버 -> 클라이언트 (Response)
				String msg = "성공";
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String startLine = "HTTP/1.1 200 OK\r\n";
				String headers = "Cache-Control: no-cache\r\n"
						       + "Content=Type: text/html; charset=UTF-8\r\n"
						       + "Content-Length: " + msg.getBytes().length + "\r\n\r\n";
				String body = msg;
				
				String data = startLine + headers + body;
				
				OutputStream out = client.getOutputStream();
				out.write(data.getBytes());
			
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
 