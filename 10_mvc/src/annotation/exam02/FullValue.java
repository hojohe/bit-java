package annotation.exam02;

public @interface FullValue {
	String type() default "type";
	String name() default "name";
	String value() default "value";
}
