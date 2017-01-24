package day14;

import java.io.File;
import java.util.Date;

public class Test01 {
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);

		File f = new File("data/a.txt");
		long time = f.lastModified();
		
		Date d2 = new Date(time);
		System.out.println(d2);

		int year = d.getYear() + 1900;
		System.out.println(year);

		long currTime = d.getTime();
		d2.setTime(currTime);

		System.out.println(d);
		System.out.println(d2);
	}
}