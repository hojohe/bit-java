package day16.exam;

import java.io.FileReader;
import java.io.FileWriter;

public class Exam02Test {
	
	public void execute() {
		
		try (
			FileReader fr = new FileReader("src/day16/exam/exam02.txt");
			FileWriter fw = new FileWriter("src/day16/exam/exam02-result.txt")	
		) {
			
			String low = "";
			
			while(true) {
				
				int ch = fr.read();
				if(ch == -1) break;
				low += String.valueOf((char)ch);
				
			}
			
			String[] pass = new String[3];
			String[] arrLow = low.split("\r\n");
			for(int j = 0; j < arrLow.length; j++) {
				
				String[] arrStudent = arrLow[j].split(":");
				for(int k = 1; k < arrStudent.length; k++) {
					
					int cutLine = 0;
					if(k == 1) {
						cutLine = 70;
					}else if(k == 2 || k==3) {
						cutLine = 80;
					}
					if (Integer.parseInt(arrStudent[k].trim()) >= cutLine) {
						pass[k-1] = "수료";
					} else {
						pass[k-1] = "미수료";
					}

				}
				fw.write(String.format("%s : 자바(%s), SQL(%s), Jdbc(%s)\n"
						, arrStudent[0], pass[0], pass[1], pass[2] ));
			}
			
			System.out.println("exam02-result.txt 파일 생성 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}