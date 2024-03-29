package Ch35;

public class Marine extends Unit{

	String name;
	Gun gun;
	

	Marine(){}
	Marine(String name){this.name = name;}
	Marine(String name,Gun gun){
		this.name = name;
		this.gun = gun;
		this.hp = 100;
	}
	void attack(Unit unit) {
		gun.fire(unit);
		
	}
	
	@Override
	void move() {
		System.out.println("Marine Move...");
	}
	@Override
	void underAttack(int damage) {
		System.out.println("Marine UnderAttack...");
	
		if(this.hp-damage<0)
			System.out.println("Marine Dead..");
		else
			this.hp-=damage;	
	}
	@Override
	public String toString() {
		return "Marine [name=" + name + ", gun=" + gun + ", hp=" + hp + ", amor=" + amor + ", type=" + type + "]";
	}

	
	
	
}
