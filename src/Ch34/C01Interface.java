package Ch34;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)		// 애노테이션의 유지시간
										//RetentionPolicy.SOURCE : 컴파일시에만 동작
@Target({ElementType.TYPE,ElementType.METHOD} )	//애너테이션 적용대상을 메소드로 지정
public @interface C01Interface	//애노테이션용 인터페이스 
{
	String value() default "";
	int number() default 0 ;
}
