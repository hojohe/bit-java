package day05.quiz;

public class Quiz01 {
	public static void main(String[] args) {
		int[] arr = {6, 8, 3, 9, 7, 4};
		
		//실행시 아래와 같이 출력되도록 프로그램 작성
		//출력형식 >
		
		int max=arr[0];
		int min=arr[0];
		
		for(int i = 0; i<arr.length; i++) {
				
			if(max > arr[i]) {
				//최대
				max = arr[i];
			}else if(min < arr[i]) {
				//최소
				min = arr[i];
			}
				
			
		}
		
		System.out.println("최댓값 : " + max);
		System.out.println("최솟값 : " + min);

	}
}
