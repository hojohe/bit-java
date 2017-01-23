package network.webserver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class Test03 {
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
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader br = new BufferedReader(isr);
				
				String reqStartLine = br.readLine();
				
				System.out.println("====================================");
				System.out.println("요청시작 라인 : " + reqStartLine);
				System.out.println("====================================");
				
				// GET /Test02?id=aaa&pass=1111 HTTP/1.1
				// 방식 : GET
				// URI : /test
				// QueryString : id=aaa&pass=1111
				// id : aaa
				// pass : 1111
				
				String[] type = reqStartLine.split(" ");
				String[] uri = type[1].split("\\?");
				
				System.out.println("방식 : " + type[0]);
				System.out.println("URI : " + uri[0]);
				
				String[] params = uri[1].split("&");
				System.out.println("QueryString : " + uri[1]);
				
				for(String param : params) {
					String[] value = param.split("=");
					System.out.println(value[0] + " : " + value[1]);
				}
					
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
 