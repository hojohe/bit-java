package day05.quiz;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz02 {
	
	
	public static void main(String[] args) {
		
		int [] arr = {6,8,3,9,7,4};
		
		Scanner sc = new Scanner(System.in);
		int i1 = Integer.parseInt(sc.next());
		int i2 = Integer.parseInt(sc.next());
		
		/* copy
		int [] dest = new int[6];
		System.arraycopy(arr, 0, dest, 0, 6);
		*/
		
		int tmp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = tmp;
		
		System.out.println("arr 배열의 결과 : " + Arrays.toString(arr) );
	}
	

}
