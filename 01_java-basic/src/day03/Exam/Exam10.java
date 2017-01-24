package day03.exam;

import java.util.Random;

public class Exam10 {
	public static void main(String[] args) {
		
		//객체 생성
		Random r      = new Random();
		
		//난수 발생
		int    score  = r.nextInt(100) + 1;
		String val    = "";
		
		//조건식
		if(score < 60) {
			val = "점 미만일 경우 재수강";
		
		}else if(score >= 60 && score <=90) {
			val = "점 일 경우 잘했어요";
			
		}else {
			val = "점일 경우 당신은 장학생";
			
		}
		
		//결과 출력
		System.out.println(score + val);
		
	}
}
