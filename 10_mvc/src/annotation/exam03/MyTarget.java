package annotation.exam03;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value={ElementType.PARAMETER, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface MyTarget {
	
}
