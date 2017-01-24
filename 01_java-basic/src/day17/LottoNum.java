package day17;

public class LottoNum {

	private int num;
	private int count;

	LottoNum(int num) {
		this.num = num;
	}
	
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int upCount() {
		return count++;
	}

	public int getCount() {
		return this.count;
	}

}
