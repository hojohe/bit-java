package day11;

public class Person {
	
	String name; //접근제한자를 막으면 상속시에도 접근이 불가능하다.
	int age;
	String no;
	public Person() {
		
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return String.format("name=%s , age=%d", name, age);
	}
	
}
