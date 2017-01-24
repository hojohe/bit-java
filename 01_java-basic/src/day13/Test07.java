package day13;

import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호 : ");
		String juminNo = sc.nextLine();
		
		
		JuminService j = new JuminService();
		try {
			j.valid(juminNo);
			System.out.println("올바른 주민번호입니다.");
		} catch (JuminNumberException e) {
			System.out.println("오류발생...");
			e.printStackTrace();
		}
		
	}
}

