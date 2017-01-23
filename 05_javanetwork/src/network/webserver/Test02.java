package network.webserver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class Test02 {
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
				String reqHeaders = "";
				while (true) {
					String line = br.readLine();
					
					if(line.equals("")) break;
					reqHeaders += line + "\n";
				}
				System.out.println("====================================");
				System.out.println("요청시작 라인 : " + reqStartLine);
				System.out.println("요청헤더");
				System.out.println(reqHeaders);
				System.out.println("====================================");
				
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
 