package Ch29;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class C02BASIC {

	
	public static void main(String[] args) throws Exception {
	
		Class<?> clazz = Class.forName("java.lang.String");
			
		Field[] fields = clazz.getDeclaredFields();
		
		for(Field field : fields) {
			System.out.println(field);
		}
		System.out.println("===========================================");
		
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method : methods) {
			System.out.println(method);
		}
		
		System.out.println("===========================================");
		Constructor[] constructors = clazz.getDeclaredConstructors();
		for(Constructor constructor : constructors) {
			System.out.println(constructor);
		}
		
	}
}
