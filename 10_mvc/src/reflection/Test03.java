package reflection;

import java.lang.reflect.Method;

public class Test03 {
	public static void main(String[] args) {
		try {
//			exam01();
//			exam02();
			exam03();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void exam03() throws Exception {
		Class<?> clz = Dog.class;
		Object obj = clz.newInstance();
		
		Method m = clz.getDeclaredMethod("setAge", int.class);
		m.invoke(obj, 3);
		
		Method m2 = clz.getDeclaredMethod("getAge");
		Object value = m2.invoke(obj);
		
		System.out.println(value.toString());
		
		
	}

	/*private static void exam02() throws Exception {
		// 리플렉션을 이용한 메서드 실행
		Class<?> clz = Dog.class;
		
		Object obj = clz.newInstance();	//객체생성 또는 인스턴스 생성
		Method m = clz.getDeclaredMethod("setName", String.class);	// 메소드 정보만 있음
		
		// 실행 : invoke
		m.invoke(obj, "쫑");	// 따라서, 메소드 실행시키는데 객체가 필수로 와야하고 파라미터는 선택적으로 온다!!!
		
		// 설정된 이름 꺼내기
		Method m2 = clz.getDeclaredMethod("getName");
		String value =  (String)m2.invoke(obj);
		System.out.println(value);
	}

	private static void exam01() throws Exception {
		// 리플렉션을 이용한 객체 생성
//		Dog d = new Dog();
		
		Class<?> clz = Dog.class;
		Object obj = clz.newInstance();
		Dog d = (Dog)obj;
		d.setName("쫑");
		System.out.println(d.getName());
		
	}*/
	
	
}
