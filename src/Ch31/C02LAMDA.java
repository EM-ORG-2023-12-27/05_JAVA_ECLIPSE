package Ch31;


interface Printer{
	void print(String message);
}
class A implements Printer{

	@Override
	public void print(String message) {
		// TODO Auto-generated method stub
		
	}
	
}
public class C02LAMDA {

	public static void main(String[] args) {
		
		Printer printer =(message)->{System.out.println(message);};
		
		printer.print("HELLO WORLD");
		
	}
}
