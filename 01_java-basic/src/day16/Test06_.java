package day16;

import java.io.FileWriter;
import java.io.IOException;

public class Test06_ {
	public static void main(String[] args) {
		
		FileWriter fos = null;
		
		try {
			fos = new FileWriter("data/a2.txt");
			fos.write(97);
			fos.write('가');
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
		
		
	}
}
