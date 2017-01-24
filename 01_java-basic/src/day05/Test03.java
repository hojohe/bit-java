package day05;

import java.util.Arrays;
import java.util.Random;

public class Test03 {
	public static void main(String[] args) {

		// 배열에 입력된 요소를 확인하는 방법
		int[] iArr = { 10, 20, 30 };

		// 1번 방법
		System.out.println("1번 방식");
		for (int i = 0; i < iArr.length; i++) {
			System.out.println(iArr[i]);
		}
		System.out.println("-------------");

		// 2번 방법 : 향상된 for문(1.5 이후 가능)
		System.out.println("2번 방식");
		for (int i : iArr) {
			System.out.println("요소값 : " + i + " , 배열 크기 : " + iArr.length);
		}
		System.out.println("-------------");

		boolean[] bArr = { true, false };
		for (boolean b : bArr) {
			System.out.println("요소값 : " + b + " , 배열 크기 : " + bArr.length);
		}
		System.out.println("-------------");

		char[] cArr = { 'a', 'b', 'c' };
		for (char c : cArr) {
			System.out.println("요소값 : " + c + " , 배열 크기 : " + cArr.length);
		}
		System.out.println("-------------");

		Random[] rArr = { null, null, null };
		for (Random r : rArr) {
			System.out.println("요소값 : " + r + " , 배열 크기 : " + rArr.length);
		}
		System.out.println("-------------");
		
		
		// 3번 방법 : 단순히 배열의 요소값만을 확인
		System.out.println("3번 방식");
		String data = Arrays.toString(iArr);
		System.out.println("toString : " + Arrays.toString(iArr));
		

	}
}
