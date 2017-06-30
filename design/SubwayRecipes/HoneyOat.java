public class HoneyOat extends Bread {
	public HoneyOat(SubwaySub newSubwich){
		super(newSubwich);
		//System.out.println("Adding Honey Oat");
	}
	public String getDescription(){
		return subwich.getDescription()+super.getDescription() + "Honey Oat";
	}
	public double getCost()	{
		System.out.println("Cost of Honey Oat: 4.00");
		return subwich.getCost()+4.00;
	}
}