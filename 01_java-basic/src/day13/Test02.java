package day13;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test02 {
	public static void main(String[] args) {

		try {
			// 1. JVM은 해당 예외상황과 연관있는 예외클래스를 찾는다.
			// 2. 해당 예외클래스 객체를 생성한다.(new FileNotFoundException(..))
			// 3. 발생한 예외를 처리할 수 있는 catch문이 있는지 찾는다.
			// 4 - 1. 처리할 수 있는 catch문이 있다면 발생된 예외객체를 넘겨준다. 
			// 5. catch문에 예외처리 구문을 작성한다.
			FileReader fr = new FileReader("a.txt");
		} catch (FileNotFoundException e) {
			// 발생된 예외 정보를 간단하게 확인하기
			System.out.println(e.getMessage());

			// 상세한 정보를 출력하기 위해서 사용
			e.printStackTrace();
		}
	}
}
