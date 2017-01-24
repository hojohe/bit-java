package day12;

// 추상클래스
abstract class AbsSuper {
	
	// 추상매서드 : 구현되지 않은 메서드
	public abstract void test();

	public void call() {
		System.out.println("메서드 바디");
	}
}

class AbsSub extends AbsSuper {
	public void test() {
		System.out.println("재정의된 메서드입니다.");
	}

}

public class Test01 {
	public static void main(String[] args) {
		// AbsSuper absSuper = new AbsSuper();
		// 추상클래스의 객체는 자식 클래스를 이용함
		AbsSuper absSuper = new AbsSub();
		absSuper.call();
		absSuper.test();
	}
}
