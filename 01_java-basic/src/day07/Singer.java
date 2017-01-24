package day07;

/*
 * 멤버변수는 private로 선언
 * 멤버변수에 대한 값을 설정, 추출하는 
 * 메서드를 만들어서 활용
 */
public class Singer {
	private String name;
	private int age;

	// 멤버변수에 대한 설정(setter)와 추출(getter)를 선언
	// setter선언
	// 접근제한자  반환타입    메서드명    매개변수
	// public  void    set변수명  변수에 들어갈 값의 타입
	public void setName(/* Singer this, */String name) {
		this.name = name;
	}
	// getter선언
	// 접근제한자  반환타입    메서드명    매개변수
	// public  변수의타입  get변수명 
	public String getName() {
		return name;
	}
	
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
}