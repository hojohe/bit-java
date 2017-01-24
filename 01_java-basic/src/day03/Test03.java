package day03;

public class Test03 {
	public static void main(String[] args) {
		
		/***************
		 * 5. 배정 연산자
		 ***************/
		int a = 10;
		a *= 3 + 4;
		System.out.println(a);
		
		
		
		/***************
		 * 4. 논리 연산자 
		 *    &&
		 *    ||
		 ***************/
		/*
		int a = 10;
		int b = 5;
		
		boolean bool = (a < 10 && b++ ==5);
		//boolean bool = (a < 10 & b++ ==5); //비트연산에 종종 사용
		
		System.out.println("bool : " + bool);
		System.out.println("a    : " + a   );
		System.out.println("b    : " + b   );
		*/
		
		/***************
		 * 3. 비교 연산자
		 ***************/
		/*
		int a = 10;
		int b = 20;
		System.out.println((a == b) ? "같다"  : "다르다");
		System.out.println((a != b) ? "다르다" : "같다" );
		
		boolean flag = false;
		//System.out.println((a = b) ? "같다"  : "다르다");
		System.out.println((flag == false) ? "false"  : "true");
		System.out.println((flag  = false) ? "false"  : "true");
		*/
		
		/***************
		 * 2. 산술 연산자
		 ***************/
		/*
		System.out.println('a' + 'A');
		
		byte b = 1;
		byte b2 = 2;
		//byte b3 = b + b2; 산술 연산의 결과는 int보다 작은 타입들은 int로 변환
		byte b3 = (byte) (b + b2);
		System.out.println(b3);

		System.out.println(1 % 2);
		System.out.println(2 % 2);
		System.out.println(3 % 2);
		System.out.println(4 % 2);
		System.out.println(5 % 2);
		
		int val = 1;
		
		System.out.println(val++ % 2);
		System.out.println(val++ % 2);
		System.out.println(val++ % 2);
		System.out.println(val++ % 2);
		System.out.println(val++ % 2);
		
		System.out.println((1 % 2 == 0) ? "짝수" : "홀수");
		*/
		
		/*************** 
		 * 1. 삼항 연산자 
		 ***************/
		/*
		int a = 5;
		int b = 5;

		String result = (a > b) ? "크다" : (a == b) ? "같다" : "작다";
		
		System.out.println(result);
		
		int result2 = (a > b) ? a : b;
		
		System.out.println(result2);
		
		System.out.println((a > b) ? a : b);
		*/

	}
}
