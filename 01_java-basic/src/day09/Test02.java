package day09;

class Sub02 {
	int i = 100;
	static int k = 100;
	// static 블럭 : 클래스정보가 로딩될 때 같이 실행된다.
	static {
		System.out.println("static 블럭이 실행됨");
	}
	Sub02() {
		System.out.println("생성자 호출됨..");
	}
}
public class Test02 {
	public static void main(String[] args) {
		System.out.println(0);
		Sub02 s01;
		System.out.println(1);
		System.out.println(Sub02.k);
		System.out.println(2);
		Sub02 s02 = new Sub02();
		System.out.println(3);
		Sub02 s03 = new Sub02();
		System.out.println(4);
	}
}
