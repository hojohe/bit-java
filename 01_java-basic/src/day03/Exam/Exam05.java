package day03.exam;

import java.util.Scanner;

public class Exam05 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		//출력 예시만큼 반복
		for(int i=0; i<=2; i++) {
			
			System.out.print("나이를 입력하세요 : ");
			//입력받은 값 형변환
			int age = Integer.parseInt(sc.nextLine());
			
			//조건에 맞는 결과 출력
			if(age < 5 ) {
				System.out.println("입장료는 무료입니다.");
	
			}else if(age >= 5 && age <= 11 ) {
				System.out.println("입장료는 2500원 입니다.");
				
			}else if(age >= 12) {
				System.out.println("입장료는 5000원 입니다.");
				
			}else {
				System.out.println("정확한 나이를 입력해주세요.");
			}
			
		}
			
	}
}
