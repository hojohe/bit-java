package day03.exam;

import java.util.Scanner;

public class Exam02 {
	public static void main(String[] args) {
		
		//객체 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.print("초를 입력하세요 : ");
		
		//화면에서 입력받아 형변환
		int inputSecond = Integer.parseInt(sc.nextLine());

		//시간 계산하기
		int hh = inputSecond / 3600;
		int mm = inputSecond % 3600 / 60;
		int ss = inputSecond % 3600 % 60;
		
		//결과출력
		System.out.println(inputSecond + "초는 " + hh + "시간 " + mm + "분 " + ss + "초입니다.");
	
	}
}
