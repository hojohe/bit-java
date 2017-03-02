package OBcomponentScan;

import org.springframework.stereotype.Component;

@Component
public class EggSand implements ISand {
	public EggSand() {
		System.out.println("계란 샌드위치 생성자 호출");
	}
	
	public void info() {
		System.out.println("계란 샌드위치 입니다.");
	}
}
