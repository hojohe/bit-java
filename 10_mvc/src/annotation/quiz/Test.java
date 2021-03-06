package annotation.quiz;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) throws Exception {
		
		Class<?> clz = BoardController.class;
		Object obj = clz.newInstance();
		
		Method[] mArr = clz.getDeclaredMethods();
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.print("경로 : ");
			String url = sc.nextLine();
			if (url.equals("quit")) break;
			
			for(Method m: mArr) {
				RequestMapping rMpp = m.getAnnotation(RequestMapping.class);
				if(rMpp == null) continue;
				
				if(url.equals(rMpp.value())) m.invoke(obj);
				
			}
		}
	}
}
