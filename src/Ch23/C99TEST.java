package Ch23;


@FunctionalInterface
interface A{
	void method();
}

class B implements A{

	@Override
	public void method() {
		System.out.println("B TEST");
		
	}
	
}

public class C99TEST {
	public static void main(String[] args) {
		
		
		new A() {
			@Override
			public void method() {
				System.out.println("TEST");
			}
		}.method();
		
		
		new B(()->{}).method();;
		
	}
	
	
	

	
}
