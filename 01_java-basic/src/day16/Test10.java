package day16;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test10 {
	public static void main(String[] args) {
		// Kalimba.mp3 : 40.491초 (8,414,449 바이트)
		FileInputStream fis  = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			
			fis = new FileInputStream("data/Kalimba.mp3");
			fos = new FileOutputStream("data/Kalimba2.mp3");
			bis = new BufferedInputStream(fis, 256 * 1024);
			bos = new BufferedOutputStream(fos);

			System.out.println("복사 시작");
			long s = System.currentTimeMillis();
			while(true) {
				
				int ch = bis.read();
				if(ch == -1) break;
				System.out.println("ch > " + ch);
				bos.write(ch);
				
			}
			double time = (System.currentTimeMillis() - s) / 1000d;
			System.out.println("음악 파일 복사 성공 : " + time);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
		
			if(bis != null) {
				try {
					fis.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			if(bos != null) {
				try {
					fos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		}
		
	}
}
