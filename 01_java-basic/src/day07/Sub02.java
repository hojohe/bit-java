package day07;

import java.util.Random;

/**
 * 반환타입이 void가 아니라면
 * 반드시 method내에 return이 존재해야 함
 * return문 뒤에는 반환타입이 받을 수 있는 값을 설정해야 함
 */
public class Sub02 {
	
	int method01() {
		return 100;
	}
	
	char method02() {
		return 'a';
	}
	
	String method03() {
		return "성공";
	}
	
	Random method04() {
		Random r = new Random();
		return r;
	}
	
	int[] method05() {
		int[] list = new int[3];
		
		for(int i=0; i<list.length; i++) {
			list[i] = i + 1;
		}
		
		return list;
	}
	
	HaHa method06(KiKi kiki) {
		HaHa k = new HaHa();
		return k;
	}
	
}
