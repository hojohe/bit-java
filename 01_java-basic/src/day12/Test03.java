package day12;

import java.util.Random;

/* final 클래스는 상속 관계가 될 수 없다
class MyString extends String {
	
}
*/
class OverClass {
	/* final */ public void test() {}
}

class SubClass extends OverClass {
	public void test() {
		System.out.println("오버라이딩된 메서드");
	}
}

class MyRandom extends Random {
	public int nextInt(int i) {
		return super.nextInt(i) + 1;
	}
}

public class Test03 {
	public static void main(String[] args) {
		Random r = new MyRandom();
		int num = r.nextInt(10);
		System.out.println(num);
	}
}
