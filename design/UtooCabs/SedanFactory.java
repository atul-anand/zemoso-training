public class SedanFactory implements CabFactory {
	public Seats addSeats(){
		return new SedanSeats();
	}
}