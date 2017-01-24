package day05.quiz;

import java.util.Arrays;

public class Quiz07 {
	public static void main(String[] args) {

		int[] arr = {3, 1, 9, 4, 5, 8};
		
		int tmp;
		for (int i = 0; i < arr.length / 2; i++) {
			tmp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = tmp;
		}

		System.out.println(Arrays.toString(arr));
		
	}
}
