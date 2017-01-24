package day13;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test06 {
	public static void main(String[] args) {

		try {
			a();
		} catch (Exception e) {
			System.out.println("점장... 예외 총괄 처리..");
		}
	}

	private static void a() throws FileNotFoundException {
		try {
			FileReader fr = new FileReader("a.txt");
		} catch (FileNotFoundException e) {
			System.out.println("알바 자체 원리 처리...");
			// 예외의 강제 발생
			throw e;
		}

	}
}
