package day16;

import java.io.FileInputStream;
import java.io.FileReader;

public class Test05 {
	public static void main(String[] args) {
		
		//FileInputStream fis = null;
		FileReader fis = null;
		
		try {
			//fis = new FileInputStream("data/a.txt");
			fis = new FileReader("data/a.txt");
			
			while(true) {
				
				int ch = fis.read();
				if(ch == -1) break;
				System.out.print((char)ch);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 입, 출력 객체를 닫기
			if(fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
