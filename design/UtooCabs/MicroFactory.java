public class MicroFactory implements CabFactory {
	public Seats addSeats(){
		return new MicroSeats();
	}
}