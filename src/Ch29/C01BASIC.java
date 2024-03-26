package Ch29;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class TEST{
	String name;
	String addr;
	int age;
	public TEST(){}
	public TEST(String name){this.name = name;}
	public TEST(String name,String addr){this.name=name;this.addr=addr;}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getAge() {
		System.out.println("GETAGE FUNC..");
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "TEST [name=" + name + ", addr=" + addr + ", age=" + age + "]";
	}
	
	//getter and setter
	//toString
	
}




public class C01BASIC {
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
			
		Class<?>clazz =  Class.forName(String.valueOf(TEST.class).split(" ")[1]);
		Method method = clazz.getDeclaredMethod("getAge",null);
		
		System.out.println("method : " + method);
		Object result = 	method.invoke(new TEST(),null);
		
		Constructor<?> constructor =   clazz.getConstructor(String.class);
		System.out.println("생성자 : " + constructor);
		
		Object obj =  constructor.newInstance("홍길동");
		
		System.out.println("INSTNCE : " + obj);
			
		Field field = clazz.getDeclaredField("addr");
		TEST ob = new TEST();
		field.set(ob,"대구");
		System.out.println(ob);
	
		
	}
	
}

















