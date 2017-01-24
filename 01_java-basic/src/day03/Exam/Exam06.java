package day03.exam;

import java.util.Scanner;

public class Exam06 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//출력예시만큼 반복
		for(int i=0; i<=1; i++) {
			
			System.out.print("물건값을 입력하세요(만원): ");
			
			int amt  = Integer.parseInt(sc.nextLine());
			int amt2 = 0;
			
			if(amt <= 10) {
				amt2 = (int)(amt * 10000 * 0.97);
				
			}else if(amt > 10 && amt <=20) {
				amt2 = (int)(amt * 10000 * 0.95);
				
			}else if(amt > 20 && amt <=30) {
				amt2 = (int)(amt * 10000 * 0.92);
				
			}else {
				amt2 = (int)(amt * 10000 * 0.9);
			}
			
			System.out.println("할인된 금액은 " + amt2 + "원 입니다.");
			
		}
	}
}
