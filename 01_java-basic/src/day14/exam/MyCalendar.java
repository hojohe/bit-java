package day14.exam;

import java.util.Calendar;

public class MyCalendar {

	Calendar c = Calendar.getInstance();

	void execute() {

		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;

		System.out.println("\t\t     " + year + "년 " + month + "월" + "\t\t");
		System.out.printf("%2s\t%2s\t%2s\t%2s\t%2s\t%2s\t%2s\n", "일", "월", "화", "수", "목", "금", "토");

		int date = 1;
		int nextDate = 1;
		int prevDate = 1;
		for (int i = 0; i < 6; i++) {

			c.set(Calendar.DATE, date);
			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

			for (int j = dayOfWeek; j <= 7; j++) {

				if (date > c.getActualMaximum(Calendar.DAY_OF_MONTH)) {

					System.out.printf("%2d\t", nextDate);
					nextDate++;

				} else {

					if (date == 1) {
						
						c.add(Calendar.MONTH, -1);
						prevDate = c.getActualMaximum(Calendar.DAY_OF_MONTH);
						prevDate = prevDate - c.get(Calendar.DAY_OF_WEEK);

						for (int k = 1; k < dayOfWeek; k++) {
							System.out.printf("%2d\t", prevDate);
							prevDate++;
						}

						c.set(Calendar.MONTH, (month - 1));
					}

					System.out.printf("%2d\t", date);
					date++;

				}

			}

			System.out.println();

		}
	}
}
