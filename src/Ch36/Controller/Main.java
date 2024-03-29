package Ch36.Controller;

public class Main {

	
	public static void main(String[] args) {
		
		FrontController frontController =  new FrontController();
		frontController.execute("/book", 0, null);
		System.out.println();
		frontController.execute("/member", 0, null);
		
		
		
	}
	
	
}
