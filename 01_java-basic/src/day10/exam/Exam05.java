package day10.exam;

public class Exam05 {

	private static String leftPad(String str, int size, char c) {

		String result = "";
		int a = 0;

		if (str.length() > size) {
			result = "변환할 수 없습니다.";
		} else {

			a = size - str.length();

			for (int i = 0; i < a; i++) {
				result += c;
			}
			result += str;
		}

		return result;

	}

	public static void main(String[] args) {
		System.out.println(leftPad("JAVA", 10, '#'));
		System.out.println(leftPad("C", 10, '$'));
		System.out.println(leftPad("S-CORE", 10, '*'));
		System.out.println(leftPad("BIT JAVA", 5, '@'));

	}

}
