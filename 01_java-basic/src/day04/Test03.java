package day04;

import java.util.Random;

public class Test03 {
	public static void main(String[] args) {
		
		//반복문을 중간에 빠져나가기      : break
		//반복문의 나머지 부분을 무시하기 : continue
		/*
		Random r = new Random();
		int  num = r.nextInt(9) + 1; //1~9
		System.out.println("num : " + num);
		
		
		System.out.println("----break----");
		for(int i=1; i<10; i++) {
			System.out.println(i);
			if(i==num) break; 	
		}
		
		
		System.out.println("----continue----");
		for(int i=1; i<10; i++) {
			if(i==num) continue; 	
			System.out.println(i);
		}
		*/
		Random r = new Random();
		int breakNum = r.nextInt(9);
		System.out.println(breakNum);
		
		/******************
		 * outer : 
		 * > 중첩 for문에서 break; 또는 continue; 다같이 빠져나오거나 계속되게 하기 위해 
		 ******************/
		outer :
		for(int i=0; i<=3; i++) {
			System.out.println("i= " + i);
			for(int k=0; k<3; k++) {
				System.out.println("k = " + k);
				if(i == breakNum) {
					break outer;
				}
			}
		}

		
	
	
	}
}
