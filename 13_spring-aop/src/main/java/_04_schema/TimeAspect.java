package _04_schema;

import org.aspectj.lang.ProceedingJoinPoint;

public class TimeAspect {
	
	// around advice
	public void executeTime(ProceedingJoinPoint pjp) throws Throwable {
		long s = System.currentTimeMillis();
		try {
			System.out.println("들어옴..");
			// after-returning
			pjp.proceed(); 
		} catch (Throwable t) {
			// after-throwing
		} finally {
			// after
			System.out.println("들어옴..");
			long e = System.currentTimeMillis();
			System.out.println("" + (double)( e - s ) / 1000d );
		}
		
	}
}
