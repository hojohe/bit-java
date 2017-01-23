package network.server;

import java.io.InputStream;
import java.net.Socket;

public class AppClientTest02 {
	public static void main(String[] args) {
		
		
		try {
			Socket s = new Socket("192.168.0.100", 10001);
			// accept()메소드가 성공적으로 수행되면 다음라인 수행
			
			// 서버에서 전송된 데이터 읽기
			InputStream in = s.getInputStream();
			
			byte[] buffer = new byte[1024];
			int count = in.read(buffer); // 실제 읽어들인 갯수 반환
			String msg = new String(buffer,0,count); // buffer에는 초기셋팅값이 0이 셋팅되어있기 때문에 0번째부터 실제 갯수만큼만 읽어들여야 한다.
			
			System.out.println("서버에서 전송된 데이터 " + msg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
