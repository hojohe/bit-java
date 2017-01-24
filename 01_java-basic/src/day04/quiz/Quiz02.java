package day04.quiz;

import java.util.Random;
import java.util.Scanner;

public class Quiz02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random  r  = new Random();
		
		System.out.println("1부터 1000사이의 숫자를 맞추는 게임입니다.(총 10회)");

		int answerNum = r.nextInt(1000) + 1;
		//int answerNum = 500;
		
		boolean flag = false;
		for(int i=1; i<=10; i++) {
			
			System.out.print( i + "회. 숫자를 입력하세요. (1-1000) : ");
			int input = Integer.parseInt(sc.nextLine());
		
			if(input == answerNum) {
				
				flag = true;
				System.out.println("정답입니다.");
				break;
				
			}
			
			if(input < answerNum) {
				
				System.out.println(input+"보다 큰 값 입니다.");
				
			}else if(input > answerNum) {
				
				System.out.println(input+"보다 작은 값 입니다.");
			}			
			
		}
		
		if(!flag) 
			System.out.println("10회안에 맞추기 게임에 실패하였습니다.\n정답은 " + answerNum + "입니다.");
		
		
		
		sc.close();
		
	}
}
