public class ChickenHam extends Salad {
	public ChickenHam(SubwaySub newSubwich){
		super(newSubwich);
		//System.out.println("Adding Chicken Ham");
	}
	public String getDescription(){
		return subwich.getDescription()+super.getDescription() + "Chicken Ham";
	}
	public double getCost()	{
		System.out.println("Cost of Chicken Ham: 8.00");
		return subwich.getCost()+8.00;
	}
}