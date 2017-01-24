package day03.exam;

import java.util.Random;
import java.util.Scanner;

public class Exam08 {
	public static void main(String[] args) {
		
		//객체 생성
		Scanner sc  = new Scanner(System.in);
		Random  r   = new Random();
		
		//변수 선언
		int score   = r.nextInt(100) + 1;
		String bool = "";
		
		//합격 조건식
		if(score >= 60) {
			bool = "합격";
			
		}else {
			bool = "불합격";
			
		}
		
		//결과 출력
		System.out.println("생성된 점수 : " + score + "점(" + bool + ")");
		
	}
}
