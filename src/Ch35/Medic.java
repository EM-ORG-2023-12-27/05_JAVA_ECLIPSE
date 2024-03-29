package Ch35;

public class Medic extends Unit{

	@Override
	void move() {
		System.out.println("Medic Move...");
	}

	@Override
	void underAttack(int damage) {
		System.out.println("Medic UnderAttack...");
	
		if(this.hp-damage<0)
			System.out.println("Medic Dead..");
		else
			this.hp-=damage;
		
	}

}
