package day04.exam;

import java.util.Scanner;

public class LoopTest07 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num  = 0; 
		int num2 = 0; 
		
		System.out.print("두개의 숫자를 입력하세요 : ");

		num  = Integer.parseInt(sc.next());
		num2 = Integer.parseInt(sc.next());
		
		for(int i=num; i<=num2; i++) {
			
			String result = "";
			
			System.out.print(i + "단 ");
			for(int j=1; j<=9; j++) {
				
				System.out.printf("%4d", i*j);
				
			}
			
			System.out.println();
			
		}
		
		
		
	}
}
