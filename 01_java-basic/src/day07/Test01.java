package day07;

import java.util.Random;

public class Test01 {
	public static void main(String[] args) {

		Sub01 s = new Sub01();
		Random r = new Random();
		s.method01();
		s.method02(10);
		s.method03(10, 100);
		s.method04('a');
		s.method05("안녕");
		s.method06(r);

	}
}
