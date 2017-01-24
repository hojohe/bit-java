package day16;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test11 {
	public static void main(String[] args) {
		
		// 1.7 버전 부터 = try () -> auto close
		try (
			FileInputStream      fis = new FileInputStream("data/Kalimba.mp3");   
			FileOutputStream     fos = new FileOutputStream("data/Kalimba2.mp3"); 
			BufferedInputStream  bis = new BufferedInputStream(fis, 256 * 1024);  
			BufferedOutputStream bos = new BufferedOutputStream(fos);             
			) 
		{
			
			System.out.println("복사 시작");
			long s = System.currentTimeMillis();
			while(true) {
				
				int ch = bis.read();
				if(ch == -1) break;
				bos.write(ch);
				
			}
			double time = (System.currentTimeMillis() - s) / 1000d;
			System.out.println("음악 파일 복사 성공 : " + time);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
}
