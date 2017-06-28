public class SUV extends Cab {
	CabFactory cabFactory;
	public SUV(CabFactory cabFactory){
		this.cabFactory = cabFactory;
		this.setRate(6.00);
	}
	void makeCab(){
		//System.out.println("Making cab " + getName());
		seats = cabFactory.addSeats();
	}
}