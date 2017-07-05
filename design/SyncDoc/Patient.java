import java.util.*;
public class Patient extends Person{
	private Condition condition;
	public Patient(Person person, Condition condition){
		super(person);
		this.condition = condition;
	}
	public Condition getCondition() { return condition; }
	public void setCondition(Condition condition) { this.condition = condition; }
	public String toString() { return 	super.toString() + ", Condition: "+ getCondition(); }
}