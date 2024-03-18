package Ch16;

class Person{
	String name;
	String age;
	char gender;
	public Person(String name, String age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
}
class Man extends Person{
	public Man(String name, String age, char gender) {
		super(name, age, gender);
	}
	@Override
	public String toString() {
		return "Man [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
}
class Woman extends Person{
	public Woman(String name, String age, char gender) {
		super(name, age, gender);
	}
	@Override
	public String toString() {
		return "Woman [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
}

class Couple<X extends Person,Y  extends Person>{
	private X member1;
	private Y member2;
	Couple(X member1 , Y member2){
		this.member1 = member1; 
		this.member2 = member2;
	}
	void ShowInfo() {
		System.out.println("M1 : " + member1);
		System.out.println("M2 : " + member2);
	}
}
class Animal{
	String kind;
}
class Dog extends Animal{
	Dog(String kind){
		this.kind=kind;
	}

	@Override
	public String toString() {
		return "Dog [kind=" + kind + "]";
	}
}
class Cat extends Animal{
	Cat(String kind){
		this.kind=kind;
	}	
	@Override
	public String toString() {
		return "Cat [kind=" + kind + "]";
	}
}

public class C03GenericMain {

	public static void main(String[] args) {
		Couple<Man,Woman> couple1 = new Couple<Man,Woman>(new Man("철수","20",'M'), new Woman("영희","20",'W'));
		couple1.ShowInfo();
		System.out.println();
		Couple<Man,Man> couple2 = new Couple<Man,Man>(new Man("철수","20",'M'), new Man("길동","30",'M'));
		couple2.ShowInfo();
		System.out.println();
//		Couple<Man,Dog> couple3 = new Couple<Man,Dog>(new Man("길동2","20",'M'), new Dog("포메라니안"));
//		couple3.ShowInfo();
	}
}
