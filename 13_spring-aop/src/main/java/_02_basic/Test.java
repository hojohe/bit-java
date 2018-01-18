package _02_basic;

public class Test {
	public static void main(String[] args) {
		
		try {
			
			Controller controller = new BoardController();

			long s = System.currentTimeMillis();
			
			controller.execute();
			
			long e = System.currentTimeMillis();
			double time = (e-s) / 1000d;
			
			System.out.println("BoardController execute 결과 : " + time);
			
			controller = new MemberController();
			
			s = System.currentTimeMillis();
			
			controller.execute();
			
			e = System.currentTimeMillis();
			time = (e-s) / 1000d;
			
			System.out.println("MemberController execute 결과 : " + time);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}