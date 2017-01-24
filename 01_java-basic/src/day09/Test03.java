package day09;

class Sub03 {
	static int count = 0;
}

public class Test03 {
	int i = 100;
	static int k = 100;
	
	public void call() {
		
		Sub03 sub = new Sub03();
		System.out.println("call() > sub.count = " + sub.count);
		sub.count = 100;
		System.out.println("call() > sub.count = " + Sub03.count);
		Sub03.count = 200;
		System.out.println("call() > sub.count = " + sub.count);
		
		// non-static 영역에서 static 영역의 변수 또는 메서드를 접근 할 수 있다.
		System.out.println(i);
		System.out.println(k);
	}
	
	public static void main(String[] args) {
		/*
		// static 영역에서 non-static(instance)영역의 변수 또는 메서드를 직접
		// 접근할 수 없다.
		System.out.println(i);
		call();
		*/
		// 인스턴스 영역의 변수 또는 메서드는 메모리를 생성한 후 접근해야 한다.
		System.out.println("k = " + k);
		Test03 t03 = new Test03();
		System.out.println(t03.i);
		t03.call();
	}
}
