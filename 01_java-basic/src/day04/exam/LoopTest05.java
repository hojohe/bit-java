package day04.exam;

import java.util.Scanner;

public class LoopTest05 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("수를 입력하세요 : ");
		int input = Integer.parseInt(sc.nextLine());
		int sum = 0;
		
		//1~9까지 나눠보자
		for (int i = 1; i <= input; i++) {
			//약수 골라내기
			if (input % i == 0 && input != i) {
					System.out.println("약수를 찍어보자 : " + i);
					sum += i;
			}
		}

		if(sum == input)
			System.out.println(input + "은 완전수 입니다.");
		else 
			System.out.println(input + "은 완전수가 아닙니다.");

	}
}
