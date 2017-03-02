package _04_schema;

import java.util.Random;

public class BoardController implements Controller {

	@Override
	public void execute() throws Exception {
		
		// 핵심기능 - 등록 과정
		Random r = new Random();
		for(int i = 0; i < r.nextInt(100); i++) {
			Thread.sleep(100);
		}
		System.out.println("BoardController 실행 됨");
	}
}
