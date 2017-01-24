package test;

import java.util.Arrays;

public class Test01 {

	public static void main(String[] args) {

		int[] arr = new int[5];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10) + 1;
		}
		System.out.println("1 > " + Arrays.toString(arr));

	}

}
