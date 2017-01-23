package network.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServerTest04 {
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(10001);
			
			while(true) {
				
				System.out.println("클라이언트 요청 대기");
				Socket client = server.accept();
				
				// 접속한 클라이언트가 보내준 메세지 읽기
				InputStream in = client.getInputStream();
				DataInputStream dis = new DataInputStream(in);
				
				// 접속한 클라이언트에게 메세지 전송하기
				OutputStream out = client.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				System.out.println("클라이언트 접속 에코 시작");
				while(true) {
					String recvMsg = dis.readUTF();
					if(recvMsg.equals("quit")) break;
					
					System.out.println("유전이가 보낸 말 : " + recvMsg);
					dos.writeUTF(recvMsg);
				}
				System.out.println("클라이언트 접속 에코 종료");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
