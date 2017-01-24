package day11;

class Animal {
	String name;

	Animal() {
	}

	Animal(String name) {
		this.name = name;
	}

	void tell() {
		System.out.println("Animal tell");
	}
}

class Cat extends Animal {
	String name;

	Cat() {
	}

	Cat(String name) {
		this.name = name;
	}

	void tell() {
		System.out.println("Cat tell");
	}
	
	void eat() {
		System.out.println("Cat eat");
	}
}

public class Test04 {
	public static void main(String[] args) {
		Animal a = new Cat("나비");
		System.out.println(a.name);
		a.tell();
	}
}
