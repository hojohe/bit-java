package day11;

public class Student extends Person {
	
	String no;
	public Student() {
		// super(); // this([인자, ..]), super([인자, ..]) 형태의 호출이 없을 경우
		            // super() 코드가 자동 생성된다.
	}

	public Student(String no, String name, int age) {
		
		super(name, age);
		
		this.no = no;

		// 부모에 선언된 변수에 접근해서 사용하게 된다.
		// 주의사항. 
		// 접근제한자가 허용되는 범위내에서만 사용이 가능함.
		/*super.name = name;
		super.age = age;*/
		
	}

	public String toString() {
		return String.format("no=%s, %s", no, super.toString());
		
	}
	
}
