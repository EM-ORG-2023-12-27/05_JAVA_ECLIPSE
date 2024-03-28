package Ch33;

import java.util.function.Consumer;

public class C99TEST {

	
	interface CustomPrinter<T>  {
		void printer(T message);
	}
	
	
	public static void main(String[] args) {
		
		CustomPrinter<Object> printer = String::new;

	}
}
