public abstract class Salad implements SubwaySub {
	protected SubwaySub subwich;
	public Salad(SubwaySub newSubwich){
		subwich = newSubwich;
	}
	public String getDescription(){
		return "\nSalad: ";
	}
	public double getCost(){
		return subwich.getCost();
	}
}