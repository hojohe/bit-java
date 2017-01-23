package network.url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

// URL 연결 후 데이터 읽어오기
public class Test02 {
	
	public static void main(String[] args) {
		
		try {
			
			URL url = new URL("http://www.daum.net");
			InputStream in = url.openStream();
			InputStreamReader isr = new InputStreamReader(in, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			while(true) {
				//int ch = in.readLine();
				//int ch = isr.readLine();
				String line = br.readLine();
				
				//if(ch == -1) break;
				if(line == null) break;
				
				// console창 
				//System.out.print((char)ch);
				System.out.println(line);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


}
