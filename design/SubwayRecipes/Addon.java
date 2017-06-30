public abstract class Addon implements SubwaySub {
	protected SubwaySub subwich;
	public Addon(SubwaySub newSubwich){
		subwich = newSubwich;
	}
	public String getDescription(){
		return "\nAddons: ";
	}
	public double getCost(){
		return subwich.getCost();
	}
}