package day02.quiz;

public class Quiz01 {

	public static void main(String[] args) {

		int i = 0;

		try {

			i = 100;

		} catch (Exception e) {

			System.out.println(e);

		} finally {

			System.out.println(i);
		}

	}

}
