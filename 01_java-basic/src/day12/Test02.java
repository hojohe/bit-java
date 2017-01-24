package day12;

interface InterA {
	public void a();
}

// 인터페이스가 인터페이스를 상속받을때는 extends
interface InterB extends InterA {
	public void b();
}

interface InterSuper {
	// 인터페이스에 선언되는 변수에는 public static final 키워드가 자동으로 삽입된다.
	// public static final int PORT 상수로 선언됨!
	int PORT = 8000;
	
	// public abstract void call();
	void call();

	void print();
	
	// 1.8 버전부터 가능한 인터페이스 기능
	default void test() {
		System.out.println("default");
	}
	static void test2() {
		System.out.println("static");
	}
}

class InterSub implements InterSuper, InterB {
	public void call() {
		System.out.println("재정의된 call()");
	}

	public void print() {
		System.out.println("재정의된 print()");
	}

	public void b() {

	}

	public void a() {

	}
}

public class Test02 {
	public static void main(String[] args) {

		// InterSuper iSuper = new InterSuper();
		InterSuper iSuper = new InterSub();
		iSuper.call();
		iSuper.print();
		InterB ib = new InterSub();
		InterA ia = new InterSub();
		
		System.out.println("static변수 : " + InterSuper.PORT);
		System.out.println("static변수 : " + iSuper.PORT);// static 개념이기 떄문에 클래스.변수로 접근
		//InterSuper.PORT = 9000; // final 개념이기 때문에 변수에 값 할당이 안됨(오류발생)
		
	}
}