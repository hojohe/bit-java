package day03;

import java.util.Random;

public class Test07 {
	public static void main(String[] args) {
		
		//객체 생성
		Random r = new Random();

		//난수 발생
		int  num = r.nextInt(12) + 1;
		
		//결과 출력
		System.out.println("num = " + num);
		
	}
	

}
