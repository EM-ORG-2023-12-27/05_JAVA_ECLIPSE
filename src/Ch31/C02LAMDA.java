package Ch31;


interface Printer{
	//void print(String message); 	//01
	//String print(String message); //02
	//String print();				//03

}

public class C02LAMDA {

	public static void main(String[] args) {
		
		//01
		//Printer printer =(message)->{System.out.println(message);};
		
		//02 리턴형 ()->{} 구조시에 {}안에 return 예약어를 사용
//		Printer printer =(message)->{
//			System.out.println(message);
//			return message;
//		};
		//printer.print("HELLO WORLD");
		
		//02 리턴형 ()->  구조사용시 return 예약어 생략가능 
//		Printer printer2 = (message)->message+"!";
//		String str = printer2.print("HELLOWORLD");
//		System.out.println(str);
		
		//03
//		Printer printer = ()->"HELLOWORLD";
//		String str =  printer.print();
//		System.out.println(str);
		
	
	
	}
}
