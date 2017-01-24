package day03.exam;

import java.util.Scanner;

public class Exam07 {
	public static void main(String[] args) {

		//객체생성
		Scanner sc = new Scanner(System.in);

		//출력예시만큼 반복
		for(int i=0; i<=1; i++) {
			
			System.out.print("숫자를 입력하세요 : ");
			int val = Integer.parseInt(sc.nextLine());
			
			//결과 출력
			System.out.println(val + "의 절대값 : " + Math.abs(val));
			
		}
	}
}
