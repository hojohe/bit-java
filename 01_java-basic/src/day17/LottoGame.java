package day17;

public class LottoGame {
	private int turnNo;
	LottoNum[] arrNum = new LottoNum[6];

	int pos = 0;
	
	
	public int getTurnNo() {
		return turnNo;
	}
	public void setTurnNo(int turnNo) {
		this.turnNo = turnNo;
	}
	
	
	LottoGame(int turnNo) {
		this.turnNo = turnNo;
	}
	
	public void addNum(LottoNum lottoNum) {
		if (pos > 5) {
			throw new RuntimeException("한게임에 6숫자만 입력가능해요");
		}
		lottoNum.upCount(); //한번 나왔으니 증가
		
		this.arrNum[pos++] = lottoNum;
	}
	
	public void print() {
		//게임정보 출력
		System.out.println(turnNo + " 회차 ." + arrNum[0].getNum() + " " + arrNum[1].getNum()
				+ " " + arrNum[2].getNum() + " " + arrNum[3].getNum() + " " + arrNum[4].getNum() + " " + arrNum[5].getNum());
	}
}
