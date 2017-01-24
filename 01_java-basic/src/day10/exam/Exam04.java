package day10.exam;

public class Exam04 {
	
	private static String getNextId(String s) {
		
		String[] arr = s.split("-");
		String result = "";
		int num = Integer.parseInt(arr[1]);
		num += 1;
		return arr[0] + "-" +String.format("%05d", num);
	}
	
	public static void main(String[] args) {
		System.out.println(getNextId("USER-00007"));
		System.out.println(getNextId("ORDER-00009"));
		System.out.println(getNextId("PRODUCT-00003"));
	}
}
