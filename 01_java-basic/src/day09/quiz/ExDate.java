package day09.quiz;


public class ExDate {
	
	private int yyyy;
	private int mm;
	private int dd;
	
	ExDate() {
		this(2013, 4, 1);
	/*	this.yyyy = 2013;
		this.mm = 4;
		this.dd = 01;*/
	}
	
	ExDate(int yyyy, int mm, int dd) {
		this.yyyy = yyyy;
		this.mm = mm;
		this.dd = dd;
	}
	
	public void showDate() {
		//System.out.println(yyyy+"년 " + mm + "월 " + dd + "일");
		System.out.printf("%4d년 %2d월 %02d일 \n", yyyy, mm, dd);
	}
}
