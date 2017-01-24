package day05.exam;

import java.util.Random;

public class ArrayTest03 {
	public static void main(String[] args) {

		Random r = new Random();
		int[] arrCnt = new int[45];

		for (int i = 0; i < 10000; i++) {
			int randomNum = r.nextInt(45) + 1;
			arrCnt[randomNum-1]++;
		}
		
		for(int i = 0; i<arrCnt.length; i++) {
			System.out.printf("%3d : %6d \n", i+1, arrCnt[i]);
		}
		
	}
}
