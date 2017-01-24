package day10.exam;

public class TV {
	private int volume;
	private int channel;

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	TV(int i, int j) {
		volume = 9;
		channel = 11;
	}

	void channelUp() {
		channel++;
	}

	void powerOn() {
		System.out.println("티비 전원을 켭니다.");
	}

	void powerOff() {
		System.out.println("티비 전원을 끕니다.");
	}

}
