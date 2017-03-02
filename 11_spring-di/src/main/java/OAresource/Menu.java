package OAresource;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

public class Menu {

	public Menu() {
		System.out.println("Menu 샌드위치 객체 생성자 호출");
	}
	
//	@Resource(name="egg")
	@Resource
	@Qualifier("hamham")
	private ISand sand;
	
	public void print() {
		sand.info();
	}
}









