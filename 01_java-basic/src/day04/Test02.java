package day04;

//import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		
		
		for(int i=1; i<=5; i++) {
			for(int j=5; j>=1; j--) {
				if(i>j) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			for(int k=1; k<=5; k++) {
				if(i>=k) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		for(int i=6; i<=10; i++) {
			for(int k=1; k<=5; k++) {
				if(i-4<=k) {
					System.out.print("*");
				}else {
					System.out.print(" ");
					
				}
			}
			for(int j=5; j>=1; j--) {
				if(i-4<j) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		

		/*
		for(int i=1; i<=5; i++) {
			for(int k=1; k<=5; k++) {
				if(i<k) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		*/
		
		/*
	    Scanner sc = new Scanner(System.in);
		
		System.out.print("별 개수 : ");
		int input= Integer.parseInt(sc.nextLine());
		
		for(int i=1; i<=input; i++) {
			for(int k=input; k>=1; k--) {
				if(k <= i)	
					System.out.print("*");
				else		
					System.out.print(" ");
			}
			System.out.println();
		}
		
		sc.close();
		*/
		/*
		for(int i=1; i<=4; i++) {
			for(int k=1; k<=i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		*/
		
		/*
		for(int i=1; i<=1; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for(int i=1; i<=2; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for(int i=1; i<=3; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for(int i=1; i<=4; i++) {
			System.out.print("*");
		}
		*/
		
		/*
		 * 화면 출력
		 * **********
		 */
		/*
		for(int i=1; i<=10; i++) {
			System.out.print("*");
		}
		*/
		
	}
}
