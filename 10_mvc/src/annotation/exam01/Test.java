package annotation.exam01;

import javax.servlet.annotation.WebServlet;

@Marker
@WebServlet
public class Test {
	
	@Type1(value = "test")
	@Type2(name = "hello")
	public void call() {}
	
	
	// single value 형태의 어노테이션의 경우
	// 속성명이 value인 경우 생략이 가능함
	@Type1("test")
//	@Type2("hello") // 에러발생
	public void call2() {}
}
