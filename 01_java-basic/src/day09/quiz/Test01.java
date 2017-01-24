package day09.quiz;

class TestQuiz {
	
	// 생성자도 private으로 막을 수 있다.
	// 객체생성을 아무데서나 하지 못하도록 관리해줌! 싱글톤 패턴!!
	private TestQuiz() {
		
	}
	
	public void msg() {
		System.out.println("성공");
	}
	/*
	 * 위의 제공된 코드는 변경하지 않는다.
	 * 코드를 추가하여 Test01클래스에서 객체 변수를 얻을 수 있게 작성한다.
	 * 단, 코드를 추가하되. 생성자 추가는 안된다.
	 * 
	 */
	private static TestQuiz instance;
	static TestQuiz getInstance() {
		if(instance == null) {
			instance = new TestQuiz();
		}
		return instance;
	}
	
}

public class Test01 {
	public static void main(String[] args) {
		
		TestQuiz tq =  TestQuiz.getInstance();
		tq.msg();
		
	}
}
