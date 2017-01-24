package day03;

public class Test01 {
	public static void main(String[] args) {
		
		int  i = 257;
		byte b = 100;
		
		//묵시적 형변환, 암묵적 형변환, 업캐스팅
		int i2 = b;
		
		//byte b2 = i;//컴파일 에러 발생

		//명시적 형변환, 다운캐스팅
		byte b2 = (byte)i;
		
		System.out.println(i2);
		System.out.println(b2);
		
		char c = 'a';
		int i3 = c;
		
		System.out.println(i3);

		// 'C'의 아스키 코드를 화면에 출력하시오
		char c1 = 'C';
		int i4 = c1;
		
		System.out.println(i4);
		System.out.println((int)c1);
		
		int i5 = 'C';
		System.out.println(i5);
		
		System.out.println((int)'C');
		
	}
}
