package day04.exam;

public class LoopTest08 {
	public static void main(String[] args) {
		
		String result = "";
		
		for(int i=1; i<=100; i++) {

			int cnt = 0;
			for(int j=1; j<=i; j++) {

				if(i % j == 0) {
					cnt += 1;
				}
				
			}
			
			if(cnt == 2) result += i + " ";
			
		}
		System.out.println("소수 " + result);
		
	}
}
