package day05.exam;

import java.util.Random;

public class Bingo01 {
	public static void main(String[] args) {

		int[] arr = new int[5];
		Random r = new Random();

		int random = 0;
		boolean flag = false;

		for (int i = 0; i < 25; i++) {
			random = r.nextInt(25) + 1;

			for (int j = 0; j < i; j++) {
				if (arr[j] == random) {
					flag = true;
					i--;
				}
			}

			if (!flag) {
				arr[i] = random;
				System.out.printf("%5d", arr[i]);
			}
			
			flag = false;
			if(i % 5 == 0)	System.out.println();
			
		}
	}
}
