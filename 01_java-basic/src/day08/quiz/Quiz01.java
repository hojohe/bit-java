package day08.quiz;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] args) throws Exception {
		
		/*
		 * 
		 * data/day08/quiz/quiz01.txt 파일의 내용을 읽어서
		 * 아래와 같이 출력되도록 프로그램을 작성한다.
		 * java파일은 2개 있습니다.
		 * txt 파일은 1개 있습니다.
		 * jpg 파일은 1개 있습니다.
		 * 
		 * */
		
		
		findFileCount("java");
		findFileCount("txt");
		findFileCount("jpg");
		
		
	}
	
	static void findFileCount(String ext) throws Exception {
		
		File f = new File("data/day08/quiz/quiz01.txt");
		Scanner sc = new Scanner(f);
		
		int cnt = 0;
		while(sc.hasNextLine()) {
			if(sc.nextLine().endsWith(ext)) {
				cnt++;
			}
		}
		System.out.println(ext + "파일은 " + cnt + "개 있습니다.");
	}
}
