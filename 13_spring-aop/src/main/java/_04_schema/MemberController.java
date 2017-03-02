package _04_schema;

import java.util.Random;

public class MemberController implements Controller {
	@Override
	public void execute() throws Exception {
		// �ٽɱ�� - ��� ���� 
		Random r = new Random();
		for(int i = 0; i < r.nextInt(100); i++) {
			Thread.sleep(100);
		}
		System.out.println("MemberController 실행 됨");
	}
}
