package day03.exam;

import java.util.Scanner;

public class Exam03 {
	public static void main(String[] args) {
	
		//원주율 상수 선언
		final double PI = 3.141592;

		//객체 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.print("원의 반지름을 입력하세요 : ");

		//입력받은 반지름 형변환
		int    r  = Integer.parseInt(sc.nextLine());
		
		//원의 면적 구하기
		double r2 = r * r * PI;
		
		//결과 출력
		System.out.println("반지름이 " + r + "인 원의 면적은 " + r2+ "입니다.");

	}
}
