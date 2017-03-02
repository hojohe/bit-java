package _01_basic;

import java.util.Random;

public class MemberController implements Controller {
	@Override
	public void execute() throws Exception {

		// ������ - ����ð� ���� ���
		long s = System.currentTimeMillis();
		
		// �ٽɱ�� - ��� ���� 
		Random r = new Random();
		for(int i = 0; i < r.nextInt(100); i++) {
			Thread.sleep(100);
		}
		
		long e = System.currentTimeMillis();
		double time = (e-s) / 1000d;
		
		System.out.println("MemberController execute 결과 : " + time);
		
	
	}
}
