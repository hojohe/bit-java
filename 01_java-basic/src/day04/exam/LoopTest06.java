package day04.exam;

public class LoopTest06 {
	public static void main(String[] args) {

		int val2 = 0;//결과값
		
		System.out.print("  :  ");
		for(int i=1; i<=9; i++) {
			System.out.printf("%4d", i);
		}
		System.out.println();
		System.out.println("-------------------------------------------");
		
		int result;
		for (int i = 2; i <= 9; i++) {
			
			result = 0;
			System.out.print(i + "단      ");
			for (int j = 1; j <= 9; j++) {
				result = i * j;
				System.out.printf("%4d", result);
			}
			
			val2 = i;
			System.out.println();
		}
		
	}
}
