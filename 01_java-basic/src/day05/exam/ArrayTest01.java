package day05.exam;

import java.util.Scanner;

public class ArrayTest01 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("당신의 태어난 년도를 입력하세요 : ");
			int input = Integer.parseInt(sc.nextLine());
			
			int birth = 1980;
			String[] animal = { "원숭이", "닭", "개", "돼지", "쥐", "소", "호랑이", "토끼", "용", "뱀", "말", "양" };

			int tmp = (input - birth) % 12;
			if (input < birth) {
				tmp = 12 - ((birth - input) % 12);
			}

			System.out.printf("당신의 %d년에 태어난 당신은 %s 입니다. \n", input , animal[tmp]);
		}

	}
}
