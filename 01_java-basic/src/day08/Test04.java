package day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) throws FileNotFoundException {
		
		File f = new File("data/day08/test04.txt");
		Scanner sc = new Scanner(f);
		System.out.println(sc.nextLine());
		System.out.println(sc.nextLine());
		
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
		
	}	
}
