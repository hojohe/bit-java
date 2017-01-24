package day07.exam;

public class TV {

	private int volume = 20;
	private int channel = 7;
	
	
	public int getVolume() {
		return volume;
	}

	public void setChannel(int channel){
		this.channel = channel;
	}
	
	public int getChannel() {
		return channel;
	}
	
	void powerOn() {
		System.out.println("티비 전원을 켭니다.");
	}
	void powerOff() {
		System.out.println("티비 전원을 끕니다.");
	}
	
	void channelUp() {
		channel++;
	}
	
}
