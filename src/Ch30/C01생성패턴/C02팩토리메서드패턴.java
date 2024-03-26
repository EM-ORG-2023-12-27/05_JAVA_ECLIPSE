package Ch30.C01생성패턴;


//팩토리메서드 패턴
//- 객체생성은 서브클래스에서 하도록 

abstract class Animal {
    public abstract void sound();
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("야옹");
    }
}

//팩토리 Interface,상속관계의 모든 Factoray객체를 받음 
interface AnimalFactory 
{
    Animal createAnimal();	//추상메서드
}

class DogFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}



public class C02팩토리메서드패턴 {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.createAnimal();
        dog.sound(); // 멍멍

        AnimalFactory catFactory = new CatFactory();
        Animal cat = catFactory.createAnimal();
        cat.sound(); // 야옹
    }
}


