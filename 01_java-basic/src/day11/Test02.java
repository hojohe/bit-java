package day11;

class Parent /* extends java.lang.Object */ {
	
	Parent() {}
	Parent(String name) {
	}
}

class Child2 extends Parent {
	Child2() {
		super("aaa");
	}
}

class Child extends Parent{
	
	Child() {
		// super(); // 자동 추가됨
		System.out.println("C-1");
	}
	
	Child(String name) {
		System.out.println("C-2");
	}
	
}

public class Test02 {
	public static void main(String[] args) {
		
	}
}
