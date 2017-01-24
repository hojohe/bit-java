package day04.exam;

import java.util.Random;

public class LoopTest03 {
	public static void main(String[] args) {

		Random r = new Random();

		int sum = 0;

		for (int i = 1; i <= 5; i++) {
			int random = r.nextInt(100) + 1;
			sum += random;
			System.out.println(i + "번째 랜덤 숫자 : " + random);
		}

		System.out.println("합   : " + sum);
		System.out.println("평균 : " + (double)sum / 5);

	}
}
