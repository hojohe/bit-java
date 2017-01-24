package day04.quiz;

public class Quiz01 {
	public static void main(String[] args) {
		
		/**********************
		 * 
		 * 1~10까지의 합을 구하시오
		 * (출력형식) 
		 * 1 - 10 까지의 합 : 55
		 * 
		 **********************/
		int sum = 0;
		for(int i=1; i<=10; i++) {
			sum += i;
		}
		
		System.out.println("1 - 10 까지의 합 : " + sum);
		
		
		/*********************
		 * 
		 * 짝수의 합 : 30
		 * 홀수의 합 : 25
		 * 
		 *********************/
		int sum2 = 0;
		int sum3 = 0;
		for(int i=1; i<=10; i++) {
			
			if(i % 2 ==0) {
				sum2 += i;
				continue;
			}
			sum3 += i;
			
			/*if(i % 2 ==0) {
				sum2 += i;
			}else {
				sum3 += i;
			}*/
			
		}
		
		System.out.println("짝수의 합 : " + sum2);
		System.out.println("홀수의 합 : " + sum3);
		
	}
}
