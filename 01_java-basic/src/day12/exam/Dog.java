package day12.exam;

public class Dog extends Animal {

	String str = null;

	public Dog(String str) {
		this.str = str;
	}

	public void eat() {
		System.out.println(str + ": 먹습니다.");
	}

	public void cry() {
		System.out.println(str + ": 멍멍 짖습니다.");
	}

}
