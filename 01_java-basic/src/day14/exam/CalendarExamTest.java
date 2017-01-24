package day14.exam;

import java.util.Scanner;

public class CalendarExamTest {

	public static void main(String[] args) {

		CalendarUI ui = new CalendarUI();
		ui.printCalendar();

	}
}

class CalendarUI {

	void printCalendar() {
		CalendarExam ce = new CalendarExam();
		Scanner sc = new Scanner(System.in);
		int yyyy = 0;
		int mm = 0;
		while (true) {
			System.out.print("항목을 선택하세요(1. 특정년도 날짜 보기 2. 특정월 날짜 보기 3. 종료) : ");
			int menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) {

				System.out.print("년도를 입력하세요 : ");
				yyyy = Integer.parseInt(sc.nextLine());
				
				ce.executeYyyy(yyyy);

			} else if (menu == 2) {

				System.out.print("년도를 입력하세요 : ");
				yyyy = Integer.parseInt(sc.nextLine());
				System.out.print("월을 입력하세요 : ");
				mm = Integer.parseInt(sc.nextLine());
				
				ce.executeYyyyMm();

			} else {

				System.exit(0);

			}
		}

	}

}
