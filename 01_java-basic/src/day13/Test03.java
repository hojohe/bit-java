package day13;

public class Test03 {
	public static void main(String[] args) {
		
		try {

			System.out.println(1);
			System.out.println(1 / 1);
			System.out.println(2);
			String s = null;
			System.out.println(s.length()); // NullPointerException
			System.out.println(3);

		} catch (ArithmeticException ae) {
			System.out.println(4);
		} catch (Exception e) {
			System.out.println(4);
		}
		System.out.println(5);
		
		
		/*try {

			System.out.println(1);
			System.out.println(1 / 1);
			System.out.println(2);
			String s = null;
			System.out.println(s.length()); // NullPointerException
			System.out.println(3);

		} catch (Exception ae) { //부모는 자식을 다 받을 수 있다. Exception 클래스가 부모
			System.out.println(4);
		}
		System.out.println(5);*/

		
		/*try {

			System.out.println(1);
			System.out.println(1 / 1);
			System.out.println(2);
			String s = null;
			System.out.println(s.length()); // NullPointerException
			System.out.println(3);

		// 1.7 이상부터 | 연산자로 묶을 수 있음
		} catch (ArithmeticException | NullPointerException ae) {
			ae.printStackTrace();
		}
		System.out.println(5);*/
		
		/*try {

			System.out.println(1);
			System.out.println(1 / 0);
			System.out.println(2);
			String s = null;
			System.out.println(s.length()); // NullPointerException
			System.out.println(3);

		} catch (ArithmeticException ae) {
			System.out.println(4);
		} catch (NullPointerException ne) {
			ne.printStackTrace();
		}
		System.out.println(5);*/
		
		
		
		
		/*try {

			System.out.println(1);
			System.out.println(1 / 0);
			System.out.println(2);

			try {
				String s = null;
				System.out.println(s.length()); // NullPointerException
			} catch (NullPointerException ne) {
				ne.printStackTrace();
			}

			System.out.println(3);

		} catch (ArithmeticException ae) {
			System.out.println(4);
		}
		System.out.println(5);*/
	}
}
