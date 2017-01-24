package day17;

import java.io.BufferedReader;
import java.io.FileReader;

public class Exam03 {
	public static void main(String[] args) {
		try {
			searchEmployeeInfo("data/employee.txt", "김");
			searchEmployeeInfo("data/employee.txt", "다");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param readFileName
	 *            : 읽을 파일명
	 * @param lastName
	 *            : 찾을 성씨
	 * @throws Exception
	 */
	public static void searchEmployeeInfo(String readFileName, String lastName) throws Exception {

		FileReader fr = new FileReader(readFileName);
		BufferedReader br = new BufferedReader(fr);

		String str = "";
		String result = "";
		int k = 0;
		while ((str = br.readLine()) != null) {
			if (str.substring(0, 1).indexOf(lastName) > -1) {
				result += str + " ";
				k++;
			}
		}

		String[] person = new String[k];
		person = result.split(" ");
		System.out.println("===========================================================");
		for (int i = 0; i < k; i++) {
			String[] arrStr = person[i].split(":");
			System.out.println(
					String.format("이름 : %s\t나이 : %s\t\t부서 : %s\t월급 : %s", arrStr[0], arrStr[1], arrStr[2], arrStr[3]));
		}
		
		System.out.println("===========================================================");
		System.out.println(String.format("%s씨 성을 가진 회원은 총 %d명 입니다.", lastName, k));
		System.out.println("===========================================================");

	}
}
