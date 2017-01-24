package day11;

import java.util.ArrayList;
import java.util.List;

class Food {

}

class Tonkatsu extends Food {
	
}

class Pizza extends Food {

}

public class Test05 {
	public static void main(String[] args) {
		//Tonkatsu ton = new Food();	// 컴파일 오류 발생
		//Tonkatsu ton = (Tonkatsu)new Food();	// 실행시 오류 발생
		
		// 올바른 명시적 형변환은 묵시적인 형변환이 이루어진 객체를 대상으로 함
		Food f = new Tonkatsu();		// 묵시적 형변환 객체
		Tonkatsu ton2 = (Tonkatsu)f;	// 명시적 형변환
	}
}
