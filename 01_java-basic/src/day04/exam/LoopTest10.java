package day04.exam;

import java.util.Scanner;

public class LoopTest10 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		
		int input = Integer.parseInt(sc.nextLine());
		int flagCnt = 0;
		
		String buho = "";
		for(int i=1; i<=input; i++) {
			
			for(int j=input; j>=1; j--) {
				
				if(flagCnt == 0) {
					if(input % 2 == 0)	
						buho = ">";
					else 				
						buho = "<";
				}
				
				System.out.print(buho);
				
			}
			
			flagCnt++;
			
			if(buho == ">") {
				buho = "<";
			}else {
				buho = ">";
			}
			
			System.out.println();
			
		}
		
	}
}
