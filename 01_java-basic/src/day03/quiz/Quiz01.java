package day03.quiz;

import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] args) {
		//아래와 같이 출력될 수 있도록 작성하세요.
		
		/*
		 * (조건)
		 *
		 * 5000원 미만을 입력할 경우    "치즈버거를 살 수 있습니다." 출력
		 * 5000~10000원 사이일 경우  "불고기 버거 세트를 살 수 있습니다." 출력
		 * 10000원 보다 클 경우         "패밀리 세트를 살 수 있습니다." 출력
		 * 
		 * (출력형식)
		 *
		 * 어서오세요 고객님 롯데리아 입니다.
		 * 
		 * 현재 가진돈을 입력하세요 : _3500 
		 * 치즈버거를 살 수 있습니다.
		 * 
		 * 현재 가진돈을 입력하세요 : _5100 
		 * 불고기 버거 세트를 살 수 있습니다.
		 * 
		 *  현재 가진돈을 입력하세요 : _10100 
		 *  패밀리 세트를 살 수 있습니다.
		 * 
		 * */
		
		
		System.out.println("어서오세요 고객님 롯데리아 입니다.");
		
		//스캐너 객체 생성
		Scanner sc = new Scanner(System.in);
		
	    /*
	    System.out.print("현재 가진돈을 입력하세요 : ");
		
		//입력된 값 int로 형변환
		int amt = Integer.parseInt(sc.nextLine());
		
		//제시된 조건문
		if(amt < 5000 && amt != 0 ) {
			System.out.println("치즈버거를 살 수 있습니다.");
		
		}else if(amt >= 5000 && amt <= 10000) {
			System.out.println("불고기 버거 세트를 살 수 있습니다.");
		
		}else if(amt > 10000){
			System.out.println("패밀리 세트를 살 수 있습니다.");
		
		}else {
			System.out.println("살 수 있는 버거가 없습니다.");
		
		}
		*/

		//반복문
		for(int i=0; i<=2; i++) {
			
			System.out.print("현재 가진돈을 입력하세요 : ");
			
			//입력된 값 int로 형변환
			int amt = Integer.parseInt(sc.nextLine());
			
			if(amt < 5000 && amt != 0 ) {
				System.out.println("치즈버거를 살 수 있습니다.");
			
			}else if(amt >= 5000 && amt <= 10000) {
				System.out.println("불고기버거 세트를 살 수 있습니다.");
			
			}else if(amt > 10000) {
				System.out.println("패밀리 세트를 살 수 있습니다.");
			
			}else {
				System.out.println("살 수 있는 버거가 없습니다.");

			}
			
		}
		
		/*System.out.print("현재 가진돈을 입력하세요 : ");
		int amt = Integer.parseInt(sc.nextLine());
		
		while(amt != 0) {
			
			if(amt < 5000) {
				System.out.println("치즈버거를 살 수 있습니다.");
				
			}else if(amt >= 5000 && amt <= 10000) {
				System.out.println("불고기버거 세트를 살 수 있습니다.");
			
			}else {
				System.out.println("패밀리 세트를 살 수 있습니다.");
			
			}
			
			break;
			
		}*/
		
	}

}
