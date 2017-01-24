package day05.quiz;

import java.util.Scanner;

public class Quiz05 {
	public static void main(String[] args) {
		
		int[] arr = { 6, 8, 3, 9, 7, 4 };
		
		/*
		 * 출력형식 
		 * 수를 입력 : 5
		 * 5보다 큰 수가 4개 있습니다.
		 * 수를 입력 : 7
		 * 7보다 큰 수가 2개 있습니다. 
		 * 큰수들의 합계는 ?? 입니다.
		 * 
		 */
		
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			
			System.out.print("수를 입력 : ");
			int input = Integer.parseInt(sc.nextLine());
			
			int cnt = 0;
			int sum = 0;
			for(int val : arr) {
				if(val > input)  {
					cnt ++;
					sum += val;
				}
			}
			
			System.out.printf("%d 보다 큰 수가 %d개 있습니다. \n", input, cnt);
			System.out.printf("큰 수들의 합계는 %d입니다.     \n", sum);
			
		}
		
	}
}
