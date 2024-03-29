package Ch35;


public abstract class Gun {
	int bullitCnt;
	int power;
	
	abstract void fire(Unit unit);
	abstract void reload(int bullit);
	
}
