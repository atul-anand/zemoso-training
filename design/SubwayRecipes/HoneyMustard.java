public class HoneyMustard extends Sauce {
	public HoneyMustard(SubwaySub newSubwich){
		super(newSubwich);
		//System.out.println("Adding Honey Mustard");
	}
	public String getDescription(){
		return subwich.getDescription() + super.getDescription() + "Honey Mustard";
	}
	public double getCost()	{
		System.out.println("Cost of Honey Mustard: 4.00");
		return subwich.getCost()+4.00;
	}
}