package day12.exam;

import java.util.Random;

abstract class Shape {
	
}

class Rectangle extends Shape{
	
}

public class Test01 {
	public static void main(String[] args) {
		
		Random r = new Random();
		int num = r.nextInt();
		
		if(num == 1) {
			Shape s = new Rectangle();
		}else if(num == 2) {
			
		}else if(num == 3) {
			
		}else if(num == 4) {
			
		}
		
	}
}
