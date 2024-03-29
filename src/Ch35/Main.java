package Ch35;

public class Main {
	
	public static void main(String[] args) {
	
		Marine m1 = new Marine("m1",new Pistol());
		Marine m2 = new Marine("m2",new Rifle());
		
		m1.attack(m2);
		m1.attack(m2);
		
		m2.attack(m1);
		m2.attack(m1);

		System.out.println(m1);
		System.out.println(m2);
		
	}
	
}
