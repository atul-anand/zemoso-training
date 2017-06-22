import java.util.*;
public class Doctor extends Person{
	private static int counter = 0;
	private final int id = counter++;
	//private Person person;
	private Speciality speciality;
	private Set<Appointment> appointments;
	public Doctor(Person person, Speciality speciality){
		super(person);
		this.speciality = speciality;
		this.appointments = new TreeSet<Appointment>(new AppointmentComparator());
	}
	public Speciality getSpeciality() { return this.speciality; }
	public Set<Appointment> getAppointments() { return this.appointments; }
	public void addAppointment(Appointment appointment) { appointments.add(appointment); }
	public int getID() { return this.id; }
	public String toString() {
		return "id: " + getID() + " Dr. " + super.toString()+",Speciality:"+getSpeciality();
	}
}