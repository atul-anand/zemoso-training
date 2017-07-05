import java.io.*;
import java.util.*;
public class Populate {
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
		addPerson(new Person("Mark","Kane",'M',"26/09/1964","8746564893"));
		addPerson(new Person("Mark","Zane",'M',"06/12/1965","9794465893"));
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
		Doctor doc0 = doctors.get(0);
		Doctor doc1 = doctors.get(1);
		Doctor doc2 = doctors.get(2);
		Doctor doc3 = doctors.get(3);
		Doctor doc4 = doctors.get(4);
		Doctor doc5 = doctors.get(5);
		Doctor doc6 = doctors.get(6);
		Doctor doc7 = doctors.get(7);
		Doctor doc8 = doctors.get(8);
		Doctor doc9 = doctors.get(9);
		Doctor doc10 = doctors.get(10);
		Doctor doc11 = doctors.get(11);
		Doctor doc12 = doctors.get(12);
		Doctor doc13 = doctors.get(13);
		Doctor doc14 = doctors.get(14);
		Doctor doc15 = doctors.get(15);
		Doctor doc16 = doctors.get(16);
		Doctor doc17 = doctors.get(17);
		Doctor doc18 = doctors.get(18);
		Doctor doc19 = doctors.get(19);
		doc0.addTiming(new Timing("Wed,12:00 PM","Wed,06:00 PM"));
		doc0.addTiming(new Timing("Mon,08:00 AM","Mon,02:00 PM"));
		doc0.addTiming(new Timing("Fri,10:00 AM","Fri,04:00 PM"));
		doc0.addTiming(new Timing("Sun,09:00 AM","Sun,03:00 PM"));
		doc1.addTiming(new Timing("Tue,12:00 PM","Tue,06:00 PM"));
		doc1.addTiming(new Timing("Mon,08:00 AM","Mon,02:00 PM"));
		doc1.addTiming(new Timing("Thu,10:00 AM","Thu,04:00 PM"));
		doc2.addTiming(new Timing("Sat,09:00 AM","Sat,03:00 PM"));
		doc2.addTiming(new Timing("Tue,12:00 PM","Tue,06:00 PM"));
		doc2.addTiming(new Timing("Mon,08:00 AM","Mon,02:00 PM"));
		doc3.addTiming(new Timing("Fri,10:00 AM","Fri,04:00 PM"));
		doc3.addTiming(new Timing("Sun,09:00 AM","Sun,03:00 PM"));
		doc4.addTiming(new Timing("Wed,12:00 PM","Wed,06:00 PM"));
		doc5.addTiming(new Timing("Mon,08:00 AM","Mon,02:00 PM"));
		doc5.addTiming(new Timing("Fri,10:00 AM","Fri,04:00 PM"));
		doc5.addTiming(new Timing("Sun,09:00 AM","Sun,03:00 PM"));
		doc6.addTiming(new Timing("Tue,12:00 PM","Tue,06:00 PM"));
		doc6.addTiming(new Timing("Mon,08:00 AM","Mon,02:00 PM"));
		doc7.addTiming(new Timing("Thu,10:00 AM","Thu,04:00 PM"));
		doc7.addTiming(new Timing("Sat,09:00 AM","Sat,03:00 PM"));
		doc7.addTiming(new Timing("Tue,12:00 PM","Tue,06:00 PM"));
		doc8.addTiming(new Timing("Mon,08:00 AM","Mon,02:00 PM"));
		doc8.addTiming(new Timing("Fri,10:00 AM","Fri,04:00 PM"));
		doc8.addTiming(new Timing("Sun,09:00 AM","Sun,03:00 PM"));
		doc9.addTiming(new Timing("Wed,12:00 PM","Wed,06:00 PM"));
		doc9.addTiming(new Timing("Mon,08:00 AM","Mon,02:00 PM"));
		doc9.addTiming(new Timing("Fri,10:00 AM","Fri,04:00 PM"));
		doc10.addTiming(new Timing("Wed,12:00 PM","Wed,02:00 PM"));
		doc10.addTiming(new Timing("Mon,08:00 AM","Mon,10:00 AM"));
		doc10.addTiming(new Timing("Fri,10:00 AM","Fri,12:00 PM"));
		doc11.addTiming(new Timing("Sun,09:00 AM","Sun,11:00 AM"));
		doc11.addTiming(new Timing("Tue,12:00 PM","Tue,02:00 PM"));
		doc11.addTiming(new Timing("Mon,08:00 AM","Mon,10:00 AM"));
		doc11.addTiming(new Timing("Thu,10:00 AM","Thu,12:00 PM"));
		doc12.addTiming(new Timing("Sat,09:00 AM","Sat,11:00 AM"));
		doc12.addTiming(new Timing("Tue,12:00 PM","Tue,02:00 PM"));
		doc12.addTiming(new Timing("Mon,08:00 AM","Mon,10:00 AM"));
		doc13.addTiming(new Timing("Fri,10:00 AM","Fri,12:00 PM"));
		doc13.addTiming(new Timing("Sun,09:00 AM","Sun,11:00 AM"));
		doc14.addTiming(new Timing("Wed,12:00 PM","Wed,02:00 PM"));
		doc15.addTiming(new Timing("Mon,08:00 AM","Mon,10:00 AM"));
		doc15.addTiming(new Timing("Fri,10:00 AM","Fri,12:00 PM"));
		doc15.addTiming(new Timing("Sun,09:00 AM","Sun,11:00 AM"));
		doc16.addTiming(new Timing("Tue,12:00 PM","Tue,02:00 PM"));
		doc16.addTiming(new Timing("Mon,08:00 AM","Mon,10:00 PM"));
		doc17.addTiming(new Timing("Thu,10:00 AM","Thu,12:00 PM"));
		doc17.addTiming(new Timing("Sat,09:00 AM","Sat,11:00 AM"));
		doc17.addTiming(new Timing("Tue,12:00 PM","Tue,02:00 PM"));
		doc18.addTiming(new Timing("Mon,08:00 AM","Mon,10:00 AM"));
		doc18.addTiming(new Timing("Fri,10:00 AM","Fri,12:00 PM"));
		doc18.addTiming(new Timing("Sun,09:00 AM","Sun,11:00 AM"));
		doc19.addTiming(new Timing("Wed,12:00 PM","Wed,02:00 PM"));
		doc19.addTiming(new Timing("Mon,08:00 AM","Mon,10:00 AM"));
		doc19.addTiming(new Timing("Fri,10:00 AM","Fri,12:00 PM"));
		List<Doctor> newDoctors = new ArrayList<Doctor>();
		newDoctors.add(doc0);
		newDoctors.add(doc1);
		newDoctors.add(doc2);
		newDoctors.add(doc3);
		newDoctors.add(doc4);
		newDoctors.add(doc5);
		newDoctors.add(doc6);
		newDoctors.add(doc7);
		newDoctors.add(doc8);
		newDoctors.add(doc9);
		newDoctors.add(doc10);
		newDoctors.add(doc11);
		newDoctors.add(doc12);
		newDoctors.add(doc13);
		newDoctors.add(doc14);
		newDoctors.add(doc15);
		newDoctors.add(doc16);
		newDoctors.add(doc17);
		newDoctors.add(doc18);
		newDoctors.add(doc19);
		doctors = newDoctors;
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
	public void printTimings(){
		for(Doctor doc : doctors){
			System.out.println(doctors.indexOf(doc) + " " + doc);
			for(Timing timing : doc.getTimings())
				System.out.println(timing);
		}
	}
	private boolean personPresent(Collection<?> list, Object entry){
		for(Object obj:list)
			if(entry.toString().equals(obj.toString()))
				return true;
		return false;
	}
}