package day15.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Quiz06 {
	public static void main(String[] args) throws FileNotFoundException {
		// data/day15/quiz06.txt 파일의 내용을 읽어서 아래와 같이 출력
		/*
		 * 성적 발표 
		 * --------------
		 * 1등 이름 : ... 총점 : ...
		 * 2등 이름 : ... 총점 : ...
		 * 3등 이름 : ... 총점 : ...
		 *
		 */
		
		File f = new File("data/day15/Quiz06");
		Scanner sc = new Scanner(f);
		
		List<StudentVO> arrStudent = new ArrayList<>();
		while(sc.hasNextLine()) {
			String[] arrStr = sc.nextLine().split(":");
			StudentVO vo = new StudentVO(arrStr[0]
					, Integer.parseInt(arrStr[1])
					, Integer.parseInt(arrStr[2])
					, Integer.parseInt(arrStr[3]));

			arrStudent.add(vo);
			
		}
		Collections.sort(arrStudent);
		int i = 1;
		String str = "";
		for (StudentVO key : arrStudent) {
			
			str = i++ + "등 이름 : " + key.getName() + "총점 : " + key.getSum(); 
			 
			System.out.println(str);
			if(i == 4) break; 
			
			
		}
		
		
	}
}
