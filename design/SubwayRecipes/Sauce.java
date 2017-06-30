public abstract class Sauce implements SubwaySub {
	protected SubwaySub subwich;
	public Sauce(SubwaySub newSubwich){
		subwich = newSubwich;
	}
	public String getDescription(){
		return "\nSauce: ";
	}
	public double getCost(){
		return subwich.getCost();
	}
}