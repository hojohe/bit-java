package day05.quiz;

import java.util.Scanner;

public class Quiz04 {
	public static void main(String[] args) {
		int[] arr = { 6, 8, 3, 9, 7, 4 };
		
		/*
		 * 수를 입력 : 3
		 * 배열에 1개가 들어있습니다.
		 * 
		 * 수를 입력 : 1
		 * 배열에 0개가 들어있습니다.
		 * 
		 * 수를 입력 : -1
		 * 종료합니다.
		 */
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.print("수를 입력 : ");
			int input = Integer.parseInt(sc.nextLine());
			
			if(input == -1)	
				break;
			
			int matchCnt = 0;
			
			/* 향상된 for문 */
			for(int val : arr)
				if(val == input)	matchCnt++;
				
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == input) {
					matchCnt++;
				}
			}

			System.out.println("배열에 " + matchCnt +"개가 들어있습니다.");
			
		}
		
		System.out.println("종료합니다.");
	
	}
}
