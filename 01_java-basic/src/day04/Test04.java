package day04;

public class Test04 {
	public static void main(String[] args) {
		
		/**************************
		 * 
		 * for(1.초기값; 2.조건식; 3.증감) {
		 * 		 4.실행문장들;
		 * }
		 * 
		 * 
		 * 1.초기값
		 * while(2.조건식) {
		 * 		4. 실행문장들
		 * 		3. 증감
		 * }
		 * 
		 **************************/
		System.out.println("for문");
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		
		System.out.println("while문");
		int i = 1;
		while(i <= 10) {
			System.out.println(i);
			i++;
		}

		
	}
}
