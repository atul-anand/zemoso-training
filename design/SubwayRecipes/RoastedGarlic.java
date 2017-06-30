public class RoastedGarlic extends Bread {
	public RoastedGarlic(SubwaySub newSubwich){
		super(newSubwich);
		//System.out.println("Adding Roasted Garlic");
	}
	public String getDescription(){
		return subwich.getDescription() + super.getDescription() + "Roasted Garlic";
	}
	public double getCost()	{
		System.out.println("Cost of Roasted Garlic: 5.00");
		return subwich.getCost()+5.00;
	}
}