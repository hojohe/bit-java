package day07;

import java.util.Random;

public class Test02 {
	public static void main(String[] args) {
		
		Sub02 s02 = new Sub02();
		
		int val = s02.method01();
		System.out.println("method01 : " + val);
		
		char ch = s02.method02();
		System.out.println("method02 : " + ch);
		
		String s = s02.method03();
		System.out.println("method03 : " + s);
		
		Random r = s02.method04();
		System.out.println("method04 : " + r.nextInt(10));
		
		int[] arr = s02.method05();
		System.out.println("method05 : " 
				+ arr[0] + ", " + arr[1] + ", " + arr[2]);
		
		HaHa ha = s02.method06(new KiKi());
		System.out.println("method06");
	}
}
class HaHa {}
class KiKi {}