import java.util.*;
public class Patient extends Person{
	private static int counter = 0;
	private final int id = counter++;
	private Person person;
	private Condition condition;
	private Set<Timing> timings;
	public Patient(Person person, Condition condition){
		super(person);
		this.condition = condition;
		timings = new TreeSet<Timing>(new TimingComparator());
	}
	public int getID(){ return id; }
	public Condition getCondition() { return condition; }
	public void setCondition(Condition condition) { this.condition = condition; }
	public void addTiming(Timing timing) { timings.add(timing); }
	public Set<Timing> getTimings() { return timings; }
	public String toString() { return "id: " + getID() + " " + super.toString() + ",Condition:"+ getCondition(); }
}