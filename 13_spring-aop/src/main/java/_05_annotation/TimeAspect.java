package _05_annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
	
	@Around("execution(public * _05_annotation.Controller+.execute(..))")
	// around advice 일 경우
	public void executeTime(ProceedingJoinPoint pjp) throws Throwable {
		long s = System.currentTimeMillis();
		try {
			System.out.println("실행 전");
			// after-returning
			// 핵심기능 메서드 호출
			pjp.proceed(); 
		} catch (Throwable t) {
			// after-throwing
			// 이 부분이 로그 쌓기 
		} finally {
			// after
			System.out.println("실행 후");
			long e = System.currentTimeMillis();
			System.out.println("실행 시간" + (double)( e - s ) / 1000d );
		}
		
	}
}
