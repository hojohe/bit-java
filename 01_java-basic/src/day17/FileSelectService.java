package day17;

import java.io.FileReader;
import java.util.Scanner;

public class FileSelectService {
	Scanner sc = new Scanner(System.in);
	
	void print() {
		while(true) {

			System.out.println("-------------------------------------");
			System.out.println("1. 검색결과를 화면에 출력");
			System.out.println("2. 검색결과를 파일에 저장");
			System.out.println("3. 저장된 결과 보기");
			System.out.println("4. 종료");
			System.out.println("-------------------------------------");
			System.out.println("메뉴 선택(1-4) :");

			switch (Integer.parseInt(sc.nextLine())) {
				case 1:
					select();
					break;
				case 2:
					insert();
					break;
				case 3:
					selectOne();
					break;
				case 4:
					exit();
					break;
			}
		}
	}
	
	void exit() {
		System.out.println("-------------------------------------");
		System.out.print("종료하시겟습니까? (취소 : N, 종료 : 엔터) :");
		String input = sc.nextLine();
		if(input.equals("N")) {
			System.out.println("취소하였습니다.");
		} else {
			System.out.println("종료되었습니다.");
			System.exit(0);
		}
		System.out.println("-------------------------------------");
	}
	
	
	void select() {
		
		
		
		System.out.println("-------------------------------------");
		System.out.print("검색할 디렉토리 : ");
		String directory = sc.nextLine();
		System.out.print("검색할 파일 확장자 : ");
		String fileType = sc.nextLine();
		System.out.print("검색할 단어 : ");
		String word = sc.nextLine();
		System.out.print("검색된 단어 양옆에 표시할 문자 : ");
		String mark = sc.nextLine();
		System.out.println("-------------------------------------");
		
		
		
		System.out.println("-------------------------------------");
		System.out.println("검색된 결과");
		System.out.println("-------------------------------------");
		
		for(int i = 0; i < ; i ++) {
			System.out.println("파일명 : ");
		}
		
		System.out.println("-------------------------------------");
		
		
	}

}
