package day07;

import java.util.Random;

public class Sub01 {

	void method01() {
		System.out.println("method01 ");
	}
	void method02(int i) {
		System.out.println("method02 " + i);
	}
	void method03(int i, int j) {
		System.out.println("method03 " + i + ", " + j);
	}
	void method04(char a) {
		System.out.println("method04 " + a);
	}
	void method05(String s) {
		System.out.println("method05 " + s);
	}
	void method06(Random r) {
		System.out.println("method06 " + r.nextInt(2));
	}
	
}