package day03;

public class Test05 {
	public static void main(String[] args) {
		
		/********************************************
		1.  switch(수식) {
				case 값1 :
					수식과 값1이 같을 때 수행할 문장
				case 값2 :
					수식과 값2이 같을 때 수행할 문장
				default : 
					위의 모든 조건이 만족하지 않은 경우 수행할 문장
			}
			
			
			switch 블럭을 빠져나가기 위한 break; 함께 사용
		 ********************************************/
		int a = 2;
		switch (a) {
			case 1:
				System.out.println(a + 10  );
				break;
			case 2:
				System.out.println(a + 100 );
				break;
			default :
				System.out.println(a + 1000);
				break;
		}
		
	}
}
