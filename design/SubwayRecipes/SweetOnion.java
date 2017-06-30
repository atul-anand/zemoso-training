public class SweetOnion extends Sauce {
	public SweetOnion(SubwaySub newSubwich){
		super(newSubwich);
		//System.out.println("Adding Sweet Onion");
	}
	public String getDescription(){
		return subwich.getDescription() + super.getDescription() + "Sweet Onion";
	}
	public double getCost()	{
		System.out.println("Cost of Sweet Onion: 4.00");
		return subwich.getCost()+4.00;
	}
}