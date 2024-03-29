package Ch34;

@C01Interface(value="HELLO WORLD",number=5)
class A{
	String value;
	int num;
	A(){
		C01Interface test =   this.getClass().getAnnotation(C01Interface.class);
		System.out.println("A() value : " + test.value());
		System.out.println("A() number : " + test.number());
		this.value =test.value();
		this.num = test.number();
	}
}

class B{
	String value;
	int num;
}

public class C01MAIN {
	
	public static void main(String[] args) {
		 A a = new A();
		 System.out.println(a.num + " | " + a.value);
	}

}
