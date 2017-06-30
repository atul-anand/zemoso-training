public class Veggies extends Addon {
	public Veggies(SubwaySub newSubwich){
		super(newSubwich);
		//System.out.println("Adding Veggies");
	}
	public String getDescription(){
		return subwich.getDescription() + super.getDescription() + "Veggies";
	}
	public double getCost()	{
		System.out.println("Cost of Veggies: 3.00");
		return subwich.getCost()+3.00;
	}
}