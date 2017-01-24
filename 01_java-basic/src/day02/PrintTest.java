package day02;

public class printTest {
	public static void main(String[] args) {
	    /*
		 *
		 * System.out.println();
		 * System.out.print();
		 * System.out.printf();
		 * 
		*/
		
		/*
		System.out.println("나의");
		System.out.print("이름은 홍\t길\t동 입니다.\n");
		
		System.out.print("나의\n이름은\n\n홍길동입니다.");
		*/
		
		// 나의 이름은 홍길동이고 나이는 33세 입니다.		
		String name = "홍길동";
		int age = 33;
		System.out.print("나의 이름은 "+ name +"이고 나이는 " + age + "세 입니다.\n");
		System.out.printf("나의 이름은 %s이고 나이는 %5d세 입니다.\n", name , age);
		System.out.printf("|%5d|	\n", age);
		System.out.printf("|%05d|	\n", age);
		System.out.printf("|%-5d|	\n", age);
		System.out.printf("|%.2f|	\n", 3.14);
		System.out.printf("|%5.2f|	\n", 3.14);
		System.out.printf("|%-5.2f|	  ", 3.14);
		
	}
}
