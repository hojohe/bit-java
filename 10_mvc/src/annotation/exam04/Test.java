package annotation.exam04;

import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) {
		Class<?> clz = AnnoApply.class;
		ClassAnno cAnno = clz.getAnnotation(ClassAnno.class);
		RunAnno1 rAnno1 = clz.getAnnotation(RunAnno1.class);
		
		// RetentionPolicy 속성의 값이 RUNTIME인 경우는 참조 되어있고, 
		// CLASS나 SOURCE라면 참조가 되지 않아 NULL 
		System.out.println(cAnno);
		System.out.println(rAnno1);
		System.out.println(rAnno1.value());
		
		Method[] mArr = clz.getDeclaredMethods();
		for(Method m: mArr) {
			RunAnno2 anno = m.getAnnotation(RunAnno2.class);
			if(anno == null) continue;
			
			System.out.println("메서드명 : " + m.getName());
			System.out.println("ID : " + anno.id());
			System.out.println("MSG : " + anno.msg());
		}
	}
}
