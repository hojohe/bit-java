package day10.exam;

public class Exam06 {

	private static String translate(String str) {
 
		char[] arr = str.toCharArray();

		for (int i = 0; i < str.length(); i++) {
			if (arr[i] >= 65 && arr[i] <= 90) {
				arr[i] = (char) (arr[i] + 32);
			} else if (arr[i] >= 97 && arr[i] <= 122) {
				arr[i] = (char) ( arr[i] -32);
			}
		}
		return new String(arr);
	}

	public static void main(String[] args) {
		System.out.println(translate("hELLO wORLD jAVA"));
		System.out.println(translate("Java Program"));
	}

}
