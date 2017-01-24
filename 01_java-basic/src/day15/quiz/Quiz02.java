package day15.quiz;

import java.util.Arrays;

public class Quiz02 {
	public static void main(String[] args) {

		/*
		 * 실행시의 화면 출력이 다음과 같도록 코딩 작성 [9,5,3]
		 *
		 */
		int[] arr = { 3, 9, 5 };
		int tmp = 0;
		// 셀렉션 소트를 이용해서 정렬
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
				}
			}
		}

		// 선택정렬은 index 0 부터 다음index를 차례로 비교한다!
		System.out.println(Arrays.toString(arr));

	}
}
