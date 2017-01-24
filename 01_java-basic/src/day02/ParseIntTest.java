package day02;

public class ParseIntTest {
	
	public static void main(String[] args){
		
		System.out.println(args[0] + args[1]);
		System.out.println(Integer.parseInt(args[0]) + Integer.parseInt(args[1]));
		
		int args0 = Integer.parseInt(args[0]);
		int args1 = Integer.parseInt(args[1]);
		int args2 = args0 + args1;
		
		// 두수의 합 : 300
		System.out.println("두수의 합 : " + args2);
		System.out.println("두수의 합 : " + (args0 + args1));
		
		// 100 + 200 = 300
		System.out.println(args0 + " + " + args1 + " = " + args2);

		
	}

}
