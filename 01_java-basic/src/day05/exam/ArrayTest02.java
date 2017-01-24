package day05.exam;

import java.util.Random;

public class ArrayTest02 {
	public static void main(String[] args) {

		int[] arr = new int[4];
		Random r = new Random();

		int rNum = 0;

		System.out.println("요소     생성된 수     출력");

		for (int i = 0; i < 4; i++) {
			rNum = r.nextInt(10) + 1;

			arr[i] = rNum;

			String star = "";
			for (int j = 0; j < rNum; j++)
				star += "*";

			System.out.println(i + "     " + arr[i] + "         " + star);
		}

	}
}
