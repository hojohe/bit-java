package network.webserver;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01 {
	public static void main(String[] args) {
		
		try {
			
			ServerSocket server = new ServerSocket(10001);
			
			while(true) {
				
				Socket client = server.accept();
				System.out.println("클라이언트 접속됨...");
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				String time = sdf.format(new Date());
				String time = "<html>"
							+ " 	<head>"
							+ "			<style>"
							+ "				div { "
							+ "					font-size: 50px; "
							+ "					background: tomato; "
							+ "					color: white; "
							+ "					text-align: center; "
							+ "					margin: 100px; "
							+ "					padding: 50px; "
							+ "					border: 10px solid black; "
							+ "					transition: 1s;"
							+ "				}"
							+ "				div:hover {background:black; }"
							+ "			</style>"
							+ "		</head>"
							+ "		<body>"
							+ "			<div>"
							+ "				현재 시간 : " + sdf.format(new Date())
						 	+ "			</div>"
						 	+ "		</body>"
						    + "</html>";
				
				String startLine = "HTTP/1.1 200 OK\r\n";
				String headers = "Cache-Control: no-cache\r\n"
						       + "Content=Type: text/html; charset=UTF-8\r\n" //응답할때 메시지에 한글이 있을 수 있으니 UTF-8
						       + "Content-Length: " + time.getBytes().length + "\r\n\r\n";
				String body = time;
				
				String data = startLine + headers + body;
				
				OutputStream out = client.getOutputStream();
				out.write(data.getBytes());
			
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
 