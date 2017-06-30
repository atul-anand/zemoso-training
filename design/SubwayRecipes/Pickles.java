public class Pickles extends Addon {
	public Pickles(SubwaySub newSubwich){
		super(newSubwich);
		//System.out.println("Adding Pickles");
	}
	public String getDescription(){
		return subwich.getDescription() + super.getDescription() + "Pickles";
	}
	public double getCost()	{
		System.out.println("Cost of Pickles: 3.00");
		return subwich.getCost()+3.00;
	}
}