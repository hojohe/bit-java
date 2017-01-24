/*******************************
	package -> import -> class
 *******************************/


package day03;

import java.io.File;
import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요 : ");
		
		String name = sc.nextLine();

		System.out.println("입력된 이름       : " + name);
		*/
		
		/*
		 	이름을 입력하세요 : _홍길동
		 	입력된 이름 : 홍길동
		 	나이를 입력하세요 : _33
		 	입력된 나이 : 33
		 	
		 */
		/*
		System.out.print("이름을 입력하세요 : ");
		String nm = sc.nextLine();
		System.out.println("입력된 이름       : " + nm);
		
		System.out.print("나이를 입력하세요 : ");
		String age = sc.nextLine();
		System.out.println("입력된 나이       : " + age);
		*/
		
		
		Scanner sc = new Scanner(System.in);
		int num = 0;
	    while (sc.hasNextLong()) {
	    	num = sc.nextInt();
	    	System.out.println("num > " + num);
	    
	    }
	}
}
