public class Patient extends Person{
	private static int counter = 0;
	private final int id = counter++;
	private Person person;
	private String condition;
	public Patient(Person person, String condition){
		super(person);
		this.condition = condition;
	}
	public int getID(){ return id; }
	public String getCondition() { return condition; }
	public void setCondition(String condition) { this.condition = condition; }
	public String toString() { return "id: " + getID() + " " + super.toString() + ",Condition:"+ getCondition(); }
}