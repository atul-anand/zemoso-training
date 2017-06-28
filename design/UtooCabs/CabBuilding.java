public class CabBuilding extends CabBuilder {
	protected Cab makeCab(String typeOfShip, String name){
		Cab newCab = null;
		if(typeOfShip.equals("SUV"))
			newCab = new SUV(new SUVFactory());
		else if(typeOfShip.equals("Sedan"))
			newCab = new Sedan(new SedanFactory());
		else if(typeOfShip.equals("Micro"))
			newCab = new Micro(new MicroFactory());
		else if(typeOfShip.equals("Mini"))
			newCab = new Mini(new MiniFactory());
		newCab.setType(typeOfShip);
		newCab.setName(name);
		return newCab;
	}
}