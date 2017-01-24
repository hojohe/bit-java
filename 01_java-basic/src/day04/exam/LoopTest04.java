package day04.exam;

import java.util.Scanner;

public class LoopTest04 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수를 입력하세요(2-10) : ");
		int input = Integer.parseInt(sc.nextLine());
		
		String result = "";

		for(int i=1; i<=10; i++) {
			result += (input * i) + " ";
		}
		
		System.out.println(input + "의 배수 : " + result);
		
	}
}
