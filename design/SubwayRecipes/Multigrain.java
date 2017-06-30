public class Multigrain extends Bread {
	public Multigrain(SubwaySub newSubwich){
		super(newSubwich);
		//System.out.println("Adding Multigrain");
	}
	public String getDescription(){
		return subwich.getDescription()+ super.getDescription() + "Multigrain";
	}
	public double getCost()	{
		System.out.println("Cost of Multigrain: 6.00");
		return subwich.getCost()+6.00;
	}
}