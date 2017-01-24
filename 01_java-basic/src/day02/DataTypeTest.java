package day02;

public class DataTypeTest {
	public static void main(String[] args) {
		// 기본형은 8가지이고 소문자로 시작한다.
		// 논리형, 문자형, 숫자
		boolean bool = true;
		System.out.println(bool);
		bool = false;
		
		char ch = '가';
		char ch2 = 97;			//아스키코드
		char ch3 = '\u0061';	//유니코드 16진수
		char ch4 = 65;			//아스키코드
		char ch5 = '\uffff';	//유니코드 16진수
		
		System.out.println(ch);
		System.out.println(ch2);
		System.out.println(ch3);
		System.out.println("4 > " + ch4);
		System.out.println("5 > " + ch5);
		
		//숫자형
		byte b = 127;
		short s = 1;
		int i = 1;
		long l = 1l;
		l = 1L;
		l = 1;
		
		//float은 반드시 실수형 숫자 뒤에 f,F를 붙여야 한다. (데이터 크기 때문에)
		float f = 1.1f;
		f = 1.1F;
		
		double d = 1.1;
		
		System.out.println(b + " " + s + " " + i + " " + l + " " + f + " " + d);
		
	}
	
}
