public class PaneerTikka extends Salad {
	public PaneerTikka(SubwaySub newSubwich){
		super(newSubwich);
		//System.out.println("Adding Paneer Tikka");
	}
	public String getDescription(){
		return subwich.getDescription()+ super.getDescription() + "Paneer Tikka";
	}
	public double getCost()	{
		System.out.println("Cost of Paneer Tikka: 6.00");
		return subwich.getCost()+6.00;
	}
}