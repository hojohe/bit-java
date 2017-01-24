package day13;

import java.io.FileReader;

public class Test04 {
	public static void main(String[] args) {

		try {
			System.out.println(1);
			FileReader fr = new FileReader("data/a.txt");
			fr.read();
			System.out.println(2);
		} catch (Exception e) {
			System.out.println(3);
			// return;
			// System.exit(0);
		} finally {
			System.out.println(4);
		}
		System.out.println(5);
	}

}
