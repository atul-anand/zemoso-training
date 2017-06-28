public class MiniFactory implements CabFactory {
	public Seats addSeats(){
		return new MiniSeats();
	}
}