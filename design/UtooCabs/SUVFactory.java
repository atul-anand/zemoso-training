public class SUVFactory implements CabFactory {
	public Seats addSeats(){
		return new SUVSeats();
	}
}