public class Micro extends Cab {
	CabFactory cabFactory;
	public Micro(CabFactory cabFactory){
		this.cabFactory = cabFactory;
		this.setRate(5.00);
	}
	void makeCab(){
		//System.out.println("Making cab " + getName());
		seats = cabFactory.addSeats();
	}
}