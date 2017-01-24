package day06;

class Test01Sub {
	int val;
	String msg;
}

public class Test01 {
	public static void main(String[] args) {
		
		Test01Sub sub = new Test01Sub();
		System.out.println("val = " + sub.val);
		System.out.println("msg = " + sub.msg);
		
		Test01Sub sub2 = new Test01Sub();
		System.out.println("val2 = " + sub2.val);
		System.out.println("msg2 = " + sub2.msg);
		
		Test01Sub sub3 = sub2;
		
		sub.val = 100;
		sub2.val = 200;
		sub3.val = 300;
		System.out.printf("%d, %d, %d\n", sub.val, sub2.val, sub3.val);
		
	}
}
