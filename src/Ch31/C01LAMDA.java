package Ch31;

import java.util.ArrayList;
import java.util.List;

class Person{
	private String name;
	private int age;
	public Person() {}
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}

public class C01LAMDA {
	public static void main(String[] args) {
		//리스트
		List<Person> list = new ArrayList();
		list.add(new Person("Jone",25));
		list.add(new Person("Alice",30));
		list.add(new Person("Bob",20));
		
		//sort 스트림함수를 이용해서 나이순으로 정렬
		list.sort((person1,person2)->{return person1.getAge()-person2.getAge();});
		
		for(Person person : list)
			System.out.println(person);
		
		
	}
}










