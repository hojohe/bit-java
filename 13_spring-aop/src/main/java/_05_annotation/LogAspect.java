package _05_annotation;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogAspect {
	
	@Before("execution(public * _05_annotation.*Controller.execute(..))")// Controller로 끝나는 클래스들만 
	public void showLog(JoinPoint point) {

		// 핵심기능 클래스
		Object target = point.getTarget();
		Class<?> clz = target.getClass();
		
		// 핵심기능 클래스의 메서드 ( 어떠한 메서드가 수행됐는지 수행한 메서드만 뽑아옴 )
		Signature sign = point.getSignature();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println("-------------------------------");
		System.out.println("클래스명 : " + clz.getName());
		System.out.println("메서드명 : " + sign.getName());
		System.out.println("호출 시간 : " + sdf.format(new Date()));
		System.out.println("-------------------------------");
		
		
	}
}
