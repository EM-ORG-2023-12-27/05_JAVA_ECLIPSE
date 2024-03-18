package Ch16;

class C04Animal{
	
}

class Tiger extends C04Animal{
	String name;
	//생성자
	public Tiger(String name) {
		super();
		this.name = name;
	}
	//toString
	@Override
	public String toString() {
		return "Tiger [name=" + name + "]";
	}
}
class Panda extends C04Animal{
	String name;
	//생성자
	public Panda(String name) {
		super();
		this.name = name;
	}
	//toString
	@Override
	public String toString() {
		return "Panda [name=" + name + "]";
	}
}

public class C04GenericMain {
	
	// Generic
	public static <T extends C04Animal> void PrintInfo(T[] arr) {
		for(T el : arr)
			System.out.println(el);
	}
	// Object
	public static void PrintInfo2(Object[] arr) {
		for(Object el : arr) {
			System.out.println(el);
			if(el instanceof Tiger) {
				Tiger down =(Tiger)el;			
			}
		}
	}
	
	public static void main(String[] args) {
		Tiger[] arr = {new Tiger("시베리안호랑이"),new Tiger("호랭이"),new Tiger("호호호")};
		//PrintInfo(arr);
		Panda[] arr2 = {new Panda("중국팬더"),new Panda("래서팬더")};
		//PrintInfo(arr2);
		Object [] arr3 = {new Tiger("호랭랭"),new Panda("팬더다")};
		//PrintInfo(arr3);
		PrintInfo2(arr3);
	}
}
