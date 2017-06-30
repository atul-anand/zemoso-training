public abstract class Bread implements SubwaySub {
	protected SubwaySub subwich;
	public Bread(SubwaySub newSubwich){
		subwich = newSubwich;
	}
	public String getDescription(){
		return "\nBread: ";
	}
	public double getCost(){
		return subwich.getCost();
	}
}