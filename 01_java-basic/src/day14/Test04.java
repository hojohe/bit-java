package day14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test04 {
	public static void main(String[] args) {
		
		Date d = new Date();
		
		/*
		 * 패턴문자
		 * y : 년도
		 * M : 월
		 * d : 일
		 * h : (12시간) H : (24시간)
		 * m : 분
		 * s : 초
		 * 2016-11-11  :  yyyy-MM-dd
		 * 11:50:23    :  hh:mm:ss
		 * 2016-11     :  yyyy-MM
		 * */
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// format : 날짜정보에서 문자열을 얻기
		String timeStr = sdf.format(d);
		System.out.println(timeStr);
		
		// parse  : 문자열에서 날짜 객체 얻기
		try {
			Date date = sdf.parse("2015-01-01");
			Date date2 = sdf.parse(timeStr);
			System.out.println("변경된 날짜 정보 : " + date);
			System.out.println("변경된 날짜 정보 : " + date2);
		} catch (ParseException pe) {
			System.out.println("날짜 파싱중 오류 발생...");
			pe.printStackTrace();
		}
		
	}
}