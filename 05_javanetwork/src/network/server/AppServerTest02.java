package network.server;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServerTest02 {
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(10001);
			
			while(true) {
				
				System.out.println("클라이언트 요청 대기");
				Socket client = server.accept();
				
				// 접속한 클라이언트에게 메세지 전송하기
				OutputStream out = client.getOutputStream();	// 서버간 통신일때는 바이트코드로만 가능! Writer클래스는 못씀 
				String str = "Hello~";
				out.write(str.getBytes("utf-8"));	//인코딩 정의안해주면 파일생성될때 파일인코딩설정된 값 따라감! 
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
