import java.util.*;
public class Patient extends Person{
	private static int counter = 0;
	private final int id = counter++;
	private Person person;
	private Condition condition;
	public Patient(Person person, Condition condition){
		super(person);
		this.condition = condition;
	}
	public int getID(){ return id; }
	public Condition getCondition() { return condition; }
	public void setCondition(Condition condition) { this.condition = condition; }
	public String toString() { return "id: " + getID() + " " + super.toString() + ",Condition:"+ getCondition(); }
}