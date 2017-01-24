package day14.exam;

import java.util.Calendar;

public class CalendarExam {
	
	Calendar c;
	
	public CalendarExam() {
		 c = Calendar.getInstance();
	}
	
	
	public void executeYyyy(int yyyy) {
	
		// 입력받은 년도 1월 1일로 셋팅
		c.set(yyyy, 0, 1);
		
		
		for(int k = 0; k < 12; k++) {
			c.set(yyyy, k, 1);
			System.out.println("-------------------------------------------------------");
			System.out.println("일\t월\t화\t수\t목\t금\t토\t");
			System.out.println("-------------------------------------------------------");
			int date = 1;
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 7; j++) {
					
					if (date > c.getActualMaximum(Calendar.DAY_OF_MONTH)) {
						System.out.print("");
					} else {
					
						if(date == 1) {
							for(int z = 1; z < c.get(Calendar.DAY_OF_WEEK) - 1; z++) {
								System.out.print("\t");
							}
						}
						System.out.print(date + "\t");
						date++;
					}
					
				}
				System.out.println();
			}
			System.out.println("-------------------------------------------------------");
		}
		
	}
	
	
	public void executeYyyyMm() {
		
	}
	
}
