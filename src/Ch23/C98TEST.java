package Ch23;




@FunctionalInterface
interface Func{
	void say(String message);
}

class ABC{

	ABC(Func func){
		
		func.say("HELLO");
	}
	

	void test() {
		System.out.println("AAADFWe");
	}
	
}
public class C98TEST {
	
	
	
	public static void main(String[] args) {
		
//		//BASIC_01
//		Func test1 = (message)->{System.out.println(message) ;};
//		test1.say("hello world");
////		
//		
//		
//		
//		new ABC((mssage)->{});
//		
//		new Func() {
//
//			@Override
//			public void say(String message) {
//				System.out.println("TEST");
//				
//			}}.say("hello world");
//			

			
			
		new ABC((message)->{System.out.println(message);}).test();
		
		
	}
}
