public class SubwayClub extends Salad {
	public SubwayClub(SubwaySub newSubwich){
		super(newSubwich);
		//System.out.println("Adding Subway Club");
	}
	public String getDescription(){
		return subwich.getDescription()+super.getDescription() + "Subway Club";
	}
	public double getCost()	{
		System.out.println("Cost of Subway Club: 9.00");
		return subwich.getCost()+9.00;
	}
}