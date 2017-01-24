package day07;

import java.util.Random;

public class Sub03 {

	/*
	 * add : 두 수의 합을 구한 뒤 결과를 반환
	 * sub : 두 수의 차를 구한 뒤 결과를 반환
	 * mul : 두 수의 곱을 구한 뒤
	 * 결과를 반환 div : 두 수의 제를 구한 뒤 결과를 반환
	 */

	int add(int num1, int num2) {
		return num1 + num2;
	}

	int sub(int num1, int num2) {
		return num1 - num2;
	}

	int mul(int num1, int num2) {
		return num1 * num2;
	}

	int div(int num1, int num2) {
		return num1 / num2;
	}

	// 위의 정의된 사칙연산과 연관된 기능을 하나로 합치자
	/**
	 * 
	 * @param type
	 *            : 1(더하기), 2(빼기), 3(곱하기), 4(나누기)
	 * @param num1
	 * @param num2
	 * @return
	 */
	int cal(int type, int num1, int num2) {

		if (type == 1)
			return num1 + num2;
		if (type == 2)
			return num1 - num2;
		if (type == 3)
			return num1 * num2;
		if (type == 4)
			return num1 / num2;

		return 0;
	}

	/*
	 * // 리펙토링 전... int[] makeNumbers() {
	 * 
	 * int[] arrRandom = new int[5]; Random r = new Random();
	 * 
	 * boolean falg = false; for(int i = 0; i < 5; i++) { arrRandom[i] =
	 * r.nextInt(10) + 1; }
	 * 
	 * return arrRandom;
	 * 
	 * }
	 * 
	 * int[] makeNumbers(int count) {
	 * 
	 * int[] arrRandom = new int[count]; Random r = new Random();
	 * 
	 * for(int i = 0; i < count; i++) { arrRandom[i] = r.nextInt(10) + 1; }
	 * return arrRandom;
	 * 
	 * }
	 * 
	 * int[] makeNumbers(int count, int max) {
	 * 
	 * int[] arrRandom = new int[count]; Random r = new Random();
	 * 
	 * for(int i = 0; i < count; i++) { arrRandom[i] = r.nextInt(max) + 1; }
	 * return arrRandom;
	 * 
	 * }
	 */

	int[] makeNumbers() {
		return makeNumbers(5, 10);
	}

	int[] makeNumbers(int count) {
		return makeNumbers(count, 10);
	}

	int[] makeNumbers(int count, int max) {
		int[] arrRandom = new int[count];
		Random r = new Random();

		for (int i = 0; i < count; i++) {
			arrRandom[i] = r.nextInt(max) + 1;
		}
		return arrRandom;
	}
	
}
