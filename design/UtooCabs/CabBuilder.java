public abstract class CabBuilder{
	protected abstract Cab makeCab(String typeOfCab, String name);
	public Cab orderCab(String typeOfCab, String name){
		Cab newCab = makeCab(typeOfCab,name);
		newCab.makeCab();
		return newCab;
	}
}