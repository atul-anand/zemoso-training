public class Sedan extends Cab {
	CabFactory cabFactory;
	public Sedan(CabFactory cabFactory){
		this.cabFactory = cabFactory;
		this.setRate(8.00);
	}
	void makeCab(){
		//System.out.println("Making cab " + getName());
		seats = cabFactory.addSeats();
	}
}