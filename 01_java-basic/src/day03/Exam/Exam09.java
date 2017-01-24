package day03.exam;

import java.util.Random;

public class Exam09 {
	public static void main(String[] args) {
		
		//객체 생성
		Random r    = new Random();
		
		//난수 발생
		int    val  = r.nextInt(100) + 1;
		String s    = "";
		
		//홀짝 조건식
		if(val % 2 == 0) {
			s = "짝수";
			
		}else {
			s = "홀수";
		
		}
		
		//결과 출력
		System.out.println("생성된 숫자(" + val + ")은 " + s + " 입니다.");
		
	}
}
