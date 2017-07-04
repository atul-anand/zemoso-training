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
		populateTimings();
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
		addPerson(new Person("Owen","Hunt",'M',"14/03/1966","9876543210"));
		addPerson(new Person("Miranda","Bailey",'F',"16/07/1975","7894561231"));
		addPerson(new Person("Richard","Burke",'M',"18/04/1968","8834515334"));
		addPerson(new Person("Steve","Grey",'M',"07/06/1977","7894351832"));
		addPerson(new Person("Tina","Shergil",'F',"06/08/1972","7896546789"));
		addPerson(new Person("James","Webber",'M',"04/09/1960","9874562134"));
		addPerson(new Person("Jesse","Avery",'F',"02/11/1969","8794678435"));
		addPerson(new Person("Erica","Pompeo",'M',"05/12/1965","9846134658"));
		addPerson(new Person("Kelly","Wilson",'F',"10/06/1967","7894656487"));
		addPerson(new Person("Martin","Henderson",'M',"17/08/1971","8756789462"));
		addPerson(new Person("Sara","Cook",'F',"18/07/1968","9874613548"));
		addPerson(new Person("Nathan","Riggs",'M',"16/06/1961","9875456783"));
		addPerson(new Person("Shane","Ross",'M',"29/10/1960","8797875465"));
		addPerson(new Person("Teddy","Altman",'F',"25/11/1959","8946892986"));
		addPerson(new Person("Mark","Dane",'M',"26/09/1964","8746564893"));
		addPerson(new Person("Mark","Dane",'M',"06/12/1965","9794465893"));
		addPerson(new Person("Rachel","McAdams",'F',"26/07/1967","7794564893"));
		addPerson(new Person("Clint","McCain",'M',"02/08/1964","7954234893"));
		addPerson(new Person("Sophie","Turner",'F',"27/10/1969","9874613893"));
		addPerson(new Person("Maisie","Williams",'F',"23/12/1968","8794654893"));
		addPerson(new Person("Debra","Morgan",'F',"25/11/1970","9826749893"));
		addPerson(new Person("Harvey","Spector",'M',"12/07/1972","7894564893"));
		addPerson(new Person("Preston","Michaels",'M',"19/06/1971","8794446693"));
		addPerson(new Person("Jane","Doe",'F',"15/04/1966","7896524548"));
		addPerson(new Person("Mark","Dane",'M',"14/06/1969","9789756462"));
	}
	public void populatePatients(){
		addPatient(new Patient(persons.get(0),Condition.Abdomen));
		addPatient(new Patient(persons.get(2),Condition.Bones));
		addPatient(new Patient(persons.get(5),Condition.Brain));
		addPatient(new Patient(persons.get(9),Condition.Bones));
		addPatient(new Patient(persons.get(10),Condition.Pregnancy));
		
	}
	public void populateDoctors(){
		addDoctor(new Doctor(persons.get(1),Speciality.Physician,Authority.Junior));
		addDoctor(new Doctor(persons.get(3),Speciality.Neurologist,Authority.Junior));
		addDoctor(new Doctor(persons.get(4),Speciality.Cardiothoracic,Authority.Junior));
		addDoctor(new Doctor(persons.get(8),Speciality.Dermatologist,Authority.Junior));
		addDoctor(new Doctor(persons.get(7),Speciality.Gynecologist,Authority.Junior));
		addDoctor(new Doctor(persons.get(6),Speciality.Pediatrician,Authority.Junior));
		addDoctor(new Doctor(persons.get(11),Speciality.Psychiatrist,Authority.Junior));
		addDoctor(new Doctor(persons.get(12),Speciality.Orthopaedic,Authority.Junior));
		addDoctor(new Doctor(persons.get(13),Speciality.Opthalmologist,Authority.Junior));
		addDoctor(new Doctor(persons.get(14),Speciality.Radiologist,Authority.Junior));
		addDoctor(new Doctor(persons.get(18),Speciality.Orthopaedic,Authority.Senior));
		addDoctor(new Doctor(persons.get(16),Speciality.Pediatrician,Authority.Senior));
		addDoctor(new Doctor(persons.get(17),Speciality.Physician,Authority.Senior));
		addDoctor(new Doctor(persons.get(23),Speciality.Neurologist,Authority.Senior));
		addDoctor(new Doctor(persons.get(22),Speciality.Cardiothoracic,Authority.Senior));
		addDoctor(new Doctor(persons.get(20),Speciality.Dermatologist,Authority.Senior));
		addDoctor(new Doctor(persons.get(15),Speciality.Gynecologist,Authority.Senior));
		addDoctor(new Doctor(persons.get(19),Speciality.Pediatrician,Authority.Senior));
		addDoctor(new Doctor(persons.get(21),Speciality.Psychiatrist,Authority.Senior));
		addDoctor(new Doctor(persons.get(24),Speciality.Orthopaedic,Authority.Senior));			
	}
	public void populateTimings(){
		doctors.get(0).addTiming(new Timing("Wed,12:00 PM","Wed,06:00 PM"));
		doctors.get(0).addTiming(new Timing("Mon,08:00 AM","Mon,02:00 PM"));
		doctors.get(0).addTiming(new Timing("Fri,10:00 AM","Fri,04:00 PM"));
		doctors.get(0).addTiming(new Timing("Sun,09:00 AM","Sun,03:00 PM"));
		doctors.get(1).addTiming(new Timing("Tue,12:00 PM","Tue,06:00 PM"));
		doctors.get(1).addTiming(new Timing("Mon,08:00 AM","Mon,02:00 PM"));
		doctors.get(1).addTiming(new Timing("Thu,10:00 AM","Thu,04:00 PM"));
		doctors.get(2).addTiming(new Timing("Sat,09:00 AM","Sat,03:00 PM"));
		doctors.get(2).addTiming(new Timing("Tue,12:00 PM","Tue,06:00 PM"));
		doctors.get(2).addTiming(new Timing("Mon,08:00 AM","Mon,02:00 PM"));
		doctors.get(3).addTiming(new Timing("Fri,10:00 AM","Fri,04:00 PM"));
		doctors.get(3).addTiming(new Timing("Sun,09:00 AM","Sun,03:00 PM"));
		doctors.get(4).addTiming(new Timing("Wed,12:00 PM","Wed,06:00 PM"));
		doctors.get(5).addTiming(new Timing("Mon,08:00 AM","Mon,02:00 PM"));
		doctors.get(5).addTiming(new Timing("Fri,10:00 AM","Fri,04:00 PM"));
		doctors.get(5).addTiming(new Timing("Sun,09:00 AM","Sun,03:00 PM"));
		doctors.get(6).addTiming(new Timing("Tue,12:00 PM","Tue,06:00 PM"));
		doctors.get(6).addTiming(new Timing("Mon,08:00 AM","Mon,02:00 PM"));
		doctors.get(7).addTiming(new Timing("Thu,10:00 AM","Thu,04:00 PM"));
		doctors.get(7).addTiming(new Timing("Sat,09:00 AM","Sat,03:00 PM"));
		doctors.get(7).addTiming(new Timing("Tue,12:00 PM","Tue,06:00 PM"));
		doctors.get(8).addTiming(new Timing("Mon,08:00 AM","Mon,02:00 PM"));
		doctors.get(8).addTiming(new Timing("Fri,10:00 AM","Fri,04:00 PM"));
		doctors.get(8).addTiming(new Timing("Sun,09:00 AM","Sun,03:00 PM"));
		doctors.get(9).addTiming(new Timing("Wed,12:00 PM","Wed,06:00 PM"));
		doctors.get(9).addTiming(new Timing("Mon,08:00 AM","Mon,02:00 PM"));
		doctors.get(9).addTiming(new Timing("Fri,10:00 AM","Fri,04:00 PM"));
		doctors.get(10).addTiming(new Timing("Wed,12:00 PM","Wed,02:00 PM"));
		doctors.get(10).addTiming(new Timing("Mon,08:00 AM","Mon,10:00 AM"));
		doctors.get(10).addTiming(new Timing("Fri,10:00 AM","Fri,12:00 PM"));
		doctors.get(11).addTiming(new Timing("Sun,09:00 AM","Sun,11:00 AM"));
		doctors.get(11).addTiming(new Timing("Tue,12:00 PM","Tue,02:00 PM"));
		doctors.get(11).addTiming(new Timing("Mon,08:00 AM","Mon,10:00 AM"));
		doctors.get(11).addTiming(new Timing("Thu,10:00 AM","Thu,12:00 PM"));
		doctors.get(12).addTiming(new Timing("Sat,09:00 AM","Sat,11:00 AM"));
		doctors.get(12).addTiming(new Timing("Tue,12:00 PM","Tue,02:00 PM"));
		doctors.get(12).addTiming(new Timing("Mon,08:00 AM","Mon,10:00 AM"));
		doctors.get(13).addTiming(new Timing("Fri,10:00 AM","Fri,12:00 PM"));
		doctors.get(13).addTiming(new Timing("Sun,09:00 AM","Sun,11:00 AM"));
		doctors.get(14).addTiming(new Timing("Wed,12:00 PM","Wed,02:00 PM"));
		doctors.get(15).addTiming(new Timing("Mon,08:00 AM","Mon,10:00 AM"));
		doctors.get(15).addTiming(new Timing("Fri,10:00 AM","Fri,12:00 PM"));
		doctors.get(15).addTiming(new Timing("Sun,09:00 AM","Sun,11:00 AM"));
		doctors.get(16).addTiming(new Timing("Tue,12:00 PM","Tue,02:00 PM"));
		doctors.get(16).addTiming(new Timing("Mon,08:00 AM","Mon,10:00 PM"));
		doctors.get(17).addTiming(new Timing("Thu,10:00 AM","Thu,12:00 PM"));
		doctors.get(17).addTiming(new Timing("Sat,09:00 AM","Sat,11:00 AM"));
		doctors.get(17).addTiming(new Timing("Tue,12:00 PM","Tue,02:00 PM"));
		doctors.get(18).addTiming(new Timing("Mon,08:00 AM","Mon,10:00 AM"));
		doctors.get(18).addTiming(new Timing("Fri,10:00 AM","Fri,12:00 PM"));
		doctors.get(18).addTiming(new Timing("Sun,09:00 AM","Sun,11:00 AM"));
		doctors.get(19).addTiming(new Timing("Wed,12:00 PM","Wed,02:00 PM"));
		doctors.get(19).addTiming(new Timing("Mon,08:00 AM","Mon,10:00 AM"));
		doctors.get(19).addTiming(new Timing("Fri,10:00 AM","Fri,12:00 PM"));
	}
	public List<Person> getPersons() { return persons; }
	public List<Patient> getPatients() { return patients; }
	public List<Doctor> getDoctors() { return doctors; }
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
	// Call the method to add week offset from 1st Jan 2017 availabilities.
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