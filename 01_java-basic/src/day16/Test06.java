package day16;

import java.io.FileOutputStream;
import java.io.FileWriter;

public class Test06 {
	public static void main(String[] args) {
		
		//FileOutputStream fos = null;
		FileWriter fos = null;
		
		try {

			//fos = new FileOutputStream("data/a2.txt");
			fos = new FileWriter("data/a2.txt", true);
			fos.write(97);
			fos.write('a');
			fos.write('가');
			System.out.println("파일 쓰기 성공");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			if(fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
