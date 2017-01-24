package day16.quiz;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Quiz01 {
	public static void main(String[] args) {
		// 프로그램 실행시 현재 날짜 정보를 기준으로 디렉토리 생성
		// 출력결과
		/*
		 * data/2016/12/26/09 폴더가 생성된다.
		 */

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd/hh");
		String str = "data/" + sdf.format(new Date());

		/*
		 * Calendar c = Calendar.getInstance();
		 * System.out.println(c.get(Calendar.YEAR));
		 * System.out.println(c.get(Calendar.MONTH) + 1);
		 * System.out.println(c.get(Calendar.DATE));
		 * System.out.println(c.get(Calendar.HOUR));
		 * 
		 * String str = "data/" + String.valueOf(c.get(Calendar.YEAR)) + "/" +
		 * String.valueOf(c.get(Calendar.MONTH) + 1) + "/"
		 * +String.valueOf(c.get(Calendar.DATE)) + "/" +
		 * String.valueOf(c.get(Calendar.HOUR));
		 */

		File f = new File(str);

		if (f.exists()) {
			System.out.println("존재하는 디렉토리임");
		} else {
			if (f.mkdirs()) {
				System.out.println("디렉토리 생성 성공");
			} else {
				System.out.println("디렉토리 생성 실패");
			}
		}

	}
}
