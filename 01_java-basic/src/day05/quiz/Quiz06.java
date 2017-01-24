package day05.quiz;

public class Quiz06 {
	public static void main(String[] args) {
		
		//배열의 홀수 인덱스 요소들의 합계 :21
		int[] arr = { 6, 8, 3, 9, 7, 4 };
		
		int oddSum = 0;
		for(int i = 0; i < arr.length; i++) {
			
			if(i % 2 != 0) 	oddSum += arr[i];
			
		}
		
		System.out.println("홀수 인덱스 요소들의 합계 : " + oddSum);
		System.out.printf("홀수 인덱스 요소들의 합계 : %d", oddSum);
		
	}
}
