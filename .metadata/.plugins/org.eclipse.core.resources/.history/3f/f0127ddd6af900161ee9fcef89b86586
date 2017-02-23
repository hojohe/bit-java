package O4container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("container/test.xml");
		ISand sand = (ISand)container.getBean("ham2");
		sand.info();
	}
}
