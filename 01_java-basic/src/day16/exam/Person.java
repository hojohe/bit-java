package day16.exam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
	
	public void printPerson() throws PersonException {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("항목을 선택하세요 : (1.지역명 2.이름 3.종료)");

			validCheck(sc.nextLine());
			
			int menu = Integer.parseInt(sc.nextLine());
			
			
			if (menu == 1) {
				System.out.println("지역명을 입력하세요 : ");
				String area = sc.nextLine();
				executeArea(area);
				
			} else if (menu == 2) {
				System.out.println("이름을 입력하세요 : ");
				String name = sc.nextLine();
				executeName(name);
				
			} else if (menu == 3) {
				System.out.println("검색된 결과를 저장 후 종료하시겠습니까?(Y/N)");
				String end = sc.nextLine();
				
				if (end.equals("N"))	System.exit(0);
				else 					executeEnd(end);
			
			} else {
			
				System.out.println("항목을 다시 선택하세요");
				
			}
			
		
		}
		
	}
	
	void validCheck(String menu) throws PersonException {
		
		Pattern p = Pattern.compile("[0-9]");
		Matcher m = p.matcher(menu);
		if(!m.find()) {
			throw new PersonException("숫자만 입력 가능합니다.");
		}
		
		if(Integer.parseInt(menu) < 1 || Integer.parseInt(menu) > 3) {
			System.out.println("항목을 다시 선택하세요");
		}
	}
	
	void executeArea(String area) {
		
	}
	
	
	void executeName(String name) {
		
	}
	
	
	void executeEnd(String end) {
		System.exit(0);
	}
	
	
}