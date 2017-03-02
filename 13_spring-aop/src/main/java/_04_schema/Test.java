package _04_schema;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		
		try {
			
			ApplicationContext context = new ClassPathXmlApplicationContext("schema/test.xml");
			Controller controller = (BoardController)context.getBean("board");
			controller.execute();
			
			// 스프링은 인터페이스 상속 개념을 인정해주지 않음 그래서 xml에  proxy-target-class="true" 설정해줘야함
			controller = (MemberController)context.getBean("member");
			controller.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
