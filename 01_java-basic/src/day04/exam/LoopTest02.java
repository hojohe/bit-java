package day04.exam;

import java.util.Scanner;

public class LoopTest02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수를 입력하세요 : ");
		int val  = Integer.parseInt(sc.nextLine());

		System.out.print("수를 입력하세요 : ");
		int val2 = Integer.parseInt(sc.nextLine());
		
		
		int sum = 0;
		for(int i=val; i<=val2; i++) {
			sum += i;
		}

		System.out.println(val + "부터 " + val2 + "까지의 합은 " + sum + "입니다.");
		
	}
}
