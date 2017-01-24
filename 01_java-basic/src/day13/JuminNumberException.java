package day13;

public class JuminNumberException extends Exception {
	
	public JuminNumberException () {
		super("잘못된 주민번호 형식입니다");
	}
	public JuminNumberException (String errMsg) {
		super(errMsg);
	}
	
}
