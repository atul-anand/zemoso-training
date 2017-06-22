import java.util.*;
public class AppointmentPortal {
	private List<Person> persons;
	private List<Patient> patients;
	private List<Doctor> doctors;
	AppointmentPortal(){
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
		addDoctor(new Doctor(persons.get(0),Speciality.Physician));

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
	public List<Doctor> getDoctorsWithSpeciality(Speciality speciality){
		List<Doctor> specialisedDoctors = new ArrayList<Doctor>();
		for(Doctor doc:doctors){
			if(doc.getSpeciality()==speciality)
				specialisedDoctors.add(doc);
		}
		return specialisedDoctors;
	}
	private Appointment earliestNewAppointment(List<Doctor> specialisedDoctors, Patient patient){
		Set<Appointment> appointments = new TreeSet<Appointment>(new AppointmentComparator());
		for(Doctor doc : specialisedDoctors)
			for(Appointment app : doc.getAppointments())
				appointments.add(app);
		



		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		Appointment app = new Appointment(patient,specialisedDoctors.get(0),start);
		return app;
	}
	public void makeAppointment(Patient patient){
		Speciality spec = getSpecialityFromCondition(Condition.valueOf(patient.getCondition()));
		List<Doctor> specialisedDoctors = getDoctorsWithSpeciality(spec);
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
}