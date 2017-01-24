package day02;

public class VariableScopeTest {
	public static void main(String[] args) {
		// int a = 10;
		{
			int a = 10; // int타입(기본 자료형)의 a변수를 선언해 10으로 초기화
			System.out.println(a);
		}

		int a = 20;
		System.out.println(a);
	}

}
