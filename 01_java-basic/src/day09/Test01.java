package day09;

public class Test01 {
	public static void main(String[] args) {
		
		Dog d = new Dog();
		d.setName("로뎅");
		d.setAge(8);
		
		//값을 알고 있을때 set 불필요하다. 생성자 만들면서 바로 초기화해준다.
		Dog d2 = new Dog("로뎅", 8); // 필수 값인것만 넘겨준다.
		System.out.println("d> " + d.getName() +  ", " + d.getAge());
		System.out.println("d2> " + d2.getName() +  ", " + d2.getAge());
		
	}
}
