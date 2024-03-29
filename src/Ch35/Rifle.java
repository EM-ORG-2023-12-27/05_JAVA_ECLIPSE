package Ch35;

public class Rifle extends Gun{

	
	Rifle(){
		this.power = 5;
		this.bullitCnt=20;
	}
	@Override
	void fire(Unit unit) {
		// TODO Auto-generated method stub
		if(this.bullitCnt<=0) {
			System.out.println("탄약 부족..");
			return ;
		}
			
		System.out.println("Rifle fire...");
		unit.underAttack(this.power*2);

		this.bullitCnt+=2;
		
	}

	@Override
	void reload(int bullit) {
		System.out.println("Rifle reload...");
	}

}
