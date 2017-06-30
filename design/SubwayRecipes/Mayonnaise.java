public class Mayonnaise extends Sauce {
	public Mayonnaise(SubwaySub newSubwich){
		super(newSubwich);
		//System.out.println("Adding Mayonnaise");
	}
	public String getDescription(){
		return subwich.getDescription() + super.getDescription() + "Mayonnaise";
	}
	public double getCost()	{
		System.out.println("Cost of Mayonnaise: 4.00");
		return subwich.getCost()+4.00;
	}
}