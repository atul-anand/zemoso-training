public class Mini extends Cab {
	CabFactory cabFactory;
	public Mini(CabFactory cabFactory){
		this.cabFactory = cabFactory;
		this.setRate(4.00);
	}
	void makeCab(){
		//System.out.println("Making cab " + getName());
		seats = cabFactory.addSeats();
	}
}