package day04.exam;

import java.util.Random;

public class LoopTest09 {
	public static void main(String[] args) {
		
		Random r = new Random();
		
		int val = r.nextInt(11)+10;
		
		String result = "";
		
		int totCnt = 0;
		for(int i=1; i<=100; i++) {

			int cnt = 0;
			for(int j=1; j<=i; j++) {
				if(i % j == 0) {
					cnt++;
				}
			}
			
			if(val == totCnt) {
				break;
			}
			
			if(cnt == 2)  {
				result += i + " ";
				totCnt++;
			}
			
		}

		System.out.println("소수 " + result);
		
	}
}
