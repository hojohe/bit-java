package day10.exam;

import java.util.Arrays;

public class Exam03 {

	public String[] parsing(String str1, String str2) {

		char[] str = str1.toCharArray();
		int[] index = new int[4];
		int cnt = 0;
		int k = 0;

		String[] result = new String[5];

		for (int i = 0; i < str1.length(); i++) {

			if (str[i] == '#') {
				index[cnt] = str1.indexOf("#", (k + 1));
				k = index[cnt];
				if (cnt == 0) {
					result[cnt] = str1.substring(0, index[cnt]);
				} else {
					result[cnt] = str1.substring((index[cnt - 1] + 1), k);
				}
				cnt++;
			}
			if (cnt == 4) {
				result[cnt] = str1.substring((index[cnt - 1] + 1), str1.length());
			}

		}

		return result;

	}

	public static void main(String[] args) {
		Exam03 ex = new Exam03();
		String str = "PROD-001#X-note#Samsung#3#600000";
		String[] strs = ex.parsing(str, "#");
		System.out.println("=== 문자열 처리 결과 ===");

		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}

	}

}
