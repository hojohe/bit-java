package day10.exam;

public class Bus {
	private int busNo;
	private int rideCnt;
	private int leaveCnt;
	private int realTimeCnt;
	private static int totCnt;

	Bus(int busNo) {
		this.busNo = busNo;
		System.out.println(busNo + "번 버스 운행시작.");
	}

	void ride() {
		this.ride(1);
	}

	void ride(int num) {
		realTimeCnt += num;
		rideCnt += num;
		System.out.println("승객 " + num + "명 승차.");
	}

	void leave() {
		this.leave(1);
	}

	void leave(int num) {
		realTimeCnt -= num;
		leaveCnt += num;
		System.out.println("승객 " + num + "명 하차.");
	}

	public String toString() {
		totCnt += ((rideCnt + leaveCnt) - leaveCnt);
		String result = busNo + "번 버스의 현재 승차인원 : " + realTimeCnt + "명. \n모든 버스의 누적 승차인원 : " + totCnt + "명.";
		return result;
	}

}
