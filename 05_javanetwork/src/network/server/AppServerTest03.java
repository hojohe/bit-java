package network.server;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServerTest03 {
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(10001);
			
			while(true) {
				
				System.out.println("클라이언트 요청 대기");
				Socket client = server.accept();
				
				// 접속한 클라이언트에게 메세지 전송하기
				OutputStream out = client.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				String str = "Hello~";
				
				dos.writeUTF(str);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
