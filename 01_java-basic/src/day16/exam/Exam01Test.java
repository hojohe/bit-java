package day16.exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Exam01Test {
	
	public static void main(String[] args) {
		new Exam01Test().execute();
	}
	
	public void execute() {
		
		
		try (
				FileReader fis = new FileReader("src/day16/exam/exam01.txt");
				FileWriter fos = new FileWriter("src/day16/exam/exam01-result.txt");
		) {
				
			int sum = 0;
			int max = 0;
			int min = 100;

			char[] buf = new char[2];
			while(fis.read(buf) != -1) {

				if(Character.isDigit(buf[0]) && Character.isDigit(buf[1])) {

					int num = (Character.getNumericValue(buf[0]) * 10) + Character.getNumericValue(buf[1]);
					sum += num;
					
					if (num > max) {
						max = num;
					}
					
					if (min > num) {
						min = num;
					}
					
					fos.write(num + "\r\n");
				}
			}

			fos.write("\r\n총점   : "  + String.valueOf(sum));
			fos.write("\r\n평균   : "  + String.valueOf(sum / 4.0d));
			fos.write("\r\n최고점 : "	+ max);
			fos.write("\r\n최저점 : " + min);
			
			System.out.println("exam01-result.txt 파일 생성 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
