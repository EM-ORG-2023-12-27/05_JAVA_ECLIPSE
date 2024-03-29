package Ch35;


interface UnitFactory{
	
	Unit createUnit();
}
class MarineFactory implements UnitFactory{

	@Override
	public Unit createUnit() {
		return new Marine();
	}
}
class MedicFactory implements UnitFactory{
	@Override
	public Unit createUnit() {
		return new Medic();
	}	
}

public class Barrack extends Building{
	
	private MarineFactory marineFactory;
	private MedicFactory medicFactory;
	
	Barrack(){
		marineFactory = new MarineFactory();
		medicFactory = new MedicFactory();
	}
	
	public Unit getMarine() {
		return marineFactory.createUnit();
	}
	public Unit getMedic() {
		return medicFactory.createUnit();
	}

	@Override
	void BuildStructure() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void UnderAttack(Unit unit) {
		// TODO Auto-generated method stub
		
	}
	
}





