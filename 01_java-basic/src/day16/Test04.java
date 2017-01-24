package day16;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test04 {
	public static void main(String[] args) {
		
		// 화면에서 데이터 읽기 : 문자 처리
		InputStream in = System.in;
		InputStreamReader isr = new InputStreamReader(in);
		try {
			
			while(true) {
				int i = isr.read();
				System.out.print((char)i);
				//"abcd\r\n => abcd+엔터키"
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*// 화면에서 데이터 읽기
		InputStream in = System.in;
		try {
			
			while(true) {
				int i = in.read();
				System.out.print((char)i);
				//"abcd\r\n => abcd+엔터키"
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		
	}
}
