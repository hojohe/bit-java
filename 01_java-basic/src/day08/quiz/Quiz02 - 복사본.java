package day08.quiz;

import java.io.File;
import java.util.Scanner;

class Movie {
	private String name;
	private String actor;
	private int year;
	private String makeCorp;
	
	public String setName() {
		return name;
	}
	
	public String setActor() {
		return actor;
	}
	
	public int setYear() {
		return year;
	}
	
	public String setMakeCorp() {
		return makeCorp;
	}
	
	public void getName(String name) {
		this.name = name;
	}	
	
	public void getActor(String actor) {
		this.actor = actor;
	}
	
	public void getYear(int year) {
		this.year = year;
	}
	
	public void getMakeCorp(String makeCorp) {
		this.makeCorp = makeCorp;
	}
	
	
	
	
	
	
}

public class Quiz02 {
	
	/* 전체 상영된 영화 4편 */
	public static void totalMovieCount() throws Exception {

		File f = new File("data/day08/quiz/quiz02.txt");
		Scanner sc = new Scanner(f);

		int totalCnt = 0;
		while (sc.hasNextLine()) {
			sc.nextLine();
			totalCnt++;
		}

		System.out.println("전체 상영된 영화 " + totalCnt + "편");

	}

	/* 제목이 2글자인 영화 2편 */
	public static void getMovieCountByNameLength(int len) throws Exception {

		File f = new File("data/day08/quiz/quiz02.txt");
		Scanner sc = new Scanner(f);

		int findCnt = 0;
		while (sc.hasNextLine()) {
			String[] tmp = sc.nextLine().split(":");
			if (tmp[0].length() == 2)
				findCnt++;
		}

		System.out.println("제목이 " + len + "글자인 영화 " + findCnt + "편");

	}
	
	/*
	 * 영화 상영 년도를 기준으로 카운트 조회
	 */
	public static void getMovieCountByYear(int len) throws Exception {

		File f = new File("data/day08/quiz/quiz02.txt");
		Scanner sc = new Scanner(f);

		int cnt = 0;
		while (sc.hasNextLine()) {
			String[] tmp = sc.nextLine().split(":");
			if (Integer.parseInt(tmp[2]) == len)	
				cnt++;
		}

		System.out.print("영화 상영 년도가 " + len + "년도인 영화는 " + cnt + "편");

	}

	public static void main(String[] args) throws Exception {
		
		// 전체 상영된 영화 카운트
		totalMovieCount();
		// 제목이 지정된 글자수와 같은 영화
		getMovieCountByNameLength(2);
		// 영화 상영 년도를 기준으로 카운트 조회
		getMovieCountByYear(2016);
		
	}

}
