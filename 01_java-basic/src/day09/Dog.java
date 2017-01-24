package day09;

public class Dog {
	// 디폴트 생성자가 생성
	// 자바 컴파일러에 의해서
	// public Dob() {}
	private String name;
	private int age;
	
	public Dog() {
		/*this.name = "이름모름";
		this.age  = 0;*/
	}
	public Dog(String name) {
		// 생성자 안에서만 사용이 가능함
		// 생성자 내에서 첫번째 구문으로 선언되어야 함
		this(name, 1);
		/*this.name = name;
		this.age = 1;*/
	}
	// 생성자 호출하면서 값 세팅! 값을 알고 있을 경우에는 무조건 이런 형태로 
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
