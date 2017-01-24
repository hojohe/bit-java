package day16.exam;

public class PersonTest {
	public static void main(String[] args) {
		
		try {
			Person p = new Person();
			p.printPerson();
		} catch (PersonException e) {
			e.printStackTrace();
		}
	}
}
