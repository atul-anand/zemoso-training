public abstract class CityBuilder{
	protected abstract City populateCabs(String name);
	public City launchCity(String name){
		return populateCabs(name);
	}
}