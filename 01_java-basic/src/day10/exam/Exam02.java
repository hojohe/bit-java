package day10.exam;

public class Exam02 {

	int findMedian(int[] arr) {

		int[] mid = new int[arr.length];
		int tot = 0;
		int avg = 0;
		int m = 0;
		int result = 0;
		
		// 배열 값 합계 구하기 
		for (int i = 0; i < arr.length; i++) {
			tot += arr[i];
		}
		
		// 배열 값 평균 구하기
		avg = tot / arr.length;

		
		// 초기화된 배열 값 모두 비교하기 때문에 초기에 선언된 배열 개수 만큼 돌리기
		for (int i = 0; i < arr.length; i++) {
			// 평균에서 초기화된 배열 각각의 값을 빼준 값을 또 다른 배열로 만들기
			mid[i] = Math.abs(avg - arr[i]);
			
			// (평균-초기화된배열값)을 담은 배열끼리 비교 한 후 최소값 뽑기
			for (int j = 0; j < i; j++) {
				
				// 초기에 선언된 값이 0이기 때문에 0번째 배열값 셋팅
				if(m == 0) 		m = mid[i];
				// 제일 작은 수를 m이란 변수에 담으면서 비교
				if(m >= mid[j])	{
					m 		= mid[j];
					// 결국 출력하고 싶은 값은 초기에 초기화된 배열에서 index 가지고 가져오기
					result 	= arr[j]; 
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Exam02 ex = new Exam02();

		int[] arr1 = { 10, 4, 53, 63, 17, 37, 52, 16, 33, 65 };
		int mid = ex.findMedian(arr1);

		System.out.println("중간값 : " + mid);

		int[] arr2 = { 32, 53, 52, 76, 15, 98, 76, 65, 36, 10 };
		mid = ex.findMedian(arr2);

		System.out.println("중간값 : " + mid);

	}
}
