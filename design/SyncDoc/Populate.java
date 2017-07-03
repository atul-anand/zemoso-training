import java.util.*;
public class Populate{
	protected List<Person> persons;
	protected List<Patient> patients;
	protected List<Doctor> doctors;
	public Populate(){
		persons = new ArrayList<Person>();
		patients = new ArrayList<Patient>();
		doctors = new ArrayList<Doctor>();
		populatePersons();
		populatePatients();
		populateDoctors();
	}
	public void addPerson(Person per){
		if(!personPresent(persons,per)){
			persons.add(per);
			System.out.println(per + " added in database.");
		}
		else
			System.out.println(per + " already in database.");
	}
	public void addDoctor(Doctor doc) { 
		if(personPresent(persons, doc))
			if(!personPresent(doctors,doc))
				doctors.add(doc); 
			else
				System.out.println(doc + " already in database.");
		else{
			persons.add(doc.getDetails());
			doctors.add(doc);
			System.out.println(doc + " added in database.");
		}
	}
	public void addPatient(Patient pat) { 
		if(personPresent(persons, pat))
			if(!personPresent(patients,pat))
				patients.add(pat); 
			else
				System.out.println(pat + " already in database.");
		else{
			persons.add(pat.getDetails());
			patients.add(pat);
			System.out.println(pat + " added in database.");
		}
	}
	public void populatePersons(){
		addPerson(new Person("ABC","XYZ",'M',"14/03/1987","9876543210"));
	}
	public void populatePatients(){
		addPatient(new Patient(persons.get(0),Condition.Abdomen));
	}
	public void populateDoctors(){
		addDoctor(new Doctor(persons.get(0),Speciality.Physician,Authority.Junior));
	}
	public void printPersons(){
		for(Person per : persons)
			System.out.println(per);
	}
	public void printPatients(){
		for(Patient pat : patients)
			System.out.println(pat);
	}
	public void printDoctors(){
		for(Doctor doc : doctors)
			System.out.println(doc);
	}
	public void addAvailability(int week){
		for(Doctor doc : doctors)
			doc.extendTiming(week);
	}
	private boolean personPresent(Collection<?> list, Object entry){
		for(Object obj:list)
			if(entry.toString().equals(obj.toString()))
				return true;
		return false;
	}
}