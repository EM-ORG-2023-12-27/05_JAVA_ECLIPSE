package Ch35;

public class Pistol extends Gun{

	
	Pistol(){
		this.power  = 5;
		this.bullitCnt=10;
	}
	@Override
	void fire(Unit unit) {
		// TODO Auto-generated method stub
		if(this.bullitCnt<=0) {
			System.out.println("탄약 부족..");
			return ;
		}
			
		System.out.println("Pistol fire...");
		unit.underAttack(this.power);

		this.bullitCnt--;
		
		
	}

	@Override
	void reload(int bullit) {
		// TODO Auto-generated method stub
		System.out.println("Pistol reload...");

	}

}
