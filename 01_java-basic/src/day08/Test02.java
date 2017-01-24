package day08;

public class Test02 {
	public static void main(String[] args) {

		System.out.println("시간 측정 시작");
		// 값이 바뀔때마다 자기공간을 계속 새로 만듬 (공간 확장)
		String s1 = "a";

		// StringBuffer, StringBuilder는 자기 자신의 공간 값을 변경
		// 차이점 : StringBuffer(동기화 - 안전), StringBuiler(비동기화 - 위험)
		// 비동기화 안에서 위험한 요소는 동기화 해주면서 코딩
		// 공간 확장이 매번 일어나지 않는다. 꽉찼을때만 (현재크기 *2 + 2)? 확장해줌
		StringBuffer s2 = new StringBuffer("a");
		// 1.5부터
		StringBuilder s3 = new StringBuilder("a");

		// currentTimeMillis초기값 1970년 1월 1일 0시 0분 1초
		// 1000 = 1초
		long s = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			s1 += i;
		}
		long e = System.currentTimeMillis();
		double time = (e - s) / 1000.0;
		
		System.out.println("String : " + time);
		
		
		s = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			s2.append(i);
		}
		e = System.currentTimeMillis();
		time = (e - s) / 1000.0;
		
		System.out.println("StringBuffer : " + time);
		
		s = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			s3.append(i);
		}
		e = System.currentTimeMillis();
		time = (e - s) / 1000.0;
		
		System.out.println("StringBuilder : " + time);
	}
}
