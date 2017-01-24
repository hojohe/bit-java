package day04;

public class Test01 {
	public static void main(String[] args) {
		
		/*********************************
		 * 
		 *    for(1.초기값; 2.조건식; 3.증감) {
		 * 		 4.
		 * 	 	 실행문장;
		 * 		 실행문장;
		 *    }
		 * 
		 *    1 > 2(true) > 4 > 3 
		 * 		> 2(true) > 4 > 3 
		 * 		> 2(true) > 4 > 3
		 *      .....
		 *      .....
		 * 		> 2(false) > 블럭밖으로 나옴
		 * 
		 *    (참고) 1,2,3번 항목 모두를 비워 둘 수 있다.
		 *    
		 *    for(;;)
		 *    for(1;2;3)
		 *    for(1;2;)
		 *    for(1;;)
		 *    for(;2;3)
		 *    for(;2;)
		 * 
		 *********************************/
		
		for(int i=1; i<=10; i++) {

			int val=i;
			if(i%3 != 0) val = i * 2;
			System.out.println(val);
			
			/*if(i%3 == 0) { 
				System.out.println(i);
			}else { 
				System.out.println(i*2);
			}*/
			
		}
		
		
		/*
		int val = 1;
		//무한반복 실행됨
		for(;;) {
			System.out.println(val++);
		}
		*/
	}
}
