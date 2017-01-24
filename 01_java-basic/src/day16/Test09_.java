package day16;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test09_ {
	public static void main(String[] args) {

		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		
		try {
			
			fis = new FileInputStream("data/Kalimba.mp3");
			fos = new FileOutputStream("data/Kalimba1.mp3");
			
			byte[] buffer = new byte[32 * 1024];
			
			
			long s = System.currentTimeMillis();
			while(true) {
				int i = fis.read(buffer);
				if(i == -1) break;

				fos.write(buffer, 0, i);
			}
			
			double time = (System.currentTimeMillis() - s) / 1000d;
			System.out.println("파일 성공 " + time);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try{
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(fos != null) {
				try{
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
	}
}
