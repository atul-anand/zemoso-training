public class Cheese extends Addon {
	public Cheese(SubwaySub newSubwich){
		super(newSubwich);
		//System.out.println("Adding Cheese");
	}
	public String getDescription(){
		return subwich.getDescription() + super.getDescription() + "Cheese";
	}
	public double getCost()	{
		System.out.println("Cost of Cheese: 3.00");
		return subwich.getCost()+3.00;
	}
}