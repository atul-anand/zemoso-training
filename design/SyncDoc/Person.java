import java.util.*;
import java.time.*;
public class Person {
	private static int counter = 0;
	private final int id = counter++;
	private String firstName;
	private String lastName;
	private Character gender;
	private Calendar dob;
	private String contact;
	public Person(){
		firstName = "Mark";
		lastName = "Anthony";
		gender = 'M';
		dob = (Calendar)Calendar.getInstance().clone();
		contact = "9876543210";
	}
	public Person(String firstName, String lastName, char gender, String dob, String contact){
		setFirstName(firstName);
		setLastName(lastName);
		setGender(gender);
		setDOB(dob);
		setContact(contact);
	}
	public Person(Person person){
		setFirstName(person.getFirstName());
		setLastName(person.getLastName());
		setGender(person.getGender());
		setDOB(person.getDOB());
		setContact(person.getContact());
	}
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getFullName() { return lastName + ", " + firstName; }
	public Character getGender() { return gender; }
	public Calendar getDOB() { return dob; }
	public String getContact() { return contact; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public void setGender(char ch) { 
		if(ch=='M'||ch=='F')
			this.gender = new Character(ch); 
		else
			this.gender = new Character(' ');
	}
	public void setDOB(Calendar dob) { this.dob = dob; }
	public void setDOB(String dob) {
		Calendar newCal = Calendar.getInstance();
		try {
			int day = Integer.parseInt(dob.split("/")[0]);
			int month = Integer.parseInt(dob.split("/")[1]);
			int year = Integer.parseInt(dob.split("/")[2]);
			newCal.set(Calendar.YEAR,year);
			newCal.set(Calendar.MONTH,month);
			newCal.set(Calendar.DAY_OF_MONTH,day);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setDOB(newCal);
		System.out.println(this.dob.getTime());
	}
	public int getID(){ return id; }
	public int getAge(){
		return TimeDiff.getYears(Calendar.getInstance(),dob);
	}
	public void setContact(String contact) { this.contact = contact; }
	public Person getDetails() { return this; }
	public String toString() {
		return getFullName()+", Gender:"+getGender() +", Age:"+getAge();
	}
}