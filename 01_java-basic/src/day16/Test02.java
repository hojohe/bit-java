package day16;

import java.io.File;

public class Test02 {
	public static void main(String[] args) {
		File f = new File("data");

		File[] fList = f.listFiles();

		for (File sub : fList) {

			String type = sub.isDirectory()? "D" : "F";
			
			
/*			if (sub.isDirectory()) {
				type = "D";
			} else if (sub.isFile()) {
				type = "F";
			}
*/			System.out.println(type + ":" + sub.getName());
			System.out.printf("%s:%s\n", sub.isDirectory()? "D" : "F", sub.getName());
			
		}

		/*
		 * String[] list = f.list(); for (String name : list) {
		 * 
		 * File tmp = new File("data/" + name); 
		 * String type = ""; 
		 * if (tmp.isDirectory()) { 
		 * type = "D:"; 
		 * } 
		 * else if (tmp.isFile()) { 
		 * type = "F:"; 
		 * } 
		 * System.out.println(type + name);
		 * 
		 * }
		 */

	}
}
