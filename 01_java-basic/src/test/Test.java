package test;

public class Test {
	public static void main(String[] args) {
		for (int i = 0; i <= 10; i++) {
			if (i <= 5) {
				for (int j = 0; j <= i; j++) {
					System.out.print("*");
				}

				System.out.println("");
			}
			if (i > 5) {
				for (int z = 10; z >= i; z--) {
					System.out.print("*");
				}

				System.out.println("");
			}

		}

		int aA = 10;
		int bB = 5;
		int max = (aA > bB) ? aA : bB;
		System.out.println(max);

		System.out.println("A" instanceof String);

		int a = 10, b = 5;
		if (a > b) {
			if (a == 10)
				System.out.println("a = 10");
			// System.out.println("a가 b보다 크다");
			else
				System.out.println("b가 a보다 크다");
		}
	}
}
