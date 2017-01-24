package day14;

import java.util.Calendar;

public class Test02 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println(c);

		// int year = c.get(1);
		int year = c.get(Calendar.YEAR);
		// int month = c.get(2) + 1;
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);
		
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		String[] dayWords = {"일", "월", "화", "수", "목", "금", "토"};
		
		/*
		 * String str = "";
		if(dayOfWeek == 1) {
			str = "일";
		}else if(dayOfWeek == 2) {
			str = "월";
		}else if(dayOfWeek == 3) {
			str = "화";
		}else if(dayOfWeek == 4) {
			str = "수";
		}else if(dayOfWeek == 5) {
			str = "목";
		}else if(dayOfWeek == 6) {
			str = "금";
		}else if(dayOfWeek == 7) {
			str = "토";
		}*/
		
		System.out.println("오늘은 " + dayWords[dayOfWeek - 1] + "요일 입니다. ");

		System.out.println(year);
		System.out.println(month);
		System.out.println(date);
		System.out.println(c.get(Calendar.HOUR));
		System.out.println(c.get(Calendar.MINUTE));
		System.out.println(c.get(Calendar.SECOND));

	}
}
