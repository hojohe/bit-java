package day12.exam;

public class Duck extends Animal implements Flyable {

	String str;

	public Duck(String str) {
		this.str = str;
	}

	public void fly() {
		System.out.println(str + ": 날개를 퍼덕이지만 날지 못합니다.");
	}

	public void eat() {
		System.out.println(str + ": 먹습니다.");
	}

	public void cry() {
		System.out.println(str + ": 꽥꽥웁니다.");
	}

}
