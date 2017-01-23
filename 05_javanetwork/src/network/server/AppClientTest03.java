package network.server;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class AppClientTest03 {
	public static void main(String[] args) {
		
		try {
			Socket s = new Socket("192.168.0.10", 10001);
			// accept()메소드가 성공적으로 수행되면 다음라인 수행
			
			// 서버에서 전송된 데이터 읽기
			InputStream in = s.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			System.out.println(dis.readUTF());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
