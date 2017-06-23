import java.util.*;
public class AppointmentPortal {
	private List<Person> persons;
	private List<Patient> patients;
	private List<Doctor> doctors;
	AppointmentPortal(){
		persons = new ArrayList<Person>();
		patients = new ArrayList<Patient>();
		doctors = new ArrayList<Doctor>();
		populatePersons();
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
	private boolean personPresent(Collection<?> list, Object entry){
		for(Object obj:list)
			if(entry.toString().equals(obj.toString()))
				return true;
		return false;
	}
	public Speciality getSpecialityFromCondition(Condition condition){
		List<Condition> cond = new ArrayList<Condition>(Arrays.asList(Condition.values()));
		List<Speciality> spec = new ArrayList<Speciality>(Arrays.asList(Speciality.values()));
		int i=0;
		while(i<cond.size()){
			if(cond.get(i)==condition)
				break;
			i++;
		}
		return spec.get(i);
	}
	public Set<Doctor> getDoctors(Speciality speciality, Authority authority){
		Set<Doctor> specialisedDoctors = new TreeSet<Doctor>(new DoctorComparator());
		for(Doctor doc:doctors){
			if(doc.getSpeciality()==speciality&&doc.getAuthority()==authority)
				specialisedDoctors.add(doc);
		}
		return specialisedDoctors;
	}
	public Appointment earliestNewAppointment(Set<Doctor> specializedDoctors, Patient patient){
		Set<Appointment> totalAppointments = new TreeSet<Appointment>(new AppointmentComparator());
		for(Doctor doc : specializedDoctors){
			Set<Timing> docTimes = doc.getTimings();
			Set<Timing> patTimes = patient.getTimings();
			for(Timing docTime : docTimes){
				for(Timing patTime : patTimes){
					Calendar docStart = docTime.getStartTime();
					Calendar docEnd = docTime.getEndTime();
					Calendar patStart = patTime.getStartTime();
					Calendar patEnd = patTime.getEndTime();
					if(TimeDiff.getMinutes(patStart,docStart)<=0&&TimeDiff.getMinutes(docEnd,patEnd)<=0)
						totalAppointments.add(new Appointment(patient,doc,docTime));
				}
			}
		}

		return totalAppointments.iterator().next();
	}
	public void makeAppointment(Patient patient, Authority authority){
		Speciality spec = getSpecialityFromCondition((patient.getCondition()));
		Set<Doctor> specialisedDoctors = getDoctors(spec,authority);
		if(specialisedDoctors.size()==0){
			System.out.println("No doctors available.");
			return;
		}
		Appointment appointment = earliestNewAppointment(specialisedDoctors,patient);
		Doctor doc = appointment.getDoctor();
		for(Doctor d:doctors)
			if(doc.toString().equals(d.toString())){
				d.addAppointment(appointment);
				break;
			}
		System.out.println("Appointment for " + appointment + " approved.");
	}
	public String toString(){
		return "Welcome to ABC Hospital Appointment Booking Portal.";
	}
}