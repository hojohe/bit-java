package day07;

import java.util.Arrays;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {

		Sub03 s03 = new Sub03();

		System.out.println("addResult = " + s03.add(10, 1));
		System.out.println("subResult = " + s03.sub(10, 1));
		System.out.println("mulResult = " + s03.mul(10, 1));
		System.out.println("divResult = " + s03.div(10, 1));

		System.out.println();
		System.out.println();
		
		System.out.println("addResult = " + s03.cal(1, 10, 1));
		System.out.println("subResult = " + s03.cal(2, 10, 1));
		System.out.println("mulResult = " + s03.cal(3, 10, 1));
		System.out.println("divResult = " + s03.cal(4, 10, 1));
		System.out.println("Type이 1ㅡ2ㅡ3ㅡ4 아닐때 = " + s03.cal(5, 10, 1));

		System.out.println();
		System.out.println();
		
		System.out.println(Arrays.toString(s03.makeNumbers()));
		System.out.println(Arrays.toString(s03.makeNumbers(10)));
		System.out.println(Arrays.toString(s03.makeNumbers(6, 45)));
		
		
		
		
		
		
		
	}
}
