package day15.quiz;

public class Data implements Comparable<Data> {
	
	private int num;
	
	public Data(int num) {
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}
	
	public String toString() {
		return String.valueOf(num);
	}

	
	// 음수값을 리턴해주면 비교대상보다 앞으로 이동
	// 양수값을 리턴해주면 비교대상보다 뒤로 이동
	// 0이면 자리이동 없음
	@Override
	public int compareTo(Data o) {
		if(this.num == o.getNum()) return 0;
		return this.num < o.getNum() ? -1 : 1;
	}
	
}
