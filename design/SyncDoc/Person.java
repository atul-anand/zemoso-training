import java.util.*;
import java.time.*;
public class Person {
	private static int counter = 0;
	private final int id = counter++;
	private String firstName;
	private String lastName;
	private Character gender;
	private LocalDate dob;
	private String contact;
	public Person(){
		firstName = "Mark";
		lastName = "Anthony";
		gender = 'M';
		dob = LocalDate.now();
		contact = "9876543210";
	}
	public Person(Boolean bool){
		this();
		if(bool){
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter First Name:");
			setFirstName(scanner.nextLine());
			System.out.print("Enter Last Name:");
			setLastName(scanner.nextLine());
			System.out.print("Enter Gender(M/F):");
			setGender(scanner.nextLine().charAt(0));
			System.out.print("Enter DOB(DD/MM/YYYY):");
			setDOB(scanner.nextLine());
			System.out.print("Enter Contact Details:");
			setContact(scanner.nextLine());
		}	
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
	public LocalDate getDOB() { return dob; }
	public String getContact() { return contact; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public void setGender(char ch) { 
		if(ch=='M'||ch=='F')
			this.gender = new Character(ch); 
		else
			this.gender = new Character(' ');
	}
	public void setDOB(LocalDate dob) { this.dob = dob; }
	public void setDOB(String dob) {
		try {
			int day = Integer.parseInt(dob.substring(0,2));
			int month = Integer.parseInt(dob.substring(3,5));
			int year = Integer.parseInt(dob.substring(6,10));
			this.dob.of(year,month,day);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	public int getAge(){
		return Period.between(this.dob, LocalDate.now()).getYears();
	}
	public void setContact(String contact) { this.contact = contact; }
	public Person getDetails() { return this; }
	public String toString() {
		return getFullName()+",Age:"+getAge()+",Gender:"+getGender(); 
	}
}